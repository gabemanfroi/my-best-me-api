package com.example.mybestme.infrastructure.db.repositories;

import com.example.mybestme.domain.exceptions.LearningResourceNotFoundException;
import com.example.mybestme.domain.interfaces.repositories.LearningResourceRepository;
import com.example.mybestme.domain.models.LearningResource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
            return session.createQuery("from LearningResource", LearningResource.class).list();
        }
    }

    @Override
    public LearningResource findById(Long id) throws LearningResourceNotFoundException {
        try (Session session = sessionFactory.openSession()) {
            LearningResource learningResource = session.get(LearningResource.class, id);
            return Optional.ofNullable(learningResource).orElseThrow(() -> new LearningResourceNotFoundException(id));
        }
    }

    @Override
    public LearningResource save(LearningResource learningResource) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(learningResource);
            session.getTransaction().commit();
            return learningResource;
        }
    }

    @Override
    public LearningResource update(LearningResource learningResource) throws LearningResourceNotFoundException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            LearningResource existingLearningresource = session.get(LearningResource.class, learningResource.getId());
            if (existingLearningresource == null) {
                session.getTransaction().rollback();
                throw new LearningResourceNotFoundException(learningResource.getId());
            } else {
                LearningResource updatedLearningResource = session.merge(learningResource);
                session.getTransaction().commit();
                return updatedLearningResource;
            }

        }
    }

    @Override
    public void deleteById(Long id) throws LearningResourceNotFoundException {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            LearningResource learningResource = session.get(LearningResource.class, id);
            if (learningResource == null) {
                session.getTransaction().rollback();
                throw new LearningResourceNotFoundException(id);
            } else {
                session.remove(learningResource);
                session.getTransaction().commit();
            }
        }
    }
}
