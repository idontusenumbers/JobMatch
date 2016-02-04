package com.jobmatch.algorithm;

import com.jobmatch.models.JobPost;
import com.jobmatch.models.User;

/**
 * Created by Emilia on 1/28/2016.
 */
public class CandidateMatch {
    private User user;
    private JobPost jobpost;
    private int match;

    public CandidateMatch(User u, JobPost jp, int m){
        user = u;
        jobpost = jp;
        match = m;
    }
}
