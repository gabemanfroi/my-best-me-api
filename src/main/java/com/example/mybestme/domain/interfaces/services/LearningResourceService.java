package com.example.mybestme.domain.interfaces.services;

import com.example.mybestme.domain.DTOS.LearningResourceDTO;

import java.util.List;

public interface LearningResourceService {

    List<LearningResourceDTO> getAllLearningResources();
}
