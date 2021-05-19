package com.example.demoCourseWork.DB.Interfaces;

import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.models.LotOffer;

import java.util.List;

public interface ILotOfferDAO {
    void createLotOffer(LotOffer offer) throws DBError;
    List<LotOffer> getAllFromLot(String id) throws DBError, NoIDException;
}
