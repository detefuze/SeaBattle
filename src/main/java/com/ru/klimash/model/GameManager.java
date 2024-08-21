package com.ru.klimash.model;

import com.ru.klimash.gui.Field;
import com.ru.klimash.gui.Game;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class GameManager {

    public boolean isDeadPlayer1Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (Controller.getFieldPlayer1()[p.x][p.y] == 1) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        Game.getDefeatedShipsPlayer1().add(ship);
        Game.getShipsPlayer1().remove(ship);
        return true;
    }

    public boolean isDeadPlayer2Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (Controller.getFieldPlayer2()[p.x][p.y] == 1) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        Game.getDefeatedShipsPlayer2().add(ship);
        Game.getShipsPlayer2().remove(ship);
        return true;
    }

    public void paintAroundDefeatedShipPlayer1(Ship ship, boolean isVertical) {
        ArrayList<Point> cells = (ArrayList<Point>) ship.getCells();
        if (ship.getLength() == 1) {
            Point cell = cells.get(0);
            for (int i = (cell.x)-1; i <= (cell.x)+1; i++) {
                for (int j = (cells.get(0).y)-1; j <= (cells.get(0).y)+1; j++) {
                    if ((i >= 0 && i < Field.getFieldSize() && j >= 0 && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                        if (!Controller.getExplodedCellsPlayer1().contains(new Point(i, j)))
                            Controller.getExplodedCellsPlayer1().add(new Point(i, j));
                    }
                }
            }
        }
        if (ship.isVertical()) {
            for (Point cell : cells) {
                if (cells.indexOf(cell) == 0) {
                    for (int i = cell.x-1; i <= cell.x+1; i++) {
                        for (int j = cell.y-1; j < cell.y+1; j++) {
                            if ((i >= 0 && j >= 0  && i <= Field.getFieldSize() && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer1().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer1().add(new Point(i, j));
                            }
                        }
                    }
                } else if (cells.indexOf(cell) == cells.size()-1) {
                    for (int i = cell.x-1; i <= cell.x+1; i++) {
                        for (int j = cell.y; j <= cell.y+1; j++) {
                            if ((i >= 0 && i < Field.getFieldSize() && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer1().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer1().add(new Point(i, j));
                            }
                        }
                    }
                } else {
                    if (cell.x-1 >= 0) {
                        if (!Controller.getExplodedCellsPlayer1().contains(new Point(cell.x - 1, cell.y)))
                            Controller.getExplodedCellsPlayer1().add(new Point(cell.x - 1, cell.y));
                    }
                    if (cell.x+1 < Field.getFieldSize()) {
                        if (!Controller.getExplodedCellsPlayer1().contains(new Point(cell.x + 1, cell.y)))
                            Controller.getExplodedCellsPlayer1().add(new Point(cell.x + 1, cell.y));
                    }
                }
            }
        } else {
            for (Point cell : cells) {
                if (cells.indexOf(cell) == 0) {
                    for (int i = cell.x-1; i < cell.x+1; i++) {
                        for (int j = cell.y-1; j <= cell.y+1; j++) {
                            if ((i >= 0 && j >= 0 && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer1().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer1().add(new Point(i, j));
                            }
                        }
                    }
                } else if (cells.indexOf(cell) == cells.size()-1) {
                    for (int i = cell.x; i <= cell.x+1; i++) {
                        for (int j = cell.y-1; j <= cell.y+1; j++) {
                            if ((i >= 0 && i < Field.getFieldSize() && j >= 0) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer1().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer1().add(new Point(i, j));
                            }
                        }
                    }
                } else {
                    if (cell.y-1 >= 0) {
                        if (!Controller.getExplodedCellsPlayer1().contains(new Point(cell.x, cell.y - 1)))
                            Controller.getExplodedCellsPlayer1().add(new Point(cell.x, cell.y - 1));
                    }
                    if (cell.y+1 < Field.getFieldSize()) {
                        if (!Controller.getExplodedCellsPlayer1().contains(new Point(cell.x, cell.y + 1)))
                            Controller.getExplodedCellsPlayer1().add(new Point(cell.x, cell.y + 1));
                    }
                }
            }
        }
    }
    public void paintAroundDefeatedShipPlayer2(Ship ship, boolean isVertical) {
        ArrayList<Point> cells = (ArrayList<Point>) ship.getCells();
        if (ship.getLength() == 1) {
            Point cell = cells.get(0);
            for (int i = (cell.x)-1; i <= (cell.x)+1; i++) {
                for (int j = (cells.get(0).y)-1; j <= (cells.get(0).y)+1; j++) {
                    if ((i >= Field.getFieldSize()+2 && i < Field.getFieldSize()+12 && j >= 0 && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                        if (!Controller.getExplodedCellsPlayer2().contains(new Point(i, j)))
                            Controller.getExplodedCellsPlayer2().add(new Point(i, j));
                    }
                }
            }
        }
        if (ship.isVertical()) {
            for (Point cell : cells) {
                if (cells.indexOf(cell) == 0) {
                    for (int i = cell.x-1; i <= cell.x+1; i++) {
                        for (int j = cell.y-1; j < cell.y+1; j++) {
                            if ((i >= Field.getFieldSize()+2 && j >= 0  && i <= Field.getFieldSize()+12 && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer2().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer2().add(new Point(i, j));
                            }
                        }
                    }
                } else if (cells.indexOf(cell) == cells.size()-1) {
                    for (int i = cell.x-1; i <= cell.x+1; i++) {
                        for (int j = cell.y; j <= cell.y+1; j++) {
                            if ((i >= Field.getFieldSize()+2 && i < Field.getFieldSize()+12 && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer2().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer2().add(new Point(i, j));
                            }
                        }
                    }
                } else {
                    if (cell.x-1 >= Field.getFieldSize()+2) {
                        if (!Controller.getExplodedCellsPlayer2().contains(new Point(cell.x - 1, cell.y)))
                            Controller.getExplodedCellsPlayer2().add(new Point(cell.x - 1, cell.y));
                    }
                    if (cell.x+1 < Field.getFieldSize()+12) {
                        if (!Controller.getExplodedCellsPlayer2().contains(new Point(cell.x + 1, cell.y)))
                            Controller.getExplodedCellsPlayer2().add(new Point(cell.x + 1, cell.y));
                    }
                }
            }
        } else {
            for (Point cell : cells) {
                if (cells.indexOf(cell) == 0) {
                    for (int i = cell.x-1; i < cell.x+1; i++) {
                        for (int j = cell.y-1; j <= cell.y+1; j++) {
                            if ((i >= Field.getFieldSize()+2 && j >= 0 && j < Field.getFieldSize()) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer2().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer2().add(new Point(i, j));
                            }
                        }
                    }
                } else if (cells.indexOf(cell) == cells.size()-1) {
                    for (int i = cell.x; i <= cell.x+1; i++) {
                        for (int j = cell.y-1; j <= cell.y+1; j++) {
                            if ((i >= Field.getFieldSize()+2 && i < Field.getFieldSize()+12 && j >= 0) && (i != cell.x || j != cell.y)) {
                                if (!Controller.getExplodedCellsPlayer2().contains(new Point(i, j)))
                                    Controller.getExplodedCellsPlayer2().add(new Point(i, j));
                            }
                        }
                    }
                } else {
                    if (cell.y-1 >= 0) {
                        if (!Controller.getExplodedCellsPlayer2().contains(new Point(cell.x, cell.y - 1)))
                            Controller.getExplodedCellsPlayer2().add(new Point(cell.x, cell.y - 1));
                    }
                    if (cell.y+1 < Field.getFieldSize()) {
                        if (!Controller.getExplodedCellsPlayer2().contains(new Point(cell.x, cell.y + 1)))
                            Controller.getExplodedCellsPlayer2().add(new Point(cell.x, cell.y + 1));
                    }
                }
            }
        }
    }
}
