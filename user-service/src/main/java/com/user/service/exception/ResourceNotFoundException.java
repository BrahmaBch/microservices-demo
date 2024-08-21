package com.user.service.exception;

public class ResourceNotFoundException extends Throwable {
    String s;
    public ResourceNotFoundException(String s) {
        this.s = s;
    }
}
