package com.example.demoCourseWork.models;

import com.example.demoCourseWork.Services.LotIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lot {
    private String ownerName;
    private String ownerId;
    private String info;
    private double startPrice;
    private List<LotOffer> offers = new ArrayList<>();
    private String id;
    private String name;
    private boolean isActive;

    public Lot(String ownerName, String ownerId, String info, String name, String startPrice ,boolean isActive) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.info = info;
        this.id = LotIDGenerator.generateID(name, ownerId, info);
        this.name = name;
        this.isActive = isActive;
        this.startPrice = Double.parseDouble(startPrice);
    }

    public Lot(String ownerName, String ownerId, String info, String name, double startPrice ,boolean isActive) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.info = info;
        this.id = LotIDGenerator.generateID(name, ownerId, info);
        this.name = name;
        this.isActive = isActive;
        this.startPrice = startPrice;
    }

    public String getOwner() {
        return ownerName;
    }

    public String getOwnerId() {
        return  ownerId;
    }

    public String getInfo() {
        return info;
    }

    public List<LotOffer> getOffers() {
        return offers;
    }

    public void addOffer (LotOffer offer) { this.offers.add(offer);}

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getPrice() {
        double price =startPrice;
        for(LotOffer lotOffer : this.getOffers()) {
            if(lotOffer.getMoney()>price) price = lotOffer.getMoney();
        }
        startPrice= price;
        return price;
    }

    public boolean isOwner(String user) {
        return ownerId.equals(user);
    }

    public void setStatus(boolean value) { isActive = value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot)) return false;

        Lot lot = (Lot) o;

        return getId().equals(lot.getId());
    }

    @Override
    public int hashCode() {
        int result = getOwner().hashCode();
        result = 47 * result + getInfo().hashCode();
        result = 47 * result + getOffers().hashCode();
        result = 47 * result + getId().hashCode();
        result = 47 * result + getName().hashCode();
        return result;
    }
}
