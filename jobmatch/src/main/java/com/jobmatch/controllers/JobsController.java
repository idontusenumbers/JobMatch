package com.jobmatch.controllers;

import com.jobmatch.algorithm.CandidateScore;
import com.jobmatch.algorithm.JobCandidateEvaluator;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.JobSkill;
import com.jobmatch.models.Role;
import com.jobmatch.models.Skill;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        Iterable<JobPost> jobs = null;
        switch (getCurrentUser().getRole().getId()) {
            case Role.ADMIN:
                jobs = jobPostRepository.findAll();
                break;
            case Role.SEEKER:
                JobCandidateEvaluator.findMatchingJobs(getCurrentUser(), jobPostRepository.findAll());
                break;
            case Role.EMPLOYER:
                jobs = jobPostRepository.findByCreator(getCurrentUser());
                break;
        }
        model.addAttribute("jobs", jobs);
        return "/jobs/list"; // TODO once this controller is working, maybe we could make these redirects relative? I don't know if it works like that
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
    public View createJobPost(@ModelAttribute JobPost jobPost, Model model) {
        jobPost.setId(0);
        jobPost.setCreator(getCurrentUser());

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
//        model.addAttribute("skills", existingPost.getSkillList());
        model.addAttribute("skillOptions", skillRepository.getMap());
        model.addAttribute("title", "Update " + existingPost.getJobTitle());
        return "/jobs/edit";
    }

    @RequestMapping(value = "/{jobPostId}/update", method = RequestMethod.POST)
    public View updateJobPost(@PathVariable int jobPostId, @ModelAttribute JobPost jobPost, String[] skills, String[] ranks, BindingResult result, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());
        BeanUtils.copyProperties(jobPost, existingPost, "id", "creator", "users");
        for (JobSkill jobSkill : existingPost.getSkills()) {

        }
        existingPost.getSkills().clear();
        for (int i = 0; i < skills.length; i++) {

            String s = skills[i];
            if (!s.isEmpty()) {
                Skill skill = skillRepository.findOne(Integer.valueOf(s));
                JobSkill jobSkill = new JobSkill(skill, Integer.valueOf(ranks[i]));
                jobSkillRepository.save(jobSkill);
                existingPost.getSkills().add(jobSkill);
            }
        }

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


    @RequestMapping(value = "/{jobPost}/candidates", method = RequestMethod.GET)
    public String findCandidates(@ModelAttribute JobPost jobPost, Model model) {
        enforceSameUserUnlessAdmin(jobPost.getCreator());

        List<CandidateScore> matchingCandidates =
                JobCandidateEvaluator.findMatchingCandidates(jobPost, userRepository.findByRole(Role.SEEKER));

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
