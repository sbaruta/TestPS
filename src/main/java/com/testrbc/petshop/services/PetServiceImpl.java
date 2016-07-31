package com.testrbc.petshop.services;

import com.testrbc.petshop.domain.Pet;
import com.testrbc.petshop.persistence.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Service PetServiceImpl.
 * <p/>
 * {@link PetService} implementation.
 */
@Service("PetService")
public class PetServiceImpl implements PetService {
    /**
     * The pet repository.
     */
    @Autowired
    private PetRepository petRepository;

    @Override
    @Transactional
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    @Transactional
    public void update(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    @Transactional
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }

    @Override
    public Pet findById(String id) {
        return petRepository.findById(id);
    }

    @Override
    public List<Pet> findByStatus(String status) {
        return petRepository.findByStatus(status);
    }

//    @Override
//    public List<Pet> findByTags(List<String> tags) {
//        return petRepository.findByTags(tags.toString());
//    }

}