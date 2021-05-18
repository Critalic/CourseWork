package com.example.demoCourseWork.Exceptions;

public class DBError extends Throwable {
    public DBError() {
    }
    public DBError(String message) {
        super(message);
    }
}
