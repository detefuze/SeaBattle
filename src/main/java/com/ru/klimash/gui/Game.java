package com.ru.klimash.gui;

import com.ru.klimash.model.GameModel;
import com.ru.klimash.model.GameStage;
import com.ru.klimash.model.Ship;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {

    private static List<Ship> shipsPlayer1;
    private static List<Ship> shipsPlayer2;
    private static final int NUMBER_OF_SHIPS = 10;
    private static GameStage gameStage;
    private static GameModel gameModel;


    public Game() {
        setTitle("Sea Battle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1180, 515);
        setLocationRelativeTo(null);

        PreGameWindow window = new PreGameWindow();

        Game.setGameStage(GameStage.TURN_PLAYER1);

        gameModel = new GameModel();

        Field field = new Field();

        add(field, BorderLayout.CENTER);

        shipsPlayer1 = new ArrayList<>();
        shipsPlayer2 = new ArrayList<>();

        // Игрок 1

        // однопалубные
        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(0, 0));
        }}));

        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(9, 6));
        }}));

        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 8));
        }}));

        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(3, 9));
        }}));

        // двухпалубные
        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 2));
            add(new Point(2, 2));
        }}));
        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 4));
            add(new Point(2, 4));
        }}));

        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 6));
            add(new Point(2, 6));
        }}));

        // трехпалубные
        shipsPlayer1.add(new Ship( new ArrayList<Point>(){{
            add(new Point(5, 4));
            add(new Point(5, 5));
            add(new Point(5, 6));
        }}));

        shipsPlayer1.add(new Ship( new ArrayList<Point>(){{
            add(new Point(7, 8));
            add(new Point(8, 8));
            add(new Point(9, 8));
        }}));

        // четырехпалубные
        shipsPlayer1.add(new Ship(new ArrayList<Point>(){{
            add(new Point(6, 1));
            add(new Point(7, 1));
            add(new Point(8, 1));
            add(new Point(9, 1));
        }}));


        // Игрок 2

        // однопалубные
        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(0, 0));
        }}));

        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(9, 6));
        }}));

        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 8));
        }}));

        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(3, 9));
        }}));

        // двухпалубные
        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 2));
            add(new Point(2, 2));
        }}));
        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 4));
            add(new Point(2, 4));
        }}));

        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(1, 6));
            add(new Point(2, 6));
        }}));

        // трехпалубные
        shipsPlayer2.add(new Ship( new ArrayList<Point>(){{
            add(new Point(5, 4));
            add(new Point(5, 5));
            add(new Point(5, 6));
        }}));

        shipsPlayer2.add(new Ship( new ArrayList<Point>(){{
            add(new Point(7, 8));
            add(new Point(8, 8));
            add(new Point(9, 8));
        }}));

        // четырехпалубные
        shipsPlayer2.add(new Ship(new ArrayList<Point>(){{
            add(new Point(6, 1));
            add(new Point(7, 1));
            add(new Point(8, 1));
            add(new Point(9, 1));
        }}));

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Game::new);
    }

    public static void setGameStage(GameStage gameStage) {
        Game.gameStage = gameStage;
    }

    public static GameStage getGameStage() {
        return gameStage;
    }

    public static GameModel getGameModel() {
        return gameModel;
    }
}
