package com.tavisca.model;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Scanner;

public class OwnerClient {

    private Socket socket;
    private Owner owner;

    public OwnerClient(String serverName, int port, Owner owner) throws IOException {
        socket = new Socket(serverName, port);
        this.owner = owner;
    }

    public void sendAuctionCoinToAuction(AuctionCoin auctionCoin) throws IOException {

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(auctionCoin);
    }

    public void putCoinToAuction(Coin coin, LocalDate startDate, LocalDate endDate, double initialBidValue) throws IOException {

        AuctionCoin auctionCoin = new AuctionCoin(coin.getCountry(), coin.getDenomination(), coin.getYearOfMinting(),
                coin.getCurrentValue(), coin.getAcquiredDate(), startDate, endDate, initialBidValue);

        sendAuctionCoinToAuction(auctionCoin);
    }
}
