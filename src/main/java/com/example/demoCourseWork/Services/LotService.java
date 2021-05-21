package com.example.demoCourseWork.Services;


import com.example.demoCourseWork.DB.DAOImplementations.DAOFactory;
import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.Exceptions.NotAnOwnerException;
import com.example.demoCourseWork.Validators.EmptyValidator;
import com.example.demoCourseWork.models.Lot;
import com.example.demoCourseWork.models.LotOffer;

import java.util.List;

public class LotService {
    private DAOFactory daoFactory;

    public LotService(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public List<Lot> getLots() throws DBError, DBError {
        return daoFactory.getLotDAO().getAll();
    }

    public List<Lot> getLotsWithOwner(String owner) throws DBError {
        return daoFactory.getLotDAO().getAllWithOwner(owner);
    }

    public List<Lot> getLotsByName(String name) throws DBError {
        return daoFactory.getLotDAO().getAllWithName(name);
    }

    public Lot getLotById(String id) throws IllegalArgumentException, DBError, NoIDException {
        id = EmptyValidator.checkIfEmpty(id, "Id");
        return daoFactory.getLotDAO().get(id);
    }

    public void setLotStatus(String lotId, String owner, Boolean isActive)
            throws IllegalArgumentException, NotAnOwnerException, NoIDException, DBError {
        if (lotId.isEmpty()) { throw new IllegalArgumentException(); }

        if (owner.equals(daoFactory.getLotDAO().getLotOwner(lotId))){
            daoFactory.getLotDAO().updateStatus(lotId, isActive);
            return;
        }

        throw new NotAnOwnerException();
    }

    public void deleteLot(String lotId, String owner) throws NoIDException, DBError {
        if (owner.equals(daoFactory.getLotDAO().getLotOwner(lotId))){
            daoFactory.getLotDAO().deleteLot(lotId);
            return;
        }
    }

    public void createNewLot(String ownerName, String name, String ownerId, String about, String startPrice)
            throws IllegalArgumentException, DBError {
        name = EmptyValidator.checkIfEmpty(name, "Name");
        about = EmptyValidator.checkIfEmpty(about, "About");
        ownerId= EmptyValidator.checkIfEmpty(ownerId, "Owner's ID");
        ownerName = EmptyValidator.checkIfEmpty(ownerName, "Owner's name");
        Lot lot = new Lot(ownerName, ownerId, about, name, startPrice, true);

        daoFactory.getLotDAO().createLot(lot);
    }

    public void createNewLot(String ownerName, String name, String ownerId, String about, double startPrice)
            throws IllegalArgumentException, DBError {
        name = EmptyValidator.checkIfEmpty(name, "Name");
        about = EmptyValidator.checkIfEmpty(about, "About");
        EmptyValidator.checkIfEmpty(ownerId, "Owner's ID");
        Lot lot = new Lot(ownerName ,ownerId, about, name, startPrice, true);

        daoFactory.getLotDAO().createLot(lot);
    }

    public void createNewOffer(String text, String money, String lotId, String userLogin)
            throws IllegalArgumentException, NoIDException, DBError {
        text = EmptyValidator.checkIfEmpty(text, "Text");
        money = EmptyValidator.checkIfEmpty(money, "Money");

        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException("Enter number in 'MONEY' field!");
        }

        if (lotId == null) {
            throw new NoIDException();
        }
        lotId = lotId.trim();
        if (lotId.isEmpty()) {
            throw new NoIDException();
        }

        daoFactory.getLotOfferDao().createLotOffer(new LotOffer(userLogin, text, money, lotId));
    }
}
