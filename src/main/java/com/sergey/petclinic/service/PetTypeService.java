package com.sergey.petclinic.service;

import com.sergey.petclinic.model.PetType;

import java.util.List;

/**
 * @author Sergey Borodkin
 */
public interface PetTypeService {

    public List<PetType> getAllPetTypes();

    public PetType getPetType(Long id);

    public Long getTypeId(String type);
}
