package com.evcharging.model;

public class Station {
    private int id;
    private String name;
    private String city;
    private String address;
    private String connectorType;
    private double powerKw;
    private boolean available;
    private double pricePerHour;
    private double latitude;
    private double longitude;

    public Station() {
    }

    public Station(int id, String name, String city, String address, String connectorType,
                   double powerKw, boolean available, double pricePerHour,
                   double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.connectorType = connectorType;
        this.powerKw = powerKw;
        this.available = available;
        this.pricePerHour = pricePerHour;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }

    public double getPowerKw() {
        return powerKw;
    }

    public void setPowerKw(double powerKw) {
        this.powerKw = powerKw;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
