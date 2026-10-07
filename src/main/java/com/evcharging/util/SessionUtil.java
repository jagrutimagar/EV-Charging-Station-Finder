package com.evcharging.util;

import com.evcharging.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public final class SessionUtil {
    private SessionUtil() {
    }

    public static User getLoggedUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return (User) session.getAttribute("user");
    }

    public static boolean isLoggedIn(HttpServletRequest request) {
        return getLoggedUser(request) != null;
    }
}
