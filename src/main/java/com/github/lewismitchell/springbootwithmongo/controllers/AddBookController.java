package com.github.lewismitchell.springbootwithmongo.controllers;

import com.github.lewismitchell.springbootwithmongo.forms.BookModelForm;
import com.github.lewismitchell.springbootwithmongo.models.BookModel;
import com.github.lewismitchell.springbootwithmongo.repositories.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;
import java.util.List;

@Controller
public class AddBookController {

    @Autowired
    BookRepository repository;

    @GetMapping("/books/add")
    public String onPageLoad(Model model) {
        return "AddBook";
    }

    @PostMapping("/books/add")
    public String onSubmit(@Valid BookModelForm form, BindingResult formBinding, Model model) {

        if(formBinding.hasErrors()) {
            return "AddBook";
        }

        BookModel book = new BookModel(form.getName(), form.getAuthor());

        repository.insert(book);

        model.addAttribute("book", book);
        return "AddedBook";
    }
}
