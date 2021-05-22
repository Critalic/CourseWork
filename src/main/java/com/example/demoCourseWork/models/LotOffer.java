package com.example.demoCourseWork.models;

public class LotOffer {
    private final String owner;
    private final String text;
    private final int cost;
    private final String lotId;
    private String ownerName;

    public LotOffer(String owner, String text, int cost, String lotId, String ownerName) {
        this.owner = owner;
        this.text = text;
        this.cost = cost;
        this.lotId = lotId;
        this.ownerName = ownerName;
    }

    public LotOffer(String owner, String text, Long cost, String lotId, String ownerName) {
        this.owner = owner;
        this.text = text;
        this.cost = Math.toIntExact(cost);
        this.lotId = lotId;
        this.ownerName = ownerName;
    }

    public LotOffer(String owner, String text, String cost, String lotId, String ownerName) {
        this.owner = owner;
        this.text = text;
        this.cost = Integer.parseInt(cost);
        this.lotId = lotId;
        this.ownerName = ownerName;
    }

    public String getLotId() {
        return lotId;
    }

    public String getOwner() {
        return owner;
    }

    public String getText() {
        return text;
    }

    public int getMoney() {
        return cost;
    }

    public String getOwnerName() {return ownerName;};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotOffer)) return false;

        LotOffer offer = (LotOffer) o;

        if (getMoney() != offer.getMoney()) return false;
        if (!getOwner().equals(offer.getOwner())) return false;
        if (!getText().equals(offer.getText())) return false;
        return getLotId().equals(offer.getLotId());
    }

    @Override
    public int hashCode() {
        int result = getOwner().hashCode();
        result = 47 * result + getText().hashCode();
        result = 47 * result + getMoney();
        result = 47 * result + getLotId().hashCode();
        return result;
    }

}
