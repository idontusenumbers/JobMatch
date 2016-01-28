package com.jobmatch.models;

import com.jobmatch.Application;
import com.jobmatch.repositories.SkillRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by eric on 1/28/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest({"spring.jpa.hibernate.ddl-auto=create-drop","server.port=0"})
@WebAppConfiguration
public class SkillTest {

    @Autowired
    protected SkillRepository skillRepository;

    @Test
    public void can_save_skill_in_database() {
        Skill skill = new Skill("my new skill");
        Skill skillDb = skillRepository.save(skill);

        assertNotNull(skillDb);

        // make sure the save skill is not null
        assertNotNull(skillRepository.findByName("my new skill"));

        assertSame("my new skill", skillRepository.findOne(skillDb.getId()).getName());
    }

    @Test
    public void can_retrieve_skill_by_name() {
        Skill skill = new Skill("test2");
        skillRepository.save(skill);

        assertNotNull(skillRepository.findByName("test2"));
        // make sure the returned skill when searching by name is the same as the saved one
        assertEquals("test2", skillRepository.findByName("test2").getName());
    }
}