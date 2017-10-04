package com.example.demo.controller;

import com.example.demo.LibraryService.LibraryService;
import com.example.demo.ResponseMessage.LoginMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class LibraryController {
    private LibraryService libraryService = new LibraryService();

    @RequestMapping("/login")
    public LoginMessage greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return libraryService.login(name);
    }
}