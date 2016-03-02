package com.jobmatch.repositories;

import com.jobmatch.models.Culture;
import com.jobmatch.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CultureRepositoryImpl {

    @Autowired
    CultureRepository cultureRepository;

    public Map<String, String> getMap(){
        return StreamSupport.stream(cultureRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(culture -> String.valueOf(culture.getId()), Culture::getName));
    }
}
