package com.ru.klimash.gui;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public Game() {
        setTitle("Sea Battle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1180, 515);
        setLocationRelativeTo(null);

        Field field = new Field();
        add(field, BorderLayout.CENTER);

        // Игрок 1

        // однопалубные
        field.placeShip_player1(0, 0);
        field.placeShip_player1(9, 6);
        field.placeShip_player1(1, 8);
        field.placeShip_player1(3, 9);

        // двухпалубные
        field.placeShip_player1(1, 2);
        field.placeShip_player1(2, 2);

        field.placeShip_player1(1, 4);
        field.placeShip_player1(2, 4);

        field.placeShip_player1(1, 6);
        field.placeShip_player1(2, 6);

        // трехпалубные
        field.placeShip_player1(5, 4);
        field.placeShip_player1(5, 5);
        field.placeShip_player1(5, 6);

        field.placeShip_player1(7, 8);
        field.placeShip_player1(8, 8);
        field.placeShip_player1(9, 8);

        // четырехпалубные

        field.placeShip_player1(6, 1);
        field.placeShip_player1(7, 1);
        field.placeShip_player1(8, 1);
        field.placeShip_player1(9, 1);

        // Игрок 2

        // однопалубные
        field.placeShip_player2(0, 0);
        field.placeShip_player2(9, 6);
        field.placeShip_player2(1, 8);
        field.placeShip_player2(3, 9);

        // двухпалубные
        field.placeShip_player2(1, 2);
        field.placeShip_player2(2, 2);

        field.placeShip_player2(1, 4);
        field.placeShip_player2(2, 4);

        field.placeShip_player2(1, 6);
        field.placeShip_player2(2, 6);

        // трехпалубные
        field.placeShip_player2(5, 4);
        field.placeShip_player2(5, 5);
        field.placeShip_player2(5, 6);

        field.placeShip_player2(7, 8);
        field.placeShip_player2(8, 8);
        field.placeShip_player2(9, 8);

        // четырехпалубные

        field.placeShip_player2(6, 1);
        field.placeShip_player2(7, 1);
        field.placeShip_player2(8, 1);
        field.placeShip_player2(9, 1);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }
}
