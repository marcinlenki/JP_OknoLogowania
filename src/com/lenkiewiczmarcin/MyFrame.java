package com.lenkiewiczmarcin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Klasa zawierająca kontruktor, który odpowiada za edycję elementów i ich zachowań
 * wyświetlanych na głównym oknie programu.
 * Klasa dziedziczy po klasie JFrame.
 */

public class MyFrame extends JFrame {

    private static final LoggingManager loggingManager = new LoggingManager();
    private static final Color LIGHT_RED = new Color(255,51,51);
    private static final Color DARK_GREEN = new Color(0,153,0);
    private static final Color DEFAULT = UIManager.getColor ( "Panel.background" );

    public MyFrame(String title) {
        super(title);

        JLabel loginLabel = new JLabel("Login: ");
        JLabel passwordLabel = new JLabel("Hasło: ");

        JTextField loginField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JButton confirmBtn = new JButton("Potwierdź");
        JButton restartBtn = new JButton("Reset");
        restartBtn.setToolTipText("Powróć do oryginalnego stanu okna logowania."); // Pokazuje okno z komentarzem pomocniczym po najechaniu na przycisk "Reset".
        getRootPane().setDefaultButton(confirmBtn); // Umożliwia naciśnięcie przycisku "Potwierdź" przez naciśnięcie klawisza ENTER.

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.anchor = GridBagConstraints.LINE_END; // Wyświetlany element będzie ustawiony w taki sposób, żeby wyrównać się z końcem komórki w której się znajduje.

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(loginLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        gbc.anchor = GridBagConstraints.LINE_START; // Wyświetlany element będzie ustawiony w taki sposób, żeby wyrównać się z początkiem komórki w której się znajduje.

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(loginField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        gbc.weighty = 2;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(confirmBtn, gbc);

        gbc.weighty = 5;

        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.anchor = GridBagConstraints.SOUTHEAST; // Wyświetlany element będzie ustawiony w taki sposób, żeby znajdować się w prawym dolnym rogu komórki.
        add(restartBtn, gbc);


        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                char[] password = passwordField.getPassword();

                if (loggingManager.confirm(login, String.valueOf(password))) {
                    setBackground(DARK_GREEN);
                    getContentPane().setBackground(DARK_GREEN);
                } else {
                    setBackground(LIGHT_RED);
                    getContentPane().setBackground(LIGHT_RED);
                }

                Arrays.fill(password, (char) 0); // Wyzerowanie tablicy ze względów bezpieczeństwa
            }
        });

        restartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginField.setText("");
                passwordField.setText("");
                setBackground(DEFAULT);
                getContentPane().setBackground(DEFAULT);
            }
        });
    }
}