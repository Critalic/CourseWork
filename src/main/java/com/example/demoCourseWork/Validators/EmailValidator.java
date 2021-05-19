package com.example.demoCourseWork.Validators;


import com.example.demoCourseWork.Exceptions.InvalidEmailException;

public class EmailValidator {
    public void validate(String email) throws InvalidEmailException {
        if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) throw new InvalidEmailException("Not a valid e-mail");
    }
}
