package com.jobmatch.algorithm;

import com.jobmatch.models.JobPost;
import com.jobmatch.models.RankedSkill;
import com.jobmatch.models.User;

import java.util.*;

public class JobCandidateEvaluator {

    public static final int CLOSENESS_THRESHOLD = 100;
    public static final Comparator<CandidateScore> JOB_MATCH_COMPARATOR = (o1, o2) -> o1.getCloseness() - o2.getCloseness();
    private static final int MIN_DISTANCE = 5;


    static public List<CandidateScore> findMatchingJobs(User user, Iterable<JobPost> allJobPosts) {
        List<CandidateScore> userMatchedToJobs = new ArrayList<>();

        for (JobPost jobpost : allJobPosts) {
            int distance = findDistance(user, jobpost);
            CandidateScore match = new CandidateScore(user, jobpost, distance);
            if (match.getCloseness() < CLOSENESS_THRESHOLD)
                userMatchedToJobs.add(match);
        }

        Collections.sort(userMatchedToJobs, JOB_MATCH_COMPARATOR);
        return userMatchedToJobs;
    }

    static public List<CandidateScore> findMatchingCandidates(JobPost jobPost, Iterable<User> allUsers) {
        List<CandidateScore> jobsMatchedToCandidates = new ArrayList<>();

        for (User user : allUsers) {
            int distance = findDistance(user, jobPost);
            CandidateScore match = new CandidateScore(user, jobPost, distance);
            if (match.getCloseness() < CLOSENESS_THRESHOLD)
                jobsMatchedToCandidates.add(match);
        }

        Collections.sort(jobsMatchedToCandidates, JOB_MATCH_COMPARATOR);
        return jobsMatchedToCandidates;
    }

    static public int findDistance(User user, JobPost jobPost) {
        int result = 0;
        Set<RankedSkill> us = user.getSkills();
        Set<RankedSkill> jps = jobPost.getSkills();

        // TODO using hashmaps might make this more efficient

        for (RankedSkill jp : jps) {
            for (RankedSkill u : us) {
                if (jp.equals(u)) {
                    result += Math.abs(jp.getRank() - u.getRank());
                }else{
                    result+=MIN_DISTANCE;
                }
            }
        }
        return result;
    }
}