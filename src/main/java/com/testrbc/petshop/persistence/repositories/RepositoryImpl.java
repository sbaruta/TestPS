package com.testrbc.petshop.persistence.repositories;

import com.testrbc.petshop.persistence.Specifications;
import com.testrbc.petshop.persistence.repositories.ActivatableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

import static org.springframework.data.jpa.domain.Specifications.where;

public class RepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, Serializable>
        implements ActivatableRepository<T, Serializable> {

    public RepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
    }

    public RepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public List<T> findAllActive() {
        return findAll(isActive());
    }

    @Override
    public List<T> findAllActive(Sort sort) {
        return findAll(isActive(), sort);
    }

    @Override
    public Page<T> findAllActive(Pageable pageable) {
        return findAll(isActive(), pageable);
    }

    @Override
    public List<T> findAllActive(Specification<T> spec) {
        return findAll(where(spec).and(isActive()));
    }

    @Override
    public List<T> findAllActive(Specification<T> spec, Sort sort) {
        return findAll(where(spec).and(isActive()), sort);
    }

    @Override
    public Page<T> findAllActive(Specification<T> spec, Pageable pageable) {
        return findAll(where(spec).and(isActive()), pageable);
    }

    private Specification<T> isActive() {
        return Specifications.isActive();
    }

}