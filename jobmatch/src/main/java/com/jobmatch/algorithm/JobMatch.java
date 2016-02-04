package com.jobmatch.algorithm;

import com.jobmatch.models.*;

/**
 * Created by Emilia on 1/28/2016.
 */
public class JobMatch {
    private User user;
    private JobPost jobpost;
    private int match;

    public JobMatch(User u, JobPost jp, int m){
        user = u;
        jobpost = jp;
        match = m;
    }
}
