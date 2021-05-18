package com.example.demoCourseWork.DAO.Interfaces;

import com.example.demoCourseWork.models.User;

public interface IUserDAO {
    User get(String login) throws DataBaseErrorException, NoIdException;
    void create(User user) throws DataBaseErrorException, AlreadyExistsException;
}
