package com.tavisca.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class AuctionCoin extends Coin implements Serializable {

    private LocalDate startDate;
    private LocalDate endDate;
    private double initialBidValue;
    private HashMap<String, Double> userBidValues;  // HashMap<userId, bidValue>

    public AuctionCoin(String country, int denomination, String yearOfMinting, double currentValue,
                       LocalDate acquiredDate, LocalDate startDate, LocalDate endDate, double initialBidValue) {
        super(country, denomination, yearOfMinting, currentValue, acquiredDate);
        this.startDate = startDate;
        this.endDate = endDate;
        this.initialBidValue = initialBidValue;
    }

    @Override
    public String toString() {
        return "AuctionCoin{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", initialBidValue=" + initialBidValue +
                ", userBidValues=" + userBidValues +
                '}';
    }
}
