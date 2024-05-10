package com.github.lewismitchell.springbootwithmongo.controllers;

import com.github.lewismitchell.springbootwithmongo.forms.SampleModelForm;
import com.github.lewismitchell.springbootwithmongo.models.SampleModel;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HelloWebController {

    @GetMapping("/web")
    public String onPageLoad() {
        return "HelloEntry";
    }

    @PostMapping(value = "/web/new")
    public String onSubmit(@Valid SampleModelForm form, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "HelloEntry";
        }

        model.addAttribute("name", form.getName());
        model.addAttribute("description", form.getDescription());
        return "HelloSubmission";
    }
}
