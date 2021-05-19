package com.example.demoCourseWork.Services;



import com.example.demoCourseWork.DB.DAOImplementations.DAOFactory;
import com.example.demoCourseWork.Exceptions.*;
import com.example.demoCourseWork.Validators.EmptyValidator;
import com.example.demoCourseWork.models.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class UserService {
    private DAOFactory daoFactory;

    public UserService(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public User logIn(String login, String password)
            throws WrongPasswordException, NoIDException, NoSuchAlgorithmException,
            NullPointerException, IllegalArgumentException, DBError {

        login = EmptyValidator.checkIfEmpty(login, "Login");
        User user = daoFactory.getUserDao().getUser(login);

        password = EmptyValidator.checkIfEmpty(password, "Password");
        password = getHash(password);

        if (!user.getPasswordHash().equals(password)) {
            throw new WrongPasswordException("Incorrect password!");
        }

        return user;
    }

    public void signUp(String login, String name, String password, String password2)
            throws WrongPasswordException, NoSuchAlgorithmException,
            IllegalArgumentException, NullPointerException, DBError, InvalidEmailException {
        login = EmptyValidator.checkIfEmpty(login, "Login");
        name = EmptyValidator.checkIfEmpty(name, "Name");
        password = EmptyValidator.checkIfEmpty(password, "Password");
        password2 = EmptyValidator.checkIfEmpty(password2, "Retyped password");

        if (!password.equals(password2)) {
            throw new WrongPasswordException("Password mismatch!");
        }

        daoFactory.getUserDao().createUser(
                new User(name, login, getHash(password))
        );
    }
    private String getHash(String passwordToHash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordToHash.getBytes());
        byte[] bytes = md.digest();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}