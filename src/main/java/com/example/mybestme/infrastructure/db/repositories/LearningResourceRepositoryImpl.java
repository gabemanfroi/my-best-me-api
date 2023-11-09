package com.example.mybestme.infrastructure.db.repositories;

import com.example.mybestme.domain.interfaces.repositories.LearningResourceRepository;
import com.example.mybestme.domain.models.LearningResource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LearningResourceRepositoryImpl implements LearningResourceRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public LearningResourceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<LearningResource> findAll() {
        try (Session session = sessionFactory.openSession()) {
            System.out.println(session.createQuery("from LearningResource", LearningResource.class).list());
            return null;
        }
    }

    @Override
    public LearningResource findById(Long id) {
        return null;
    }

    @Override
    public LearningResource save(LearningResource learningResource) {
        return null;
    }

    @Override
    public LearningResource update(LearningResource learningResource) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
