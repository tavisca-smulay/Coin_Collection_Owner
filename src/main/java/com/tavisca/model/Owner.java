package com.tavisca.model;

import com.tavisca.coincollection.CoinCollection;

public class Owner {

    private int ownerID;
    private String ownerName;
    private CoinCollection coinCollection;

    public Owner() {
    }

    public Owner(int ownerID, String ownerName, CoinCollection coinCollection) {
        this.ownerID = ownerID;
        this.ownerName = ownerName;
        this.coinCollection = coinCollection;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public CoinCollection getCoinCollection() {
        return coinCollection;
    }

    public void setCoinCollection(CoinCollection coinCollection) {
        this.coinCollection = coinCollection;
    }
}
