package com.testrbc.petshop.persistence;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class Specifications<T> {
    public static <T> Specification<T> isActive() {
        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cbu) {
                return cbu.equal(root.get("inactive"), false);
            }
        };
    }

    public static <T> Specification<T> isNotDeleted() {
        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cbu) {
                return cbu.equal(root.get("deleted"), false);
            }
        };
    }

}
