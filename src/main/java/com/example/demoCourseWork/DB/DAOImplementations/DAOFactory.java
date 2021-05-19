package com.example.demoCourseWork.DB.DAOImplementations;

import com.example.demoCourseWork.DB.Interfaces.IMainDAO;

public class DAOFactory implements IMainDAO {
    private LotDAO lotDAO = new LotDAO();
    private UserDAO userDAO = new UserDAO();
    private LotOfferDAO lotOfferDAO = new LotOfferDAO();

    @Override
    public LotDAO getLotDAO() {
        return lotDAO;
    }

    @Override
    public LotOfferDAO getLotOfferDao() {
        return lotOfferDAO;
    }

    @Override
    public UserDAO getUserDao() {
        return userDAO;
    }
}
