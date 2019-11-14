package com.tavisca.coincollection;

import com.tavisca.model.Coin;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CoinCollection {
    Set<Coin> coins;

    public CoinCollection(){
        coins = new HashSet<>();
    }

    public List<Coin> getCoinsBasedOnCountry(String country){
        return coins.stream().filter(coin -> coin.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }

    public List<Coin> getCoinsBasedOnYearOfMinting(String yearOfMinting){
        return coins.stream().filter(coin -> coin.getYearOfMinting().equalsIgnoreCase(yearOfMinting))
                .collect(Collectors.toList());
    }

    public List<Coin> getCoinsBasedOnCurrentValue(double currentValue){
        return coins.stream().sorted(Comparator.
                comparingDouble(Coin::getCurrentValue)).collect(Collectors.toList());
    }

    public List<Coin> getCoinsBasedOnCountryAndDenomination(String country, int denomination){
        return coins.stream().filter(coin -> coin.getCountry().equalsIgnoreCase(country) &&
                coin.getDenomination() == denomination).collect(Collectors.toList());
    }

    public List<Coin> getCoinsBasedOnCountryAndYearOfMinting(String country, String yearOfMinting){
        return coins.stream().filter(coin -> coin.getCountry().equalsIgnoreCase(country) &&
                coin.getYearOfMinting().equalsIgnoreCase(yearOfMinting)).collect(Collectors.toList());
    }

    public List<Coin> getCoinsBasedOnCountryAndDenominationAndYearOfMinting
            (String country, int denomination, String yearOfMinting){
        return coins.stream().filter(coin -> coin.getCountry().equalsIgnoreCase(country) &&
                coin.getDenomination() == denomination &&
                coin.getYearOfMinting().equalsIgnoreCase(yearOfMinting)).collect(Collectors.toList());
    }

    public List<Coin> getCoinsBasedOnAcquiredDateAndCountry(LocalDate date, String country){
        return coins.stream().filter(coin -> coin.getAcquiredDate().isEqual(date)
                       && coin.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
    }

    public void addCoin(Coin coin){
        coins.add(coin);
    }

    public Set<Coin> getCoins() {
        return coins;
    }

    public void setCoins(Set<Coin> coins) {
        this.coins = coins;
    }

}
