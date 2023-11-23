package com.example.mybestme.domain.exceptions;

public class LearningResourceNotFoundException extends RuntimeException {
    public LearningResourceNotFoundException(Long id) {
        super("LearningResource not found with id: " + id);
    }
}
