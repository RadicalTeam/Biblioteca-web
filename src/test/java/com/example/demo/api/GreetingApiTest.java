package com.example.demo.api;

import com.example.demo.ResponseMessage.LoginMessage;
import com.example.demo.controller.LibraryController;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingApiTest {
    private LibraryController libraryController = new LibraryController();


    @Test
    public void exampleTest() {
        LoginMessage exceptMessage = new LoginMessage("Jack", "Dear Jack! Welcome to our library!");
        LoginMessage response = libraryController.greeting("Jack");
        assertEquals(exceptMessage.getUserName(), response.getUserName());
        assertEquals(exceptMessage.getUserName(), response.getUserName());
    }
}
