package com.example.todo.Controllers;

import com.example.todo.Models.Owner;
import com.example.todo.Models.SubjectModel;
import com.example.todo.Services.OwnerNotFoundException;
import com.example.todo.Services.OwnerService;
import com.example.todo.Services.SubjectServices;
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
    @Autowired private SubjectServices subjectServices;


    @GetMapping("/owner")
    public String showOwnerList(Model model) {
        List<Owner> listOwners = ownerService.listAll();
        model.addAttribute("listOwners", listOwners);
        return "owner";
    }

    @GetMapping("/owner/new")
    public String showNewOwnerForm(Model model){
        model.addAttribute("owner", new Owner());
        List<SubjectModel> listSubjects = subjectServices.listSubjectsAll();
        model.addAttribute("subjectList", listSubjects);
        model.addAttribute("pageTitle","New ToDo note");
        return "owner_form";
    }

    @PostMapping("/owner/save")
    public String saveOwner(Owner owner, RedirectAttributes ra){
        ownerService.save(owner);
        ra.addFlashAttribute("message","The note was successfully saved");
        return "redirect:/owner";
    }
    @PostMapping("/subject/save")
    public String saveSubject(SubjectModel subjectModel, RedirectAttributes ra){
        ownerService.saveSubject(subjectModel);
        ra.addFlashAttribute("message","The subject was successfully saved");
        return "redirect:/owner";
    }


    @GetMapping("/subject/new")
    public String showNewSubjectForm(Model model){
        model.addAttribute("subjectModel", new SubjectModel());
        model.addAttribute("pageTitle","New ToDo note");
        return "subject_form";
    }

    @GetMapping("/owner/edit/{id}")
    public String showEditOwnerForm(@PathVariable("id") Integer id,Model model , RedirectAttributes ra){
        try {
            Owner owner = ownerService.get(id);
            model.addAttribute("owner", owner);
            List<SubjectModel> listSubjects = subjectServices.listSubjectsAll();
            model.addAttribute("subjectList", listSubjects);
            model.addAttribute("pageTitle","Edit note (ID: " + id + ")");
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
            ra.addFlashAttribute("message","The note was successfully deleted");
        } catch (OwnerNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/owner";
    }
}


