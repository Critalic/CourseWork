package com.example.demoCourseWork.Exceptions;

public class PasswordMismatchException extends Exception{
    public PasswordMismatchException() {
    }
    public PasswordMismatchException(String message) {
        super(message);
    }

}
