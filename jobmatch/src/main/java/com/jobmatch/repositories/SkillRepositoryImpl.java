package com.jobmatch.repositories;

import com.jobmatch.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SkillRepositoryImpl {

    @Autowired
    SkillRepository skillRepository;

    public Map<String, String> getMap(){
        return StreamSupport.stream(skillRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(skill -> String.valueOf(skill.getId()), Skill::getName));
    }
}
