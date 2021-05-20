package com.example.demoCourseWork.DB.Interfaces;


import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.models.Lot;

import java.util.List;

public interface ILotDAO {
    Lot get(String id) throws NoIDException;
    String getLotOwner(String tenderId) throws NoIDException;

    List<Lot> getAll() throws DBError;
    List<Lot> getAllWithName(String name);
    List<Lot> getAllWithOwner(String owner);

    void createLot(Lot lot) throws DBError;
    void updateStatus(String tenderId, boolean value) throws NoIDException, DBError;

    void deleteLot(String id) throws DBError;
}
