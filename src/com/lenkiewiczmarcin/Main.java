package com.lenkiewiczmarcin;

import javax.swing.*;

/**
 * Klasa główna zawierająca metodę statyczną main.
 */

public class Main {

    public static void main(String[] args) {

        JFrame frame = new MyFrame("Okno logowania");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setSize(500, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program zamyka się przy zamknięciu okna.
                frame.setLocationRelativeTo(null); // Okno pojawia się na środku ekranu.
                frame.setResizable(false); // Zapobiega zmianie wielkości okna.
                frame.setVisible(true);
            }
        });
    }
}