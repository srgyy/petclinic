package com.sergey.petclinic.service;

import com.sergey.petclinic.model.PetType;
import com.sergey.petclinic.repository.PetTypesRepository;
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
public class PetTypeServiceImpl implements PetTypeService{

    @Autowired
    PetTypesRepository petTypesRepository;

    @Override
    @Transactional
    public List<PetType> getAllPetTypes() {
        List<PetType> petTypes = petTypesRepository.findAll();
        return petTypes;
    }

    @Override
    @Transactional
    public PetType getPetType(Long id) {
        PetType petType = null;
        Optional<PetType> optional = petTypesRepository.findById(id);
        if (optional.isPresent()){
            petType = optional.get();
        }

        return petType;
    }

    @Override
    @Transactional
    public Long getTypeId(String type){
        List<PetType> pet = petTypesRepository.findAll().stream().filter(a -> a.getType().equals(type)).collect(Collectors.toList());
        return pet.get(0).getId();
    }
}
