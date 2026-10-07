package com.evcharging.controller;

import com.evcharging.dao.BookingDao;
import com.evcharging.dao.StationDao;
import com.evcharging.model.Booking;
import com.evcharging.model.Station;
import com.evcharging.model.User;
import com.evcharging.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private final StationDao stationDao = new StationDao();
    private final BookingDao bookingDao = new BookingDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!SessionUtil.isLoggedIn(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String stationIdStr = request.getParameter("stationId");
        if (stationIdStr == null || stationIdStr.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/stations");
            return;
        }

        try {
            int stationId = Integer.parseInt(stationIdStr);
            Station station = stationDao.findById(stationId);
            if (station == null) {
                response.sendRedirect(request.getContextPath() + "/stations");
                return;
            }
            request.setAttribute("station", station);
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/stations");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!SessionUtil.isLoggedIn(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        User user = SessionUtil.getLoggedUser(request);
        String stationIdStr = request.getParameter("stationId");
        String date = request.getParameter("date");
        String slot = request.getParameter("slot");

        if (stationIdStr == null || date == null || slot == null || date.trim().isEmpty() || slot.trim().isEmpty()) {
            request.setAttribute("error", "Please provide a valid date and slot.");
            request.getRequestDispatcher("/booking.jsp").forward(request, response);
            return;
        }

        try {
            int stationId = Integer.parseInt(stationIdStr);
            Station station = stationDao.findById(stationId);
            if (station == null) {
                response.sendRedirect(request.getContextPath() + "/stations");
                return;
            }

            Booking booking = new Booking();
            booking.setUserId(user.getId());
            booking.setStationId(station.getId());
            booking.setBookingDate(date);
            booking.setSlot(slot);
            booking.setStatus("Confirmed");
            booking.setTotalAmount(station.getPricePerHour());
            bookingDao.save(booking);

            response.sendRedirect(request.getContextPath() + "/dashboard");
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/stations");
        }
    }
}
