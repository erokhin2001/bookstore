package com.example.bookstore.web;

import com.example.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

//    @GetMapping("/index")
//    public String showBooks(Model model) {
//
//        return "index";
//    }

    @GetMapping("/booklist")
    public String showBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }


}

