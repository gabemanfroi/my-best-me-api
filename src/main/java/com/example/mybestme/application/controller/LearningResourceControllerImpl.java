package com.example.mybestme.application.controller;

import com.example.mybestme.domain.DTOS.LearningResourceDTO;
import com.example.mybestme.domain.exceptions.LearningResourceNotFoundException;
import com.example.mybestme.domain.interfaces.controller.LearningResourceController;
import com.example.mybestme.domain.interfaces.services.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learning-resources")
public class LearningResourceControllerImpl implements LearningResourceController {

    private final LearningResourceService learningResourceService;

    @Autowired
    public LearningResourceControllerImpl(LearningResourceService learningResourceService) {
        this.learningResourceService = learningResourceService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<LearningResourceDTO>> getAllLearningResources() {
        return ResponseEntity.ok(this.learningResourceService.getAllLearningResources());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LearningResourceDTO> getLearningResourceById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.learningResourceService.getLearningResourceById(id));
        } catch (LearningResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<LearningResourceDTO> createLearningResource(@RequestBody LearningResourceDTO learningResourceDTO) {
        try {
            return ResponseEntity.ok(this.learningResourceService.createLearningResource(learningResourceDTO));
        } catch (LearningResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<LearningResourceDTO> updateLearningResource(@PathVariable Long id, @RequestBody LearningResourceDTO learningResourceDTO) {
        try {
            learningResourceDTO.setId(id);
            return ResponseEntity.ok(this.learningResourceService.updateLearningResource(learningResourceDTO));
        } catch (LearningResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLearningResource(@PathVariable Long id) {
        try {
            this.learningResourceService.deleteLearningResource(id);
            return ResponseEntity.noContent().build();
        } catch (LearningResourceNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
