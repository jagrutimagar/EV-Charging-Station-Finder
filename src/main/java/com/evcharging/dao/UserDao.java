package com.evcharging.dao;

import com.evcharging.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static final Map<String, User> USERS = new HashMap<>();
    private static int nextId = 1;

    static {
        UserDao.save(new User(nextId++, "Admin User", "admin@evcharge.com", "admin123"));
    }

    public static User findByEmail(String email) {
        if (email == null) {
            return null;
        }
        return USERS.get(email.trim().toLowerCase());
    }

    public static void save(User user) {
        if (user == null || user.getEmail() == null) {
            return;
        }
        user.setEmail(user.getEmail().trim().toLowerCase());
        if (user.getId() == 0) {
            user.setId(nextId++);
        }
        USERS.put(user.getEmail(), user);
    }

    public boolean exists(String email) {
        return findByEmail(email) != null;
    }
}
