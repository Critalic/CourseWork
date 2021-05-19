package com.example.demoCourseWork.DB.DAOImplementations;

import com.example.demoCourseWork.DB.DataBases;
import com.example.demoCourseWork.DB.Interfaces.ILotOfferDAO;
import com.example.demoCourseWork.Exceptions.DBError;
import com.example.demoCourseWork.Exceptions.NoIDException;
import com.example.demoCourseWork.models.Lot;
import com.example.demoCourseWork.models.LotOffer;

import java.util.HashSet;
import java.util.List;

public class LotOfferDAO implements ILotOfferDAO {

    private HashSet<LotOffer> lotOffers = DataBases.getLotOffers();

    @Override
    public void createLotOffer(LotOffer offer) throws DBError {
        lotOffers.add(offer);

        for(Lot lot:DataBases.getLots()) {
            if(lot.getId().equals(offer.getLotId())) {
                lot.getOffers().add(offer);
                return;
            }
        }
    }

    @Override
    public List<LotOffer> getAllFromLot(String id) throws DBError, NoIDException {

        for(Lot lot : DataBases.getLots()) {
            if(lot.getId().equals(id)) return lot.getOffers();
        }
        throw new NoIDException("Lot with this ID wasn't found");
    }

}
