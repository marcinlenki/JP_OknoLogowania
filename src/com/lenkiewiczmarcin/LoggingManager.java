package com.lenkiewiczmarcin;

import java.util.ArrayList;

/**
 * Klasa zawierająca listę wszystkich użytkowników oraz metody służące do ich lokalizowania.
 */

public class LoggingManager {

    private static ArrayList<User> users;

    public LoggingManager() {
        users = new ArrayList<>();
        // Zakodowanie wcześniej obiekty typu User.
        User user1 = new User("marcin", "student123");
        User user2 = new User("boguslaw", "haslo123");
        User user3 = new User("bogdan", "qwerty");

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public boolean confirm(String login, String password) {
        User user = findUser(login);

        if (user == null)
            return false;

        return user.getPassword().equals(password);
    }

    private User findUser(String login) {
        for (User u : users) {
            if (login.equals(u.getLogin()))
                return u;
        }

        return null;
    }
}
