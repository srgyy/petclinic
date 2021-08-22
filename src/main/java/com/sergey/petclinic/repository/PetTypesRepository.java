package com.sergey.petclinic.repository;

import com.sergey.petclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Borodkin
 */
public interface PetTypesRepository extends JpaRepository<PetType, Long> {
}
