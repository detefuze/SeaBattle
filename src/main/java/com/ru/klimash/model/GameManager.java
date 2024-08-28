package com.ru.klimash.model;

import com.ru.klimash.gui.Game;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    public boolean isDeadPlayer1Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (GameModel.getPlayer1().getField()[p.x][p.y] == 1) {
                return ship.isDefeated();
            }
        }
        ship.setDefeated(true);
        if (arePlayerShipsDefeated(GameModel.getPlayer1()))
            Game.setGameStage(GameStage.GAME_OVER);
        return ship.isDefeated();
    }

    public boolean isDeadPlayer2Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (GameModel.getPlayer2().getField()[p.x][p.y] == 1) {
                return false;
            }
        }
        ship.setDefeated(true);
        if (arePlayerShipsDefeated(GameModel.getPlayer2()))
            Game.setGameStage(GameStage.GAME_OVER);
        return true;
    }

    public static boolean arePlayerShipsDefeated(FieldModel player) {
        if (player.equals(GameModel.getPlayer1())) {
            for (Ship ship : Game.getShipsPlayer1()) {
                if (!ship.isDefeated())
                    return false;
            }
        } else if (player.equals(GameModel.getPlayer2())) {
            for (Ship ship : Game.getShipsPlayer2()) {
                if (!ship.isDefeated())
                    return false;
            }
        }
        return true;
    }

    public void paintAroundDefeatedShip(Ship ship, FieldModel player, GameStage gameStage) {
        ArrayList<Point> cells = (ArrayList<Point>) ship.getCells();
        if (cells.size() == 1) {
            Point cell = cells.get(0);
            for (int i = (cell.x) - 1; i <= (cell.x) + 1; i++) {
                for (int j = (cells.get(0).y) - 1; j <= (cells.get(0).y) + 1; j++) {
                    if ((i >= 0 && i < FieldModel.FIELD_SIZE && j >= 0 && j < FieldModel.FIELD_SIZE)
                            && (i != cell.x || j != cell.y)) {
                        Game.getGameModel().addExplodedCell(i, j, gameStage);
                    }
                }
            }
        } else {
            for (int i = cells.get(0).x-1; i <= cells.get(cells.size()-1).x+1; i++) {
                for (int j = cells.get(0).y-1; j <= cells.get(cells.size()-1).y+1; j++) {
                    if ((i >= 0 && j >= 0 && j < FieldModel.FIELD_SIZE && i < FieldModel.FIELD_SIZE) &&
                    player.getField()[i][j] != 2) {
                        Game.getGameModel().addExplodedCell(i, j, gameStage);
                    }
                }
            }
        }
    }

    public static void ChangePlayer() {
        if (Game.getGameStage().equals(GameStage.TURN_PLAYER1))
            Game.setGameStage(GameStage.TURN_PLAYER2);
        else if (Game.getGameStage().equals(GameStage.TURN_PLAYER2))
            Game.setGameStage(GameStage.TURN_PLAYER1);
    }
}