package com.evcharging.controller;

import com.evcharging.dao.StationDao;
import com.evcharging.model.Station;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/stations")
public class StationsServlet extends HttpServlet {
    private final StationDao stationDao = new StationDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Station> stations = stationDao.findAll();
        request.setAttribute("stations", stations);
        request.getRequestDispatcher("/stations.jsp").forward(request, response);
    }
}
