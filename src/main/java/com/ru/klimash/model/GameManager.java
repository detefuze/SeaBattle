package com.ru.klimash.model;

import com.ru.klimash.gui.Game;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    private final GameModel gameModel = new GameModel(Game.getGameStage());

    public boolean isDeadPlayer1Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (gameModel.getPlayer1().getField()[p.x][p.y] == 1) {
                return false;
            }
        }
        Game.getDefeatedShipsPlayer1().add(ship);
        Game.getShipsPlayer1().remove(ship); // TODO убрать удаление корабля и добавить смену флага isDefeated
        return true;
    }

    public boolean isDeadPlayer2Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (gameModel.getPlayer2().getField()[p.x][p.y] == 1) {
                return false;
            }
        }
        Game.getDefeatedShipsPlayer2().add(ship);
        Game.getShipsPlayer2().remove(ship);
        return true;
    }

    public void paintAroundDefeatedShip(Ship ship, GameStage gameStage) {
        ArrayList<Point> cells = (ArrayList<Point>) ship.getCells();
        if (cells.size() == 1) {
            Point cell = cells.get(0);
            for (int i = (cell.x) - 1; i <= (cell.x) + 1; i++) {
                for (int j = (cells.get(0).y) - 1; j <= (cells.get(0).y) + 1; j++) {
                    if ((i >= 0 && i < FieldModel.FIELD_SIZE && j >= 0 && j < FieldModel.FIELD_SIZE)
                            && (i != cell.x || j != cell.y)) {
                        gameModel.addExplodedCell(i, j, gameStage);
                    }
                }
            }
        } else {
            for (Point cell : cells) {
                for (int i = cells.get(0).x-1; i <= cells.get(cells.size()-1).x+1; i++) {
                    for (int j = cells.get(0).y-1; j <= cells.get(cells.size()-1).y+1; j++) {
                        if ((i >= 0 && j >= 0 && j < FieldModel.FIELD_SIZE && i < FieldModel.FIELD_SIZE) &&
                                (i != cell.x || j != cell.y)) {
                            gameModel.addExplodedCell(i, j, gameStage);
                        }
                    }
                }
            }
        }
    }
}