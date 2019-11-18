package com.tavisca.main;

import com.tavisca.coincollection.CoinCollection;
import com.tavisca.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class OwnerMain {
    public static void main(String[] args) {

        Owner owner = null; //have to make it for multiple owners
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

//            System.out.println("Enter 1 for search based on Country");
//            System.out.println("Enter 2 for search based on Year of Minting");
//            System.out.println("Enter 3 for search based on Current Value");
//            System.out.println("Enter 4 for search based on Country + Denomination");
//            System.out.println("Enter 5 for search based on Country + Year of Minting");
//            System.out.println("Enter 6 for search based on Country + Denomination + Year of Minting");
//            System.out.println("Enter 7 for search based on Acquired Date + Country");
//
//            System.out.println("Please choose search criteria");
//            int choice = Integer.parseInt(br.readLine());
//
//            CoinCollection coinCollection = new CoinCollection();
//
//            switch (choice){
//                case 1:
//                    coinCollection.getCoinsBasedOnCountry()
//            }



            OwnerService ownerService = new OwnerService();
            owner = new Owner(1, "Shivani", ownerService.getBulkData());
            OwnerClient ownerClient = new OwnerClient("172.16.5.168", 9090, owner);


            List<Coin> listBasedOnCountry = owner.getCoinCollection().getCoinsBasedOnCountry("India");
            System.out.println(listBasedOnCountry);

            List<AuctionCoin> auctionCoins = new ArrayList<>();

            for(Coin coin: listBasedOnCountry) {
                System.out.println(coin.toString());

                LocalDate startDate = LocalDate.now();  // will be changed into user input
                LocalDate endDate = LocalDate.now().plusDays(3); // will be changed into user input

                System.out.println("Enter Bid Value");
                double initialBidValue = Double.parseDouble(br.readLine());

                auctionCoins.add(ownerService.getAuctionCoinFromCoin(coin, startDate, endDate, initialBidValue));
                //ownerClient.putCoinToAuction(coin, startDate, endDate, initialBidValue);
            }

            ownerClient.sendAuctionCoinsToAuction(auctionCoins);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //mark coin for auction
        //to know progress of the auction
        //close auction by selecting a bid

    }
}
