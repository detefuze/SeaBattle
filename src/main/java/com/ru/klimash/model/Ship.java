package com.ru.klimash.model;

import java.awt.*;
import java.util.List;

public class Ship {

    private final List<Point> cells;

    private boolean isDefeated;

    public Ship(List<Point> cells) {
        this.cells = cells;
        isDefeated = false;
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

    public void setDefeated(boolean defeated) {
        isDefeated = defeated;
    }

    public boolean isDefeated() {
        return isDefeated;
    }
}
