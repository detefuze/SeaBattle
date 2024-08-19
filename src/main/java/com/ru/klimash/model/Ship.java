package com.ru.klimash.model;

import java.awt.*;
import java.util.List;

public class Ship {

    private int length;
    private List<Point> cells;
    private boolean isVertical;

    public Ship(int length, List<Point> cells, boolean isVertical) {
        this.length = length;
        this.cells = cells;
        this.isVertical = isVertical;
    }

    public static Ship getShipByCoordinates(List<Ship> ships, Point coordinates) {
        return ships.stream()
                .filter(ship -> ship.getCells().stream().anyMatch(p -> p.x == coordinates.x && p.y == coordinates.y))
                .findFirst()
                .orElse(null);
    }

    public List<Point> getCells() {
        return cells;
    }

    public int getLength() {
        return length;
    }

    public boolean isVertical() {
        return isVertical;
    }
}
