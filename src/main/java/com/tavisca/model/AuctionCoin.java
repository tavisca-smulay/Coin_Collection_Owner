package com.tavisca.model;

import java.sql.Driver;
import java.time.LocalDate;
import java.util.HashMap;

public class AuctionCoin extends Coin {

    private LocalDate startDate;
    private LocalDate deadlineDate;
    private double initialBidValue;
    private HashMap<String, Double> userBidValues;  // HashMap<userId, bidValue>
    
}
