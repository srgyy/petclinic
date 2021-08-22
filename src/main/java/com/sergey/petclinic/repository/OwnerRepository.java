package com.sergey.petclinic.repository;

import com.sergey.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Borodkin
 */
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
