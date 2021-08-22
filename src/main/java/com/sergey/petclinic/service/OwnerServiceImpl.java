package com.sergey.petclinic.service;

import com.sergey.petclinic.model.Owner;
import com.sergey.petclinic.repository.OwnerRepository;
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
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    @Transactional
    public List<Owner> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return owners;
    }

    @Override
    @Transactional
    public Owner getOwner(Long id) {
        Owner owner = null;
        Optional<Owner> optional = ownerRepository.findById(id);
        if (optional.isPresent()) {
            owner = optional.get();
        }
        return owner;
    }

    @Override
    @Transactional
    public List<Owner> getOwnersByLastName(String lastName) {
        List<Owner> owners = ownerRepository.findAll();
        List<Owner> result = owners.stream().filter(a -> a.getLastName().equals(lastName)).collect(Collectors.toList());

        return result;
    }

    @Override
    @Transactional
    public void saveOwner(Owner owner){
        ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public void deleteOwner(Long id){
        ownerRepository.deleteById(id);
    }

}
