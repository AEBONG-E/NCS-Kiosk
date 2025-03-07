package com.kobuks.kiosk.exception;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException{" +
                "message='" + getMessage() + '\'' +
                '}';
    }
}

