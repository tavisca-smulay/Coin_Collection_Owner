package com.tavisca.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tavisca.coincollection.CoinCollection;
import com.tavisca.model.Coin;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileCreator {

    public static void main(String[] args) {
        Coin coin1 = new Coin("India", 5, "2019", 5, LocalDate.now());
        Coin coin2 = new Coin("USA", 5, "2017", 5, LocalDate.now());
        Coin coin3 = new Coin("India", 6, "2019", 5, LocalDate.now());
        Coin coin4 = new Coin("India", 7, "2019", 5, LocalDate.now());
        Coin coin5 = new Coin("India", 8, "2019", 5, LocalDate.now());

        Set<Coin> coins = new HashSet<>();
        coins.add(coin1);
        coins.add(coin2);
        coins.add(coin3);
        coins.add(coin4);
        coins.add(coin5);

        CoinCollection coinCollection = new CoinCollection();
        coinCollection.setCoins(coins);

        try(FileWriter fileWriter = new FileWriter("Coins.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(coinCollection, fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
