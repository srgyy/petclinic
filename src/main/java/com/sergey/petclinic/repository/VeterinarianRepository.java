package com.sergey.petclinic.repository;

import com.sergey.petclinic.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Borodkin
 */
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}
