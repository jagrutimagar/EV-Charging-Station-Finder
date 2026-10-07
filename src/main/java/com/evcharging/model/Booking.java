package com.evcharging.model;

public class Booking {
    private int id;
    private int userId;
    private int stationId;
    private String bookingDate;
    private String slot;
    private String status;
    private double totalAmount;

    public Booking() {
    }

    public Booking(int id, int userId, int stationId, String bookingDate, String slot,
                   String status, double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.stationId = stationId;
        this.bookingDate = bookingDate;
        this.slot = slot;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
