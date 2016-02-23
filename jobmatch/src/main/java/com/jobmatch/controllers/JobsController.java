package com.jobmatch.controllers;

import com.jobmatch.algorithm.CandidateScore;
import com.jobmatch.algorithm.JobCandidateEvaluator;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import org.springframework.http.HttpHeaders;
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
        Iterable<JobPost> posts = null;
        switch (getCurrentUser().getRole().getId()) {
            case Role.ADMIN:
                posts = jobPostRepository.findAll();
                break;
            case Role.STUDENT:
                JobCandidateEvaluator.findMatchingJobs(getCurrentUser(), jobPostRepository.findAll());
                break;
            case Role.EMPLOYER:
                posts = jobPostRepository.findByCreator(getCurrentUser());
                break;
        }
        model.addAttribute("posts", posts);
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
        return "/jobs/edit";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public View createJob(@ModelAttribute JobPost jobPost, Model model) {
        jobPostRepository.save(jobPost);
        return getRedirectView("/jobs/" + jobPost.getId());
    }

    @RequestMapping(value = "/{jobPostId}", method = RequestMethod.GET)
    public String viewJob(@PathVariable int jobPostId, Model model) {
        JobPost jobPost = jobPostRepository.findOne(jobPostId);
        model.addAttribute("jobPost", jobPost);
        model.addAttribute("title", jobPost.getJobTitle());
        return "/jobs/view";
    }

    @RequestMapping(value = "/{jobPostId}/update", method = RequestMethod.GET)
    public String updateJob(@PathVariable int jobPostId, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());
        model.addAttribute("title", "Update " + existingPost.getJobTitle());
        return "/jobs/edit";
    }

    @RequestMapping(value = "/{jobPostId}/update", method = RequestMethod.POST)
    public View updateJob(@PathVariable int jobPostId, @ModelAttribute JobPost jobPost, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());
        jobPostRepository.save(jobPost);
        return getRedirectView("/jobs/" + jobPost.getId());
    }

    @RequestMapping(value = "/{jobPostId}/delete", method = RequestMethod.POST)
    public View deleteJob(@PathVariable int jobPostId, Model model) {
        JobPost existingPost = jobPostRepository.findOne(jobPostId);
        enforceSameUserUnlessAdmin(existingPost.getCreator());

        jobPostRepository.delete(existingPost);
        return getRedirectView("/jobs");
    }


    @RequestMapping(value = "/{jobPost}/candidates", method = RequestMethod.GET)
    public String findCandidates(@ModelAttribute JobPost jobPost, Model model) {
        enforceSameUserUnlessAdmin(jobPost.getCreator());

        List<CandidateScore> matchingCandidates =
                JobCandidateEvaluator.findMatchingCandidates(jobPost, userRepository.findByRole(Role.STUDENT));

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