package com.example.demoCourseWork.DB.DAOImplementations;

import com.example.demoCourseWork.DB.DataBases;
import com.example.demoCourseWork.DB.Interfaces.IUserDAO;
import com.example.demoCourseWork.Exceptions.AlreadyExistsError;
import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.InvalidEmailException;
import com.example.demoCourseWork.Validators.EmailValidator;
import com.example.demoCourseWork.models.User;

import java.util.HashSet;

public class UserDAO implements IUserDAO {
    private static final HashSet<User> users = DataBases.getUsers();

    @Override
    public void createUser(User user) throws InvalidEmailException, AlreadyExistsError {
        EmailValidator emailValidator = new EmailValidator();
        emailValidator.validate(user.getLogin());

        int initialSize = users.size();
        users.add(user);
        if(initialSize == users.size()) {
            throw new AlreadyExistsError("This e-mail is occupied");
        }
    }

    @Override
    public User getUser (String login) {
        for(User user : users) {
            if(user.getLogin().equals(login)) return user;
        }
        return null;
    }
}
