package com.jobmatch.models;

import com.github.javafaker.Faker;
import com.jobmatch.Application;
import com.jobmatch.algorithm.CandidateScore;
import com.jobmatch.algorithm.JobCandidateEvaluator;
import com.jobmatch.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest({"spring.jpa.hibernate.ddl-auto=create-drop", "server.port=0"})
@WebAppConfiguration

public class AlgorithmTest {
    @Test
    public void user_matched_to_jobs() {
        User user = new User(null, "Jane", "Doe", true);

        Skill skill1 = new Skill("Python");
        Skill skill2 = new Skill("Java");
        Skill skill3 = new Skill("C#");
        Skill skill4 = new Skill("SQL");
        Skill skill5 = new Skill("HTML/CSS");

        UserSkill userSkill1 = new UserSkill(skill1, 1);
        user.skills.add(userSkill1);
        UserSkill userSkill2 = new UserSkill(skill2, 2);
        user.skills.add(userSkill2);
        UserSkill userSkill3 = new UserSkill(skill3, 3);
        user.skills.add(userSkill3);
        UserSkill userSkill4 = new UserSkill(skill4, 4);
        user.skills.add(userSkill4);
        UserSkill userSkill5 = new UserSkill(skill5, 5);
        user.skills.add(userSkill5);

        JobPost jobPostA = new JobPost("Engineer", "USA", "Bank", "Full time", 1);
        UserSkill jobSkillA1 = new UserSkill(skill1, 1);
        jobPostA.skills.add(jobSkillA1);
        UserSkill jobSkillA2 = new UserSkill(skill2, 2);
        jobPostA.skills.add(jobSkillA2);
        UserSkill jobSkillA3 = new UserSkill(skill5, 3);
        jobPostA.skills.add(jobSkillA3);
        UserSkill jobSkillA4 = new UserSkill(skill4, 4);
        jobPostA.skills.add(jobSkillA4);
        UserSkill jobSkillA5 = new UserSkill(skill3, 5);
        jobPostA.skills.add(jobSkillA5);

        JobPost jobPostB = new JobPost("Programmer", "USA", "Cell Phone", "Full time", 1);
        UserSkill jobSkillB1 = new UserSkill(skill5, 1);
        jobPostB.skills.add(jobSkillB1);
        UserSkill jobSkillB2 = new UserSkill(skill3, 2);
        jobPostB.skills.add(jobSkillB2);
        UserSkill jobSkillB3 = new UserSkill(skill1, 3);
        jobPostB.skills.add(jobSkillB3);
        UserSkill jobSkillB4 = new UserSkill(skill4, 4);
        jobPostB.skills.add(jobSkillB4);
        UserSkill jobSkillB5 = new UserSkill(skill2, 5);
        jobPostB.skills.add(jobSkillB5);

        List<JobPost> jp = new ArrayList<>();
        jp.add(jobPostA);
        jp.add(jobPostB);

        List<CandidateScore> expected = JobCandidateEvaluator.findMatchingJobs(user,jp);
        List<CandidateScore> actual = new ArrayList<>();
        //actual.add()
        assertSame(expected, actual);
    }
}