package com.sergey.petclinic.controller;

import com.sergey.petclinic.model.Pet;
import com.sergey.petclinic.model.Visit;
import com.sergey.petclinic.service.OwnerService;
import com.sergey.petclinic.service.PetService;
import com.sergey.petclinic.service.PetTypeService;
import com.sergey.petclinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * @author Sergey Borodkin
 */
@Controller
@RequestMapping("/owners/{id}/pets/{petId}/visits/new")
public class VisitController {

    @Autowired
    OwnerService ownerService;
    @Autowired
    PetService petService;
    @Autowired
    PetTypeService petTypeService;
    @Autowired
    VisitService visitService;

    @GetMapping("")
    public String newVisit(@PathVariable("id") Long ownerId, @PathVariable("petId") Long petId, Model model){

        Pet pet = petService.getPet(petId);

        model.addAttribute("pet", pet);
        model.addAttribute("owner",ownerService.getOwner(ownerId));
        model.addAttribute("petType", petTypeService.getPetType(pet.getTypeId()).getType());
        model.addAttribute("visit", new Visit());
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("visits", visitService.getAllVisits());
        return "new-visit";
    }

    @PostMapping("")
    public String saveVisit(@PathVariable("id") Long ownerId, @PathVariable("petId") Long petId,
                            @ModelAttribute("visit") @Valid Visit visit, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){

            Pet pet = petService.getPet(petId);

            model.addAttribute("pet", pet);
            model.addAttribute("owner",ownerService.getOwner(ownerId));
            model.addAttribute("petType", petTypeService.getPetType(pet.getTypeId()).getType());
            model.addAttribute("visits", visitService.getAllVisits());

            return "new-visit";
        }
        visit.setPetId(petId);
        visitService.saveVisit(visit);
        return "redirect:/owners/" + ownerId;
    }
}
