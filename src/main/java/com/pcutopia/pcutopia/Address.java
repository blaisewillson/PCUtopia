package com.pcutopia.pcutopia;

public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String country;
    public Address() {}

    public Address(String streetAddress, String city, String state, String zip, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return this.zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        String addressOutput = this.streetAddress + "\n" + this.city + ", " + this.state + " " + this.zip + "\n" + this.country;
        return addressOutput;
    }
}

