package com.jobmatch.algorithm;

import com.jobmatch.Application;
import com.jobmatch.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest({"spring.jpa.hibernate.ddl-auto=create-drop", "server.port=0"})
@WebAppConfiguration

public class AlgorithmTest {
    @Test
    public void user_matched_to_jobs() {
        User user = new User(null, "Jane", "Doe", true, "email@domain.com");

        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Python"));
        skills.add(new Skill("Java"));
        skills.add(new Skill("C#"));
        skills.add(new Skill("SQL"));
        skills.add(new Skill("HTML/CSS"));

        int i = 1;
        for (Skill skill : skills) {
            // This will rank the skills as 1 .. 5 (according to the size of the list)
            user.getSkills().add(new UserSkill(skill, i));
            i++;
        }

        JobPost jobPostA = new JobPost("Engineer", "USA", "Bank", "Full time", 1);
        i = 1;
        for (Skill skill : skills) {
            // This will rank the skills as 1 .. 5 (according to the size of the list)
            jobPostA.getSkills().add(new JobSkill(skill, i));
            i++;
        }

        JobPost jobPostB = new JobPost("Programmer", "USA", "Cell Phone", "Full time", 1);
        i = 0;
        for (Skill skill : skills) {
            // This will rank the skills as 1 .. 5 (according to the size of the list)
            jobPostB.getSkills().add(new JobSkill(skill, i));
            i++;
        }

        List<JobPost> jp = new ArrayList<>();
        jp.add(jobPostA);
        jp.add(jobPostB);

        List<CandidateScore> generatedList = JobCandidateEvaluator.findMatchingJobs(user,jp);

        List<JobPost> expected = new ArrayList<>();
        List<JobPost> actual = new ArrayList<>();
        for (CandidateScore candidateScore : generatedList) {
            JobPost gjp = candidateScore.getJobPost();
            expected.add(gjp);
        }

        actual.add(jobPostA);
        actual.add(jobPostB);
        assertEquals(expected,actual);
    }
}