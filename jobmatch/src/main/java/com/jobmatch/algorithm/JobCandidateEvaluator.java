package com.jobmatch.algorithm;

import com.jobmatch.models.JobPost;
import com.jobmatch.models.RankedSkill;
import com.jobmatch.models.RankedCulture;
import com.jobmatch.models.User;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class JobCandidateEvaluator {

    public static final int CLOSENESS_THRESHOLD = 8;
    public static final Comparator<CandidateScore> JOB_MATCH_COMPARATOR = (o1, o2) -> Float.compare(o1.getCloseness(), o2.getCloseness());
    private static final int MIN_DISTANCE = 5;


    static public List<CandidateScore> findMatchingJobs(User user, Iterable<JobPost> allJobPosts) {
        List<CandidateScore> userMatchedToJobs = new ArrayList<>();

        for (JobPost jobpost : allJobPosts) {
            float distance = findDistance(user, jobpost);
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
            float distance = findDistance(user, jobPost);
            CandidateScore match = new CandidateScore(user, jobPost, distance);
            if (match.getCloseness() < CLOSENESS_THRESHOLD)
                jobsMatchedToCandidates.add(match);
        }

        Collections.sort(jobsMatchedToCandidates, JOB_MATCH_COMPARATOR);
        return jobsMatchedToCandidates;
    }

    static public float findDistance(User user, JobPost jobPost) {
        Set<RankedSkill> us = user.getSkills();
        Set<RankedSkill> jps = jobPost.getSkills();
        Set<RankedCulture> ugc = user.getCultures();
        Set<RankedCulture> jpgc = jobPost.getCreator().getCompany().getCultures();

        HashSet<RankedSkill> hashsetUserSkill = new HashSet<>();
        HashSet<RankedSkill> hashsetJobSkill = new HashSet<>();
        HashSet<RankedCulture> hashsetUserCulture = new HashSet<>();
        HashSet<RankedCulture> hashsetJobCulture = new HashSet<>();

        float sumDistance = 0;
        int matchCount = 1;

        for (RankedSkill jp : jps) {
            float minDistance = MIN_DISTANCE / jps.size();
            sumDistance += minDistance;
            for (RankedSkill u : us) {
                if (jp.getSkill().equals(u.getSkill())) {
                    sumDistance -= minDistance;
                    sumDistance += Math.abs(jp.getRank() - u.getRank());
                    matchCount++;
                }
            }
        }

        for (RankedCulture j : jpgc) {
            float minDistance = MIN_DISTANCE / jpgc.size();
            sumDistance += minDistance;
            for (RankedCulture u : ugc) {
                if (j.getCulture().equals(u.getCulture())) {
                    sumDistance -= minDistance;
                    sumDistance += Math.abs(j.getRank() - u.getRank());
                    matchCount++;
                }
            }
        }
        float result = Math.round((sumDistance/matchCount)*10.0)/10.0f;
        return result;
    }
}