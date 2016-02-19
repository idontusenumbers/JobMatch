package com.jobmatch.models;

import com.github.javafaker.Faker;
import com.jobmatch.Application;
import com.jobmatch.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Locale;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest({"spring.jpa.hibernate.ddl-auto=create-drop", "server.port=0"})
@WebAppConfiguration
public class UserTest {

    @Autowired
    protected UserRepository userRepository;
    private Faker faker = new Faker(Locale.US);

    @Test
    public void can_save_user_in_database() {
        User user = new User(null, faker.name().firstName(), faker.name().fullName(), true, faker.internet().emailAddress());
        User userDB = userRepository.save(user);

        // if the model is not saved, it will have an id of 0
        assertNotEquals(user.getId(), 0);

        assertNotNull(userDB);
    }

    @Test
    public void can_fetch_user_from_database_with_user_id() {
        User user = new User(null, faker.name().firstName(), faker.name().fullName(), true, faker.internet().emailAddress());
        User userDB = userRepository.save(user);

        // if the model is not saved, it will have an id of 0
        assertNotEquals(user.getId(), 0);

        assertNotNull(userDB);

        // make sure that when we fetch the user, it is also not null
        assertNotNull(userRepository.findOne(user.getId()));

        userDB = userRepository.findOne(user.getId());
        assertEquals(user, userDB);
    }

    @Test
    public void can_fetch_user_from_database_with_username() {
        User user = new User(null, faker.name().firstName(), faker.name().fullName(), true, faker.internet().emailAddress());
        User userDB = userRepository.save(user);

        // if the model is not saved, it will have an id of 0
        assertNotEquals(user.getId(), 0);

        assertNotNull(userDB);

        // make sure that when we fetch the user, it is also not null
        assertNotNull(userRepository.findByUsername(user.getUsername()));

        userDB = userRepository.findByUsername(user.getUsername());
        assertEquals(user, userDB);
    }
}