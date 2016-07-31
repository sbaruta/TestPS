package com.testrbc.petshop.persistence.repositories;

import com.testrbc.petshop.domain.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository for CRUD operations on {@link com.testrbc.petshop.domain.Pet}.
 */
public interface PetRepository extends CrudRepository<Pet, String> {

    public Pet findById(String petId);

    public List<Pet> findByStatus(String status);

    //@Query("FROM Pet pet where pet.fromDate<=?2 And oc.thruDate >=?2)")
    //public List<Pet> findByTags(String tags);
}
