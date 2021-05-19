package com.example.demoCourseWork.Exceptions;

public class InvalidEmailException extends Exception{
    public InvalidEmailException() {
    }
    public InvalidEmailException(String message) {
        super(message);
    }

}
