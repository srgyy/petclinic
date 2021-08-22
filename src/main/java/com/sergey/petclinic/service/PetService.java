package com.sergey.petclinic.service;

import com.sergey.petclinic.model.Pet;

import java.util.List;

/**
 * @author Sergey Borodkin
 */
public interface PetService {

    public List<Pet> getAllPets();

    public Pet getPet(Long id);

    public void savePet(Pet pet);

    public void deletePet(Long id);

    public void deleteOwnerPets(Long ownerId);

}
