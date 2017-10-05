package com.example.demo.api.test;

import com.example.demo.ResponseMessage.LoginMessage;
import com.example.demo.controller.LibraryController;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingApiTest {
    private LibraryController libraryController = new LibraryController();


    @Test
    public void should_return_welcome_message_when_user_login() {
        LoginMessage exceptMessage = new LoginMessage("Jack", "Dear Jack! Welcome to our library!");
        LoginMessage response = libraryController.greeting("Jack");
        assertEquals(exceptMessage.getUserName(), response.getUserName());
        assertEquals(exceptMessage.getWelcomeMessage(), response.getWelcomeMessage());
    }
}
