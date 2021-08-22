package com.sergey.petclinic.service;

import com.sergey.petclinic.model.Visit;
import com.sergey.petclinic.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Borodkin
 */
@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    VisitRepository visitRepository;

    @Override
    @Transactional
    public List<Visit> getAllVisits() {
        List<Visit> visits = visitRepository.findAll();
        return visits;
    }

    @Override
    @Transactional
    public void saveVisit(Visit visit){
        visitRepository.save(visit);
    }

    @Override
    @Transactional
    public void deletePetVisits(Long petId){
        visitRepository.findAll().stream().filter(a -> a.getPetId().equals(petId)).collect(Collectors.toList())
                .stream().forEach(a -> visitRepository.deleteById(a.getId()));
    }
}
