package com.ru.klimash.model;

import com.ru.klimash.gui.Field;
import com.ru.klimash.gui.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FieldModel {

    private final int[][] field;

    public static final int FIELD_SIZE = 10;

    private final List<Point> explodedCells;

    public FieldModel() {
        field = new int[FIELD_SIZE][FIELD_SIZE];
        explodedCells = new ArrayList<>();
    }

    public void isPressed(int x, int y, GameStage stage) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                if ((x-FIELD_SIZE >= 0 && x-Field.FIELD2_DISTANCE_FROM_START_COORDINATES < FIELD_SIZE && y >= 0 && y < FIELD_SIZE)) {
                    Controller.toggleSelectedCell(x, y, stage);
                }
                try {
                    if (GameModel.getPlayer2().getField()[x - Field.FIELD2_DISTANCE_FROM_START_COORDINATES][y] == 0)
                        GameManager.ChangePlayer();

                    if (GameModel.getPlayer2().getField()[x - Field.FIELD2_DISTANCE_FROM_START_COORDINATES][y] == 1) {
                        GameModel.getPlayer2().getField()[x - Field.FIELD2_DISTANCE_FROM_START_COORDINATES][y] = 2;
                        Ship damagedShip = Ship.getShipByCoordinates(Game.getShipsPlayer2(), new Point(x - Field.FIELD2_DISTANCE_FROM_START_COORDINATES, y)); // поврежденный корабль
                        if (GameManager.isShipDead(damagedShip, GameModel.getPlayer2())) { // если корабль подбит
                            GameManager.paintAroundDefeatedShip(damagedShip, GameModel.getPlayer2(), Game.getGameStage());
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ход 1 игрока!");
                }
                if (GameManager.arePlayerShipsDefeated(GameModel.getPlayer2()))
                    Game.setGameStage(GameStage.GAME_OVER);
            }
            case TURN_PLAYER2 -> {
                if (x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE) {
                    Controller.toggleSelectedCell(x, y, stage);
                }
                try {
                    if (GameModel.getPlayer1().getField()[x][y] == 0)
                        GameManager.ChangePlayer();
                    if (GameModel.getPlayer1().getField()[x][y] == 1) {
                        GameModel.getPlayer1().getField()[x][y] = 2;
                        Ship damagedShip = Ship.getShipByCoordinates(Game.getShipsPlayer1(), new Point(x, y)); // поврежденный корабль
                        if (GameManager.isShipDead(damagedShip, GameModel.getPlayer1())) { // если корабль подбит
                            GameManager.paintAroundDefeatedShip(damagedShip, GameModel.getPlayer1(), Game.getGameStage());
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ход 2 игрока!");
                }
                if (GameManager.arePlayerShipsDefeated(GameModel.getPlayer1()))
                    Game.setGameStage(GameStage.GAME_OVER);
            }
        }
    }
    public int[][] getField() {
        return field;
    }

    public List<Point> getExplodedCells() {
        return explodedCells;
    }
}