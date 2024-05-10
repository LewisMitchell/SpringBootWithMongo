package com.github.lewismitchell.springbootwithmongo.controllers;

import com.github.lewismitchell.springbootwithmongo.forms.SampleModelForm;
import com.github.lewismitchell.springbootwithmongo.models.SampleModel;
import com.github.lewismitchell.springbootwithmongo.repositories.SampleDataRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

    @Autowired
    SampleDataRepository repository;

    @GetMapping("/web")
    public String onPageLoad() {
        return "HelloEntry";
    }

    @PostMapping(value = "/web/new")
    public String onSubmit(@Valid SampleModelForm form, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "HelloEntry";
        }
        repository.insert(new SampleModel(form.getName(), form.getDescription()));
        model.addAttribute("name", form.getName());
        model.addAttribute("description", form.getDescription());
        return "HelloSubmission";
    }

    @GetMapping("/web/find")
    public String findData(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "description", required = false) String description, Model model) {
        if(name != null) {
            model.addAttribute("results", repository.findByName(name));
            return "HelloSearchResults";
        } else if(description != null) {
            model.addAttribute("results", repository.findByDescription(description));
            return "HelloSearchResults";
        } else {
            return "Error";
        }
    }
}
