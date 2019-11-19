package com.tavisca.model;

import com.google.gson.Gson;
import com.tavisca.coincollection.CoinCollection;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

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

    public AuctionCoin getAuctionCoinFromCoin(Coin coin, LocalDate startDate,
                                              LocalDate endDate, double initialBidValue) throws IOException{
        AuctionCoin auctionCoin = new AuctionCoin(coin.getCountry(), coin.getDenomination(), coin.getYearOfMinting(),
                coin.getCurrentValue(), coin.getAcquiredDate(), startDate, endDate, initialBidValue);
        return auctionCoin;
    }
}
