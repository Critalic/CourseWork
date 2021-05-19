package com.example.demoCourseWork.models;

import java.util.List;

public class Lot {
    private String owner;
    private String info;
    private List<LotOffer> offers;
    private String id;
    private String name;
    private boolean isActive;

    public Lot(String owner, String info, List<LotOffer> offers, String id, String name, boolean isActive) {
        this.owner = owner;
        this.info = info;
        this.offers = offers;
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public String getOwner() {
        return owner;
    }

    public String getInfo() {
        return info;
    }

    public List<LotOffer> getOffers() {
        return offers;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isOwner(String user) {
        return owner.equals(user);
    }

    public void setStatus(boolean value) { isActive = value;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lot)) return false;

        Lot lot = (Lot) o;

        if (isActive() != lot.isActive()) return false;
        if (!getOwner().equals(lot.getOwner())) return false;
        if (!getInfo().equals(lot.getInfo())) return false;
        if (!getOffers().equals(lot.getOffers())) return false;
        if (!getId().equals(lot.getId())) return false;
        return getName().equals(lot.getName());
    }

    @Override
    public int hashCode() {
        int result = getOwner().hashCode();
        result = 47 * result + getInfo().hashCode();
        result = 47 * result + getOffers().hashCode();
        result = 47 * result + getId().hashCode();
        result = 47 * result + getName().hashCode();
        result = 47 * result + (isActive() ? 1 : 0);
        return result;
    }
}
