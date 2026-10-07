package com.evcharging.controller;

import com.evcharging.dao.BookingDao;
import com.evcharging.model.Booking;
import com.evcharging.model.User;
import com.evcharging.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private final BookingDao bookingDao = new BookingDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!SessionUtil.isLoggedIn(request)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        User user = SessionUtil.getLoggedUser(request);
        List<Booking> bookings = bookingDao.findByUserId(user.getId());
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }
}
