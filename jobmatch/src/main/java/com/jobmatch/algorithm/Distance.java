package com.jobmatch.algorithm;

import com.jobmatch.models.*;
import java.util.List;
import java.util.Set;

public class Distance {
    private static List<JobMatch> userMatchedToJobs;
    private static List<CandidateMatch> jobsMatchedToCandidates;

    static public List<JobMatch> findMatchingJobs(User user, Set<JobPost> allJobPosts) {
        for (JobPost jobpost : allJobPosts) {
            int distance = findDistance(user, jobpost);
            //Set<JobPostSkill> skills = allJobPost.getSkills();
            JobMatch jm = new JobMatch(user, jobpost, distance);
            userMatchedToJobs.add(jm);
        }
        return userMatchedToJobs;
    }

    static public List<CandidateMatch> findMatchingCandidates(JobPost jobPost, Set<User> allUsers) {
        for (User user : allUsers) {
            int distance = findDistance(user, jobPost);
            CandidateMatch cm = new CandidateMatch(user, jobPost, distance);
            jobsMatchedToCandidates.add(cm);
        }
        return jobsMatchedToCandidates;
    }


    /*
        This run time looks terrible!!!!!!!!!!!!!!
     */
    static public int findDistance(User user, JobPost jobPost) {
        int result = 0;
        Set<UserSkill> us = user.getSkills();
        Set<JobPostSkill> jps = jobPost.getSkills();

        for (JobPostSkill jp : jps) {
            Skill s = jp.getSkill();
            for (UserSkill u : us) {
                int r = u.getRank();
                if(jp.equals(u)){
                    result += Math.abs(jp.getRank()-u.getRank());
                }
            }
        }
        return result;
    }

}