package com.jobmatch.controllers;

import com.jobmatch.algorithm.CandidateScore;
import com.jobmatch.algorithm.JobCandidateEvaluator;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.RankedSkill;
import com.jobmatch.models.Role;
import com.jobmatch.models.Skill;
import com.jobmatch.models.User;
import com.jobmatch.repositories.SkillRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/jobs")
public class JobsController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listJobs(Model model) {
        switch (getCurrentUser().getRole().getId()) {
            case Role.ADMIN:
                Iterable<JobPost> allJobs = jobPostRepository.findAll();
                model.addAttribute("jobs", allJobs);
                return "/jobs/list"; // TODO once this controller is working, maybe we could make these redirects relative? I don't know if it works like that
            case Role.EMPLOYER:
                Iterable<JobPost> myJobs = jobPostRepository.findByCreator(getCurrentUser());
                model.addAttribute("jobs", myJobs);
                return "/jobs/list";
            case Role.SEEKER:
                List<CandidateScore> matchingJobs = JobCandidateEvaluator.findMatchingJobs(getCurrentUser(), jobPostRepository.findAll());
                model.addAttribute("jobs", matchingJobs);
                return "/jobs/scored-list";
        }
        throw new RuntimeException("Unknown Role");
    }

    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public String listFavoriteJobPosts(Model model) {
        model.addAttribute("posts", getCurrentUser().getFavePosts());
        return "/jobs/list";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createJob(Model model) {
        model.addAttribute("title", "Create job post");
        model.addAttribute("skillOptions", skillRepository.getMap());
        model.addAttribute("job", new JobPost());
        return "/jobs/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public View createJobPost(@ModelAttribute JobPost jobPost, String[] skills, String[] skillsRanks, Model model) {
        jobPost.setId(0);
        jobPost.setCreator(getCurrentUser());
        RankedSkill.updateSkillSet(skills, skillsRanks, jobPost.getSkills(), skillRepository);
        jobPostRepository.save(jobPost);
        return getRedirectView("/jobs/" + jobPost.getId());
    }

    @RequestMapping(value = "/{jobPostId}", method = RequestMethod.GET)
    public String viewJob(@PathVariable int jobPostId, Model model) {
        JobPost jobPost = jobPostRepository.findOne(jobPostId);

        model.addAttribute("job", jobPost);
        model.addAttribute("title", jobPost.getJobTitle());
        return "/jobs/view";
    }

    @RequestMapping(value = "/{jobPostId}/update", method = RequestMethod.GET)
    public String updateJob(@PathVariable int jobPostId, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());
        model.addAttribute("job", existingPost);
        model.addAttribute("skills", RankedSkill.getSkillsAndRanks(existingPost.getSkills()));
        model.addAttribute("skillOptions", skillRepository.getMap());
        model.addAttribute("title", "Update " + existingPost.getJobTitle());
        return "/jobs/edit";
    }

    @RequestMapping(value = "/{jobPostId}/update", method = RequestMethod.POST)
    public View updateJobPost(@PathVariable int jobPostId, @ModelAttribute JobPost jobPost, String[] skills, String[] skillsRanks, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());
        BeanUtils.copyProperties(jobPost, existingPost, "id", "creator", "users");

        RankedSkill.updateSkillSet(skills, skillsRanks, existingPost.getSkills(), skillRepository);

        jobPostRepository.save(existingPost);
        return getRedirectView("/jobs/" + jobPostId);
    }


    @RequestMapping(value = "/{jobPostId}/delete", method = RequestMethod.GET)
    public View deleteJob(@PathVariable int jobPostId, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());

        jobPostRepository.delete(existingPost);
        return getRedirectView("/jobs/");
    }


    @RequestMapping(value = "/{jobPostId}/candidates", method = RequestMethod.GET)
    public String findCandidates(@PathVariable int jobPostId, Model model) {
        JobPost job = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(job.getCreator());

        Iterable<User> seekers = userRepository.findByRoleId(Role.SEEKER);
        List<CandidateScore> matchingCandidates = JobCandidateEvaluator.findMatchingCandidates(job, seekers);

        model.addAttribute("job", job);
        model.addAttribute("candidates", matchingCandidates);

        return "/jobs/candidates";
    }


    @RequestMapping(value = "/{jobPostId}/favorite", method = RequestMethod.POST)
    public ResponseEntity setFavorite(@PathVariable int jobPostId, boolean favorited) {

        Set<JobPost> favePosts = getCurrentUser().getFavePosts();
        JobPost jobPost = jobPostRepository.findOne(jobPostId);

        if (favorited)
            favePosts.add(jobPost);
        else
            favePosts.remove(jobPost);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
