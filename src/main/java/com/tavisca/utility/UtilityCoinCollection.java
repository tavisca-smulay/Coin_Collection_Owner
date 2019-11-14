package com.tavisca.utility;

import com.tavisca.coincollection.CoinCollection;
import com.tavisca.model.Coin;

import java.util.Date;

public class UtilityCoinCollection {
    public static void main(String[] args) {
        CoinCollection coinCollection = new CoinCollection();
        coinCollection.addCoin(new Coin("India", 5,
                "2014", 5.0, java.time.LocalDate.now()));

        coinCollection.addCoin(new Coin("India", 6,
                "2014", 6.0, java.time.LocalDate.now()));

        coinCollection.addCoin(new Coin("USA", 6,
                "2014", 6.0, java.time.LocalDate.now()));

        coinCollection.getCoinsBasedOnCountry("India").forEach(System.out::println);
    }
}
