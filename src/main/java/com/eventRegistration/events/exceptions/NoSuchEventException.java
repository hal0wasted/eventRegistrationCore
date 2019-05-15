package com.eventRegistration.events.exceptions;

import java.util.NoSuchElementException;

public class NoSuchEventException extends NoSuchElementException {

    private final String MESSAGE = "No such event exists";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
