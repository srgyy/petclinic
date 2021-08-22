package com.sergey.petclinic.service;

import com.sergey.petclinic.model.Owner;

import java.util.List;

/**
 * @author Sergey Borodkin
 */
public interface OwnerService {

    public List<Owner> getAllOwners();

    public Owner getOwner(Long id);

    public List<Owner> getOwnersByLastName(String lastName);

    public void saveOwner(Owner owner);

    public void deleteOwner(Long id);
}
