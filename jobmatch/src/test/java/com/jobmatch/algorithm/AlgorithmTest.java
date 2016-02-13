package com.jobmatch.algorithm;

import com.jobmatch.Application;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.Skill;
import com.jobmatch.models.User;
import com.jobmatch.models.UserSkill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest({"spring.jpa.hibernate.ddl-auto=create-drop", "server.port=0"})
@WebAppConfiguration

public class AlgorithmTest {
    @Test
    public void user_matched_to_jobs() {
        User user = new User(null, "Jane", "Doe", true);

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
        }

        JobPost jobPostA = new JobPost("Engineer", "USA", "Bank", "Full time", 1);
        i = 1;
        for (Skill skill : skills) {
            // This will rank the skills as 1 .. 5 (according to the size of the list)
            jobPostA.getSkills().add(new UserSkill(skill, i));
        }

        JobPost jobPostB = new JobPost("Programmer", "USA", "Cell Phone", "Full time", 1);
        i = 1;
        for (Skill skill : skills) {
            // This will rank the skills as 1 .. 5 (according to the size of the list)
            jobPostB.getSkills().add(new UserSkill(skill, i));
        }

        List<JobPost> jp = new ArrayList<>();
        jp.add(jobPostA);
        jp.add(jobPostB);

        List<CandidateScore> expected = JobCandidateEvaluator.findMatchingJobs(user,jp);
        List<CandidateScore> actual = new ArrayList<>();
        //actual.add()
        assertSame(expected, actual);
    }
}