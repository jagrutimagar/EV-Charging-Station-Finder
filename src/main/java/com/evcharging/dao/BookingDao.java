package com.evcharging.dao;

import com.evcharging.model.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingDao {
    private static final Map<Integer, Booking> BOOKINGS = new HashMap<>();
    private static int nextId = 1;

    public void save(Booking booking) {
        if (booking == null) {
            return;
        }
        if (booking.getId() == 0) {
            booking.setId(nextId++);
        }
        BOOKINGS.put(booking.getId(), booking);
    }

    public List<Booking> findByUserId(int userId) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : BOOKINGS.values()) {
            if (booking.getUserId() == userId) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }
}
