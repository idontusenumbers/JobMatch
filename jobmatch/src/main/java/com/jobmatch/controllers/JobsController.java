package com.jobmatch.controllers;

import com.jobmatch.algorithm.CandidateScore;
import com.jobmatch.algorithm.JobCandidateEvaluator;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.RankedSkill;
import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import com.jobmatch.viewmodels.CountedJobPost;
import com.jobmatch.viewmodels.FavoritePayload;
import com.jobmatch.viewmodels.RankMap;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.Collections;
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

                model.addAttribute("countedMatches", CountedJobPost.countJobs(
                        jobPostRepository.findByCreator(getCurrentUser()), getSeekers()
                ));
                return "/jobs/counted-list";
            case Role.SEEKER:
                List<CandidateScore> matchingJobs = JobCandidateEvaluator.findMatchingJobs(getCurrentUser(), jobPostRepository.findAll());
                // sort in reverse order (higher closeness)
                matchingJobs.sort(Collections.reverseOrder());

                model.addAttribute("jobs", matchingJobs);
                model.addAttribute("noJobsMessage", "No matching jobs");
                return "/jobs/scored-list";
        }
        throw new RuntimeException("Unknown Role");
    }

    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public String listFavoriteJobPosts(Model model) {

        List<CandidateScore> matchingJobs = JobCandidateEvaluator.findMatchingJobs(getCurrentUser(), getCurrentUser().getFavePosts());
        model.addAttribute("jobs", matchingJobs);
        model.addAttribute("noJobsMessage", "You haven't favorited any jobs yet!");
        return "/jobs/scored-list";

    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createJob(Model model) {
        JobPost newJobPost = new JobPost();
        model.addAttribute("title", "Create job post");
        model.addAttribute("skills", new RankMap<>(newJobPost.getSkills()));
        model.addAttribute("skillOptions", skillRepository.getMap());
        model.addAttribute("jobPost", newJobPost);
        model.addAttribute("countries", JobPost.getCountries());
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

        model.addAttribute("jobPost", jobPost);
        model.addAttribute("title", jobPost.getJobTitle());
        model.addAttribute("skills", new RankMap<>(jobPost.getSkills()));
        return "/jobs/view";
    }

    @RequestMapping(value = "/{jobPostId}/update", method = RequestMethod.GET)
    public String updateJob(@PathVariable int jobPostId, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());
        model.addAttribute("jobPost", existingPost);
        model.addAttribute("skills", new RankMap<>(existingPost.getSkills()));
        model.addAttribute("skillOptions", skillRepository.getMap());
        model.addAttribute("title", "Update " + existingPost.getJobTitle());
        model.addAttribute("countries", JobPost.getCountries());
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

        List<CandidateScore> scoredCandidates = JobCandidateEvaluator.findMatchingCandidates(job, getSeekers());

        model.addAttribute("jobPost", job);
        model.addAttribute("scoredCandidates", scoredCandidates);

        return "/jobs/candidates";
    }

    private Iterable<User> getSeekers() {
        return userRepository.findByRoleId(Role.SEEKER);
    }


    @RequestMapping(value = "/favorite", method = RequestMethod.POST)
    public ResponseEntity setFavorite(@RequestBody FavoritePayload favoritePayload) {


        User currentUser = getCurrentUser();
        Set<JobPost> favePosts = currentUser.getFavePosts();
        JobPost jobPost = jobPostRepository.findOne(favoritePayload.getJobPostId());

        if (favoritePayload.getIsFavorite())
            favePosts.add(jobPost);
        else
            favePosts.remove(jobPost);
        userRepository.save(currentUser);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
