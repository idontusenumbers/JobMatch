package com.jobmatch.algorithm;

import com.jobmatch.models.JobPost;
import com.jobmatch.models.Skill;
import com.jobmatch.models.User;
import com.jobmatch.models.UserSkill;

import java.util.Set;

/**
 * Created by Emilia on 1/28/2016.
 */
public class Distance {

    //List<JobMatch> findMatchingJobs (User user, Set<JobPost> allJobPosts)
    //List<CandidateMatch> findMatchingCandidates (JobPost jobPost, Set<User> allUsers)
    //findDistance(User user, JobPost jobPost)

    private User user;
    private JobPost jobpost;

    public Distance(User us, JobPost jp){
        this.user = us;
        this.jobpost = jp;
    }

    public void findDistance(){
        //user.getSkills();
        //jobpost.getSkills();
    }

}
