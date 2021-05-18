package com.example.demoCourseWork.Exceptions;

public class NotAnOwnerException extends Exception{
    public NotAnOwnerException() {
    }
    public NotAnOwnerException(String message) {
        super(message);
    }
}
