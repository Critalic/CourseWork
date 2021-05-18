package com.example.demoCourseWork.Exceptions;

public class AlreadyExistsError extends Throwable{
    public AlreadyExistsError() {
    }
    public AlreadyExistsError(String message) {
        super(message);
    }
}
