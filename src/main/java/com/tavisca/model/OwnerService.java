package com.tavisca.model;

import com.google.gson.Gson;
import com.tavisca.coincollection.CoinCollection;
import java.io.FileReader;
import java.io.IOException;


public class OwnerService {

    public CoinCollection getBulkData(){
        CoinCollection coinCollection = new CoinCollection();

        Gson gson = new Gson();

        try (FileReader fileReader = new FileReader("coins.json")) {
            coinCollection = gson.fromJson(fileReader, CoinCollection.class);
            System.out.println(coinCollection.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coinCollection;
    }
}
