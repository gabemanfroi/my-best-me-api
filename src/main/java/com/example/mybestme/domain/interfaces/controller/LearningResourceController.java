package com.example.mybestme.domain.interfaces.controller;

import com.example.mybestme.domain.DTOS.LearningResourceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LearningResourceController {
    ResponseEntity<List<LearningResourceDTO>> getAllLearningResources();

    ResponseEntity<LearningResourceDTO> getLearningResourceById(@PathVariable Long id);

    ResponseEntity<LearningResourceDTO> createLearningResource(@RequestBody LearningResourceDTO learningResourceDTO);

    ResponseEntity<LearningResourceDTO> updateLearningResource(@PathVariable Long id, @RequestBody LearningResourceDTO learningResourceDTO);

    ResponseEntity<Void> deleteLearningResource(@PathVariable Long id);
}
