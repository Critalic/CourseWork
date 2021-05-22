package com.example.demoCourseWork.DB;

import com.example.demoCourseWork.models.Lot;
import com.example.demoCourseWork.models.LotOffer;
import com.example.demoCourseWork.models.User;

import java.util.ArrayList;
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
        if(lots.size()==0) addDefault();
        return lots;
    }

    public static HashSet<LotOffer> getLotOffers() {
        return lotOffers;
    }

    private static void addDefault () {
        User admin = new User("Admin", "admin@gmail.com", "1234");
        User vt = new User("VTLKR", "vtlkr@gmail.com", "1234");
        LotOffer forl1 = new LotOffer("admin@gmail.com", "I want your BMW", "35", "1", "Admin");
        LotOffer forrl1 = new LotOffer("admin@gmail.com", "I want your BMW", "37", "", "Admin");
        ArrayList<LotOffer> offers2 = new ArrayList<>();
        offers2.add(forl1);
        Lot l1 = new Lot("Andrew" ,"vtlkr@gmail.com", "A set of tea cups", "Tea cups", 10,true);
        l1.addOffer(forl1);
        l1.addOffer(forrl1);
        Lot l2 = new Lot("Andrew","vtlkr@gmail.com", "A set of tea platters", "Tea platters", 12,true);
        users.add(admin);
        users.add(vt);
        lotOffers.add(forl1);
        lots.add(l1);
        lots.add(l2);
    }
}
