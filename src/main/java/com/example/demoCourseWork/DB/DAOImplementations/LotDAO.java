package com.example.demoCourseWork.DB.DAOImplementations;

import com.example.demoCourseWork.DB.DataBases;
import com.example.demoCourseWork.DB.Interfaces.ILotDAO;
import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.models.Lot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LotDAO implements ILotDAO {
    private static HashSet<Lot> lots;

    LotDAO() {
        lots = DataBases.getLots();
    }

    @Override
    public Lot get(String id) throws DBError, NoIDException {
        for(Lot lot : lots) {
            if(id.equals(lot.getId())) return lot;
        }
        throw new NoIDException("Lot with given ID not found");
    }

    @Override
    public String getLotOwner(String id) throws NoIDException, DBError {
        for(Lot lot : lots) {
            if(id.equals(lot.getId())) return lot.getOwner();
        }
        throw new NoIDException("Lot with given ID not found");
    }

    @Override
    public List<Lot> getAll() throws DBError {
        ArrayList<Lot> answer = new ArrayList<>();
        answer.addAll(lots);
        return answer;
    }

    @Override
    public List<Lot> getAllWithName(String name) throws DBError {
        ArrayList<Lot> answer = new ArrayList<>();
        for(Lot lot : lots) {
            if(lot.getName().equals(name)) answer.add(lot);
        }
        return answer;
    }

    @Override
    public List<Lot> getAllWithOwner(String owner) throws DBError {
        ArrayList<Lot> answer = new ArrayList<>();
        for(Lot lot : lots) {
            if(lot.getName().equals(owner)) answer.add(lot);
        }
        return answer;
    }

    @Override
    public void createLot(Lot lot) throws DBError {
        int initialSize= lots.size();
        lots.add(lot);
        if(initialSize== lots.size()) throw new DBError("Looks like this lot is already created");
    }

    @Override
    public void deleteLot(String id) throws DBError {
        for(Lot lot : lots) {
            if(lot.getId().equals(id)) {
                lots.remove(lot);
                return;
            }
        }
        throw new DBError("Didn't find a lot with the given ID");
    }

    @Override
    public void updateStatus (String id, boolean value) throws DBError {
        for(Lot lot : lots) {
            if(lot.getId().equals(id)) {
                lot.setStatus(value);
                return;
            }
        }
        throw new DBError("Didn't find a lot with the given ID");
    }
}
