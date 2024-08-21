package com.ru.klimash.gui;

import com.ru.klimash.model.Controller;
import com.ru.klimash.model.Ship;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {

    private static List<Ship> shipsPlayer1;
    private static List<Ship> defeatedShipsPlayer1;
    private static List<Ship> shipsPlayer2;
    private static List<Ship> defeatedShipsPlayer2;

    private static final int NUMBER_OF_SHIPS = 10;


    public Game() {
        setTitle("Sea Battle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1180, 515);
        setLocationRelativeTo(null);

        Field field = new Field();
        Controller controller = new Controller(field);
        add(field, BorderLayout.CENTER);


        shipsPlayer1 = new ArrayList<>();
        defeatedShipsPlayer1 = new ArrayList<>();
        shipsPlayer2 = new ArrayList<>();
        defeatedShipsPlayer2 = new ArrayList<>();


        // Игрок 1

        // однопалубные
        shipsPlayer1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(0, 0));
        }}, false));

        shipsPlayer1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(9, 6));
        }}, false));

        shipsPlayer1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(1, 8));
        }}, false));

        shipsPlayer1.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(3, 9));
        }}, false));



        // двухпалубные
        shipsPlayer1.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 2));
            add(new Point(2, 2));
        }}, false));

        shipsPlayer1.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 4));
            add(new Point(2, 4));
        }}, false));

        shipsPlayer1.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(1, 6));
            add(new Point(2, 6));
        }}, false));

        // трехпалубные
        shipsPlayer1.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(5, 4));
            add(new Point(5, 5));
            add(new Point(5, 6));
        }}, true));

        shipsPlayer1.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(7, 8));
            add(new Point(8, 8));
            add(new Point(9, 8));
        }}, false));




        // четырехпалубные
        shipsPlayer1.add(new Ship(4, new ArrayList<Point>(){{
            add(new Point(6, 1));
            add(new Point(7, 1));
            add(new Point(8, 1));
            add(new Point(9, 1));
        }}, false));


        // Игрок 2

        // однопалубные
        shipsPlayer2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(12, 0));
        }}, false));

        shipsPlayer2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(21, 6));
        }}, false));

        shipsPlayer2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(13, 8));
        }}, false));

        shipsPlayer2.add(new Ship(1, new ArrayList<Point>(){{
            add(new Point(15, 9));
        }}, false));



        // двухпалубные
        shipsPlayer2.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(13, 2));
            add(new Point(14, 2));
        }}, false));

        shipsPlayer2.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(13, 4));
            add(new Point(14, 4));
        }}, false));

        shipsPlayer2.add(new Ship(2, new ArrayList<Point>(){{
            add(new Point(13, 6));
            add(new Point(14, 6));
        }}, false));



        // трехпалубные
        shipsPlayer2.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(17, 4));
            add(new Point(17, 5));
            add(new Point(17, 6));
        }}, true));

        shipsPlayer2.add(new Ship(3, new ArrayList<Point>(){{
            add(new Point(19, 8));
            add(new Point(20, 8));
            add(new Point(21, 8));
        }}, false));



        // четырехпалубные
        shipsPlayer2.add(new Ship(4, new ArrayList<Point>(){{
            add(new Point(18, 1));
            add(new Point(19, 1));
            add(new Point(20, 1));
            add(new Point(21, 1));
        }}, false));


        // Рисуем корабли
        for (int i = 0; i < NUMBER_OF_SHIPS; i++) {

            for (Point p : shipsPlayer1.get(i).getCells())
                field.placeShip_player1(p.x, p.y);

            for (Point p : shipsPlayer2.get(i).getCells())
                field.placeShip_player2(p.x, p.y);
        }
        setVisible(true);
    }

    public static List<Ship> getShipsPlayer1() {
        return shipsPlayer1;
    }

    public static List<Ship> getShipsPlayer2() {
        return shipsPlayer2;
    }
    public static List<Ship> getDefeatedShipsPlayer1() {
        return defeatedShipsPlayer1;
    }

    public static List<Ship> getDefeatedShipsPlayer2() {
        return defeatedShipsPlayer2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }
}
