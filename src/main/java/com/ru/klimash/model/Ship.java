package com.ru.klimash.model;

import java.awt.*;
import java.util.List;

public class Ship {

    private final List<Point> cells;

    // TODO isDefeated

    public Ship(List<Point> cells) {
        this.cells = cells;
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

}
