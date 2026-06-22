package com.hemanagachand.code_pulse.exception;

public class PlatformAccountNotFoundException
        extends RuntimeException {

    public PlatformAccountNotFoundException(
            String message) {

        super(message);
    }
}