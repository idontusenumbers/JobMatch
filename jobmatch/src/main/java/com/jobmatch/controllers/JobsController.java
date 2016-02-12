package com.jobmatch.controllers;

import com.jobmatch.algorithm.CandidateScore;
import com.jobmatch.algorithm.JobCandidateEvaluator;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.Role;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobsController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listJobs(@ModelAttribute JobPost jobPost, Model model) {
        Iterable<JobPost> posts = null;
        switch (getCurrentUser().getRole().getId()){
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


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createJob(@ModelAttribute JobPost jobPost, Model model) {
        jobPostRepository.save(jobPost);
        return "redirect:/jobs/" + jobPost.getId();
    }

    @RequestMapping(value = "/{jobPostId}", method = RequestMethod.GET)
    public String viewJob(@ModelAttribute JobPost jobPost, Model model) {
        model.addAttribute("title", jobPost.getJobTitle());
        return "/jobs/view";
    }

    @RequestMapping(value = "/{jobPost}/update", method = RequestMethod.PUT)
    public String updateJob(@ModelAttribute JobPost jobPost, Model model) {
        if (!jobPost.getCreator().equals(getCurrentUser()))
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        jobPostRepository.save(jobPost);
        return "redirect:/jobs/" + jobPost.getId();
    }

    @RequestMapping(value = "/{jobPost}/delete", method = RequestMethod.DELETE)
    public String deleteJob(@ModelAttribute JobPost jobPost, Model model) {
        if (!jobPost.getCreator().equals(getCurrentUser()))
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        jobPostRepository.delete(jobPost);
        return "redirect:/jobs";
    }


    @RequestMapping(value = "/{jobPost}/candidates", method = RequestMethod.GET)
    public String findCandidates(@ModelAttribute JobPost jobPost, Model model) {
        if (!jobPost.getCreator().equals(getCurrentUser()))
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);

        List<CandidateScore> matchingCandidates =
                JobCandidateEvaluator.findMatchingCandidates(jobPost, userRepository.findByRole(Role.STUDENT));

        model.addAttribute("candidates", matchingCandidates);

        return "/jobs/candidates";
    }



}