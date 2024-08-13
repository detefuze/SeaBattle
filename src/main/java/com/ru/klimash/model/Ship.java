package com.ru.klimash.model;

import java.awt.*;
import java.util.List;

public class Ship {

    private int length; //
    public List<Point> cells;
    private boolean isVertical;

    public Ship(int length, List<Point> cells, boolean isVertical) {
        this.length = length;
        this.cells = cells;
        this.isVertical = isVertical;
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
