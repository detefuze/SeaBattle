package com.ru.klimash.gui;

import com.ru.klimash.model.Ship;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {

    private List<Ship> ships_player1;
    private List<Ship> ships_player2;

    private static final int NUMBER_OF_SHIPS = 10;


    public Game() {
        setTitle("Sea Battle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1180, 515);
        setLocationRelativeTo(null);

        Field field = new Field();
        add(field, BorderLayout.CENTER);

        ships_player1 = new ArrayList<>();
        ships_player2 = new ArrayList<>();


        // Игрок 1

        // однопалубные
        ships_player1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(0, 0));
        }}, false));

        ships_player1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(9, 6));
        }}, false));

        ships_player1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(1, 8));
        }}, false));

        ships_player1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(3, 9));
        }}, false));



        // двухпалубные
        ships_player1.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 2));
            add(new Point(2, 2));
        }}, false));

        ships_player1.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 4));
            add(new Point(2, 4));
        }}, false));

        ships_player1.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 6));
            add(new Point(2, 6));
        }}, false));



        // трехпалубные
        ships_player1.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(5, 4));
            add(new Point(5, 5));
            add(new Point(5, 6));
        }}, true));

        ships_player1.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(7, 8));
            add(new Point(8, 8));
            add(new Point(9, 8));
        }}, false));




        // четырехпалубные
        ships_player1.add(new Ship(4, new ArrayList<Point>(){{
            add(new Point(6, 1));
            add(new Point(7, 1));
            add(new Point(8, 1));
            add(new Point(9, 1));
        }}, false));


        // Игрок 2

        // однопалубные
        ships_player2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(0, 0));
        }}, false));

        ships_player2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(9, 6));
        }}, false));

        ships_player2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(1, 8));
        }}, false));

        ships_player2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(3, 9));
        }}, false));



        // двухпалубные
        ships_player2.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 2));
            add(new Point(2, 2));
        }}, false));

        ships_player2.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 4));
            add(new Point(2, 4));
        }}, false));

        ships_player2.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 6));
            add(new Point(2, 6));
        }}, false));



        // трехпалубные
        ships_player2.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(5, 4));
            add(new Point(5, 5));
            add(new Point(5, 6));
        }}, true));

        ships_player2.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(7, 8));
            add(new Point(8, 8));
            add(new Point(9, 8));
        }}, false));



        // четырехпалубные
        ships_player2.add(new Ship(4, new ArrayList<Point>(){{
            add(new Point(6, 1));
            add(new Point(7, 1));
            add(new Point(8, 1));
            add(new Point(9, 1));
        }}, false));


        // Рисуем корабли
        for (int i = 0; i < NUMBER_OF_SHIPS; i++) {

            for (Point p : ships_player1.get(i).cells)
                field.placeShip_player1(p.x, p.y);

            for (Point p : ships_player2.get(i).cells)
                field.placeShip_player2(p.x, p.y);
        }



        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }
}
