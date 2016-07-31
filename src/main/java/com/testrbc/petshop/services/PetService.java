package com.testrbc.petshop.services;

import com.testrbc.petshop.domain.Pet;

import java.util.List;

/**
 * Service for CRUD operations with {@link com.testrbc.petshop.domain.Pet} objects.
 */
public interface PetService {
    Pet save(Pet pet);

    void update(Pet pet);

    void delete(Pet pet);

    Pet findById(String id);

    List<Pet> findByStatus(String status);

    //List<Pet> findByTags(List<String> tags);
}
