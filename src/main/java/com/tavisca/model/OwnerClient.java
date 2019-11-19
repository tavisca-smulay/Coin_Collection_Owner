package com.tavisca.model;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class OwnerClient {

    private Socket socket;
    private Owner owner;
    BufferedOutputStream bufferedOutputStream ;
    ObjectOutputStream objectOutputStream ;
    BufferedInputStream bufferedInputStream;
    ObjectInputStream objectInputStream;

    public OwnerClient(String serverName, int port, Owner owner) throws IOException {

        socket = new Socket(serverName, port);
        bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.flush();
        objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.flush();

        bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        objectInputStream = new ObjectInputStream(bufferedInputStream);
        this.owner = owner;
    }

//    public void sendAuctionCoinToAuction(AuctionCoin auctionCoin) throws IOException {
//
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
//        objectOutputStream.writeObject(auctionCoin);
//
//        objectOutputStream.close();
//        bufferedOutputStream.close();
//    }

    public void sendAuctionCoinsToAuction(List<AuctionCoin> auctionCoins) throws IOException {
        objectOutputStream.writeObject(auctionCoins);
        objectOutputStream.flush();
    }

//    public void putCoinToAuction(Coin coin, LocalDate startDate, LocalDate endDate, double initialBidValue) throws IOException {
//
//        AuctionCoin auctionCoin = new AuctionCoin(coin.getCountry(), coin.getDenomination(), coin.getYearOfMinting(),
//                coin.getCurrentValue(), coin.getAcquiredDate(), startDate, endDate, initialBidValue);
//
//        sendAuctionCoinToAuction(auctionCoin);
//    }

    public HashMap<String, List<AuctionCoin>> getOwnersAuctionCoinsFromAuction() throws IOException, ClassNotFoundException {
        return (HashMap<String, List<AuctionCoin>>) objectInputStream.readObject();
    }

    public void sendOwnerIdToAuction(String ownerId) throws IOException {
        objectOutputStream.writeObject(ownerId);
        objectOutputStream.flush();
    }

    public void closeStreams() throws IOException {
        objectOutputStream.close();
        bufferedOutputStream.close();
        objectInputStream.close();
        bufferedInputStream.close();
        socket.close();
    }


}
