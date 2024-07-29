package com.ru.klimash.model;

import java.awt.*;
import java.util.ArrayList;

public class Ship {

    private int length;
    public ArrayList<Point> cells;
    private boolean isVertical;

    public Ship(int length, ArrayList<Point> cells, boolean isVertical) {
        this.length = length;
        this.cells = cells;
        this.isVertical = isVertical;
    }

    public ArrayList<Point> getCells() {
        return cells;
    }

    public int getLength() {
        return length;
    }

    public boolean isVertical() {
        return isVertical;
    }
}
