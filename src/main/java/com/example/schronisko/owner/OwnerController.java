package com.example.schronisko.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired private OwnerService ownerService;

    @GetMapping("/owner")
    public String showOwnerList(Model model) {
        List<Owner> listOwners = ownerService.listAll();
        model.addAttribute("listOwners", listOwners);
        return "owner";
    }

    @GetMapping("/owner/new")
    public String showNewOwnerForm(Model model){
        model.addAttribute("owner", new Owner());
        model.addAttribute("pageTitle","New owner");
        return "owner_form";
    }

    @PostMapping("/owner/save")
    public String saveOwner(Owner owner, RedirectAttributes ra){
        ownerService.save(owner);
        ra.addFlashAttribute("message","The owner was successfully saved");
        return "redirect:/owner";
    }

    @GetMapping("/owner/edit/{id}")
    public String showEditOwnerForm(@PathVariable("id") Integer id,Model model , RedirectAttributes ra){
        try {
            Owner owner = ownerService.get(id);
            model.addAttribute("owner", owner);
            model.addAttribute("pageTitle","Edit owner (ID: " + id + ")");
            return "owner_form";
        } catch (OwnerNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            e.printStackTrace();
            return "redirect:/owner";
        }
    }

    @GetMapping("/owner/delete/{id}")
    public String deleteOwner(@PathVariable("id") Integer id, RedirectAttributes ra){
        try {
            ownerService.delete(id);
            ra.addFlashAttribute("message","The owner was successfully deleted");
        } catch (OwnerNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/owner";
    }
}


