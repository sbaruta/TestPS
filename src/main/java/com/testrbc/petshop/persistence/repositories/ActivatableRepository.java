package com.testrbc.petshop.persistence.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ActivatableRepository <T, ID extends Serializable> extends JpaRepository<T, ID>{

    List<T> findAllActive();
    List<T> findAllActive(Sort sort);
    Page<T> findAllActive(Pageable pageable);

    List<T> findAllActive(Specification<T> spec);
    List<T> findAllActive(Specification<T> spec, Sort sort);
    Page<T> findAllActive(Specification<T> spec, Pageable pageable);
}
