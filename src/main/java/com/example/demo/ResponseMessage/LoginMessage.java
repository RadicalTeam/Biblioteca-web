package com.example.demo.ResponseMessage;

public class LoginMessage {
    private final String userName;
    private final String welcomeMessage;

    public LoginMessage(String userName, String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
        this.userName = userName;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public String getUserName() {
        return userName;
    }
}
