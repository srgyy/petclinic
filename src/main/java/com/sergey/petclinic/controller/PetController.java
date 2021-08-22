package com.sergey.petclinic.controller;

import com.sergey.petclinic.model.Pet;
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

/**
 * @author Sergey Borodkin
 */
@Controller
@RequestMapping("/owners/{id}/pets/")
public class PetController {

    @Autowired
    OwnerService ownerService;
    @Autowired
    PetService petService;
    @Autowired
    PetTypeService petTypeService;
    @Autowired
    VisitService visitService;

    @GetMapping("/new")
    public String newPet(@PathVariable("id") Long id, Model model){
        model.addAttribute("pet", new Pet());
        model.addAttribute("owner", ownerService.getOwner(id));
        model.addAttribute("petTypes", petTypeService.getAllPetTypes());
        return "new-pet";
    }

    @PostMapping("/new")
    public String savePet(@PathVariable("id") Long id, @ModelAttribute("pet") @Valid Pet pet,
                          BindingResult bindingResult, @RequestParam String type, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("currType", type);
            model.addAttribute("owner", ownerService.getOwner(id));
            model.addAttribute("petTypes", petTypeService.getAllPetTypes());
            return "new-pet";
        }
        pet.setTypeId(petTypeService.getTypeId(type));
        pet.setOwnerId(id);
        petService.savePet(pet);
        return "redirect:/owners/" + id;
    }

    @GetMapping("{petId}/edit")
    public String editPet(@PathVariable("id") Long ownerId, @PathVariable("petId") Long petId, Model model){

        Pet pet = petService.getPet(petId);
        model.addAttribute("owner", ownerService.getOwner(ownerId));
        model.addAttribute("pet", pet);
        model.addAttribute("petTypes", petTypeService.getAllPetTypes());
        model.addAttribute("currType", petTypeService.getPetType(pet.getTypeId()).getType());

        return "pet-edit";
    }

    @PostMapping("{petId}/edit")
    public String updatePet(@PathVariable("id") Long ownerId, @PathVariable("petId") Long petId,
                            @ModelAttribute("pet") @Valid Pet pet, BindingResult bindingResult,
                            @RequestParam String type, Model model) {

        if (bindingResult.hasErrors()){
            model.addAttribute("currType", type);
            model.addAttribute("owner", ownerService.getOwner(ownerId));
            model.addAttribute("petTypes", petTypeService.getAllPetTypes());
            return "pet-edit";
        }

        pet.setTypeId(petTypeService.getTypeId(type));
        pet.setOwnerId(ownerId);
        petService.savePet(pet);

        return "redirect:/owners/" + ownerId;
    }

    @GetMapping("{petId}/delete")
    public String deletePet(@PathVariable("id") Long ownerId, @PathVariable("petId") Long petId){

        visitService.deletePetVisits(petId);
        petService.deletePet(petId);

        return "redirect:/owners/" + ownerId;
    }
}
