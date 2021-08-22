package com.sergey.petclinic.service;

import com.sergey.petclinic.model.Pet;
import com.sergey.petclinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Sergey Borodkin
 */
@Service
public class PetServiceImpl implements PetService{

    @Autowired
    PetRepository petRepository;

    @Override
    @Transactional
    public List<Pet> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        return pets;
    }

    @Override
    @Transactional
    public Pet getPet(Long id){
        Pet pet = null;
        Optional<Pet> optional = petRepository.findById(id);
        if (optional.isPresent()){
            pet = optional.get();
        }
        return pet;
    }

    @Override
    @Transactional
    public void savePet(Pet pet){
        petRepository.save(pet);
    }

    @Override
    @Transactional
    public void deletePet(Long id){
        petRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteOwnerPets(Long ownerId){

        petRepository.findAll().stream().filter(a -> a.getOwnerId().equals(ownerId)).collect(Collectors.toList())
                .stream().forEach(a -> petRepository.deleteById(a.getId()));

    }
}
