package com.evcharging.dao;

import com.evcharging.model.Station;

import java.util.ArrayList;
import java.util.List;

public class StationDao {
    private static final List<Station> STATIONS = new ArrayList<>();

    static {
        STATIONS.add(new Station(1, "GreenCharge Hub", "Bangalore", "MG Road, Bengaluru", "CCS2", 50.0, true, 24.0, 12.9716, 77.5946));
        STATIONS.add(new Station(2, "VoltNest Plaza", "Hyderabad", "Gachibowli, Hyderabad", "Type 2", 22.0, true, 18.0, 17.3850, 78.4867));
        STATIONS.add(new Station(3, "EcoPower Station", "Pune", "Kharadi, Pune", "CHAdeMO", 60.0, true, 30.0, 18.5204, 73.8567));
        STATIONS.add(new Station(4, "MetroFast Chargers", "Chennai", "T Nagar, Chennai", "CCS2", 35.0, true, 21.5, 13.0827, 80.2707));
    }

    public List<Station> findAll() {
        return new ArrayList<>(STATIONS);
    }

    public Station findById(int stationId) {
        for (Station station : STATIONS) {
            if (station.getId() == stationId) {
                return station;
            }
        }
        return null;
    }
}
