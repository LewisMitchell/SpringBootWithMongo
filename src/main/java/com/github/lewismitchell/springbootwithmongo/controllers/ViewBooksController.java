package com.github.lewismitchell.springbootwithmongo.controllers;

import com.github.lewismitchell.springbootwithmongo.models.BookModel;
import com.github.lewismitchell.springbootwithmongo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewBooksController {

    @Autowired
    BookRepository repository;

    @GetMapping("/books")
    public String onPageLoad(Model model) {
        List<BookModel> books = repository.findAll();
        model.addAttribute("books", books);
        return "Books";
    }
}
