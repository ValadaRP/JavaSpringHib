package com.example.schronisko.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "owner_form";
    }


}


