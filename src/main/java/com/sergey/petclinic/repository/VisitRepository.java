package com.sergey.petclinic.repository;

import com.sergey.petclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sergey Borodkin
 */
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
