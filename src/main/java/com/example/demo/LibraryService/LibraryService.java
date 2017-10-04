package com.example.demo.LibraryService;

import com.example.demo.ResponseMessage.LoginMessage;
import org.springframework.stereotype.Component;

@Component
public class LibraryService {
    private static final String template = "Dear %s! Welcome to our library!";

    public LoginMessage login(String userName) {
        return new LoginMessage(userName, String.format(template, userName));
    }
}
