package com.sergey.petclinic.repository;

import com.sergey.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Borodkin
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
}
