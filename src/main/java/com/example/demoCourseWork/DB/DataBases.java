package com.example.demoCourseWork.DB;

import com.example.demoCourseWork.models.Lot;
import com.example.demoCourseWork.models.LotOffer;
import com.example.demoCourseWork.models.User;

import java.util.HashSet;

public class DataBases {
    private static HashSet<User> users = new HashSet<>();
    private static HashSet<Lot> lots = new HashSet<Lot>();
    private static HashSet<LotOffer> lotOffers = new HashSet<>();

    private DataBases() {}

    public static HashSet<User> getUsers() {
        return users;
    }

    public static HashSet<Lot> getLots() {
        return lots;
    }

    public static HashSet<LotOffer> getLotOffers() {
        return lotOffers;
    }
}
