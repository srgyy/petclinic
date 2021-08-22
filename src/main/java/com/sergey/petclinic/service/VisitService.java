package com.sergey.petclinic.service;

import com.sergey.petclinic.model.Visit;

import java.util.List;

/**
 * @author Sergey Borodkin
 */
public interface VisitService {

    public List<Visit> getAllVisits();

    public void saveVisit(Visit visit);

    public void deletePetVisits(Long petId);

}
