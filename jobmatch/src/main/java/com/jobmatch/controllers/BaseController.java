package com.jobmatch.controllers;

import com.jobmatch.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected RoleRepository roleRepository;
    @Autowired
    protected SkillRepository skillRepository;
    @Autowired
    protected EducationRepository educationRepository;
    @Autowired
    protected JobPostRepository jobPostRepository;
}
