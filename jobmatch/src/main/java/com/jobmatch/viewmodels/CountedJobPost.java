package com.jobmatch.viewmodels;

import com.jobmatch.algorithm.JobCandidateEvaluator;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.User;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CountedJobPost {
    private int count;
    private JobPost jobPost;

    public CountedJobPost(JobPost jobPost, int count) {
        this.count = count;
        this.jobPost = jobPost;
    }

    public int getCount() {
        return count;
    }

    public JobPost getJobPost() {
        return jobPost;
    }


    public static Iterable<CountedJobPost> countJobs(Iterable<JobPost> jobPosts, Iterable<User> seekers) {
        return StreamSupport.stream(jobPosts.spliterator(), false)
                .map(jobPost -> new CountedJobPost(jobPost, JobCandidateEvaluator.findMatchingCandidates(jobPost, seekers).size()))
                .collect(Collectors.toList());
    }

}
