package com.example.demoCourseWork.DB.Interfaces;

import com.example.demoCourseWork.Exceptions.AlreadyExistsError;
import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.InvalidEmailException;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.models.User;

public interface IUserDAO {
    User getUser(String login) throws DBError, NoIDException;
    void createUser(User user) throws DBError, AlreadyExistsError, InvalidEmailException;
}
