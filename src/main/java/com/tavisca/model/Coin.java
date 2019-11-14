package com.tavisca.model;

import java.time.LocalDate;

public class Coin {
    private String country;
    private int denomination;
    private String yearOfMinting;
    private double currentValue;
    private LocalDate acquiredDate;

    public Coin() {
    }

    public Coin(String country, int denomination, String yearOfMinting, double currentValue, LocalDate acquiredDate) {
        this.country = country;
        this.denomination = denomination;
        this.yearOfMinting = yearOfMinting;
        this.currentValue = currentValue;
        this.acquiredDate = acquiredDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public String getYearOfMinting() {
        return yearOfMinting;
    }

    public void setYearOfMinting(String yearOfMinting) {
        this.yearOfMinting = yearOfMinting;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public LocalDate getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(LocalDate acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "country='" + country + '\'' +
                ", denomination=" + denomination +
                ", yearOfMinting='" + yearOfMinting + '\'' +
                ", currentValue=" + currentValue +
                ", acquiredDate=" + acquiredDate +
                '}';
    }
}
