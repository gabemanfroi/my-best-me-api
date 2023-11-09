package com.example.mybestme.domain.interfaces.repositories;

import com.example.mybestme.domain.models.LearningResource;

import java.util.List;

public interface LearningResourceRepository {

    List<LearningResource> findAll();

    LearningResource findById(Long id);

    LearningResource save(LearningResource learningResource);

    LearningResource update(LearningResource learningResource);

    void deleteById(Long id);

}
