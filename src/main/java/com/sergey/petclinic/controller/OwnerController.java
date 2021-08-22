package com.sergey.petclinic.controller;

import com.sergey.petclinic.model.Owner;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Borodkin
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    OwnerService ownerService;
    @Autowired
    PetService petService;
    @Autowired
    PetTypeService petTypeService;
    @Autowired
    VisitService visitService;

    @GetMapping("/find")
    public String findOwners(Model model){
        return "find-owners";
    }

    @RequestMapping(value = "")
    public String searchOwners(@RequestParam(value = "lastName", required = false) String lastName, Model model){

        List<Owner> owners = null;

        if (!lastName.equals("")) {
            owners = ownerService.getOwnersByLastName(lastName);
        } else {
            owners = ownerService.getAllOwners();
        }

        if (owners.size() == 0) {
            String err = "has not been found";
            model.addAttribute("val", lastName);
            model.addAttribute("err", err);
            return "find-owners";
        }

        model.addAttribute("owners", owners);

        model.addAttribute("pets", petService.getAllPets());

        return "all-owners";
    }

    @GetMapping("/{id}")
    public String getOwner(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("pets", petService.getAllPets());
        model.addAttribute("owner", ownerService.getOwner(id));
        model.addAttribute("petTypes", petTypeService.getAllPetTypes());
        model.addAttribute("visits", visitService.getAllVisits());
        return "owner-info";
    }

    @GetMapping("/new")
    public String newOwner(Model model){
        model.addAttribute("owner", new Owner());
        return "new-owner";
    }

    @PostMapping("/new")
    public String saveOwner(@ModelAttribute("owner") @Valid Owner owner, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "new-owner";
        }
        ownerService.saveOwner(owner);

        return "redirect:/owners/" + owner.getId();
    }

    @GetMapping("/{id}/edit")
    public String editOwner(@PathVariable("id") Long id, Model model){
        model.addAttribute("owner", ownerService.getOwner(id));
        return "owner-edit";
    }

    @PostMapping("/{id}")
    public String updateOwner(@PathVariable("id") Long id, @ModelAttribute("owner") @Valid Owner owner,
                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "owner-edit";
        }

        ownerService.saveOwner(owner);

        return "redirect:/owners/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteOwner(@PathVariable("id") Long id){
        String ownerLastName = ownerService.getOwner(id).getLastName();

        petService.getAllPets().stream().filter(a -> a.getOwnerId().equals(id))
                .collect(Collectors.toList()).stream().forEach(a -> visitService.deletePetVisits(a.getId()));

        petService.deleteOwnerPets(id);
        ownerService.deleteOwner(id);

        return "redirect:/owners?lastName="+ownerLastName;
    }

}
