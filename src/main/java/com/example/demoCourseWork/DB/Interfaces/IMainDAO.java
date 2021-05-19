package com.example.demoCourseWork.DB.Interfaces;

import com.example.demoCourseWork.DB.DAOImplementations.LotDAO;
import com.example.demoCourseWork.DB.DAOImplementations.LotOfferDAO;
import com.example.demoCourseWork.DB.DAOImplementations.UserDAO;

public interface IMainDAO {
    LotDAO getLotDAO ();
    LotOfferDAO getLotOfferDao();
    UserDAO getUserDao();
}
