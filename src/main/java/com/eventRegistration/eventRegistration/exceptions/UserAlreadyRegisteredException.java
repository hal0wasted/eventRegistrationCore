package com.eventRegistration.eventRegistration.exceptions;

public class UserAlreadyRegisteredException extends Exception {

    private final String MESSAGE = "User id already registered for this event";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
