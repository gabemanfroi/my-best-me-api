package com.example.mybestme.domain.services;

import com.example.mybestme.domain.DTOS.LearningResourceDTO;
import com.example.mybestme.domain.interfaces.repositories.LearningResourceRepository;
import com.example.mybestme.domain.interfaces.services.LearningResourceService;
import com.example.mybestme.infrastructure.mappers.LearningResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningResourceServiceServiceImpl implements LearningResourceService {

    private final LearningResourceRepository learningResourceRepository;

    @Autowired
    private LearningResourceMapper learningResourceMapper;

    @Autowired
    public LearningResourceServiceServiceImpl(LearningResourceRepository learningResourceRepository) {
        this.learningResourceRepository = learningResourceRepository;
    }

    @Override
    public List<LearningResourceDTO> getAllLearningResources() {
        return this.learningResourceMapper.mapMultipleEntitiesToDTOs(this.learningResourceRepository.findAll());
    }
}
