package com.sergey.petclinic.service;

import com.sergey.petclinic.model.Veterinarian;
import com.sergey.petclinic.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sergey Borodkin
 */
@Service
public class VeterinarianServiceImpl implements VeterinarianService{

    @Autowired
    VeterinarianRepository veterinarianRepository;

    @Override
    @Transactional
    public List<Veterinarian> getAllVets(){
        List<Veterinarian> vets = veterinarianRepository.findAll();
        return vets;
    }
}
