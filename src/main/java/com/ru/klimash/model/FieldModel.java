package com.ru.klimash.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FieldModel {

    private int[][] field;

    public static final int FIELD_SIZE = 10;

    private List<Point> explodedCells;

    public FieldModel() {
        field = new int[FIELD_SIZE][FIELD_SIZE];
        explodedCells = new ArrayList<>();
    }

    public void isPressed(int x, int y, GameStage stage) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                if ((x-FIELD_SIZE >= 0 && x < FIELD_SIZE-2 && y >= 0 && y < FIELD_SIZE))
                    Controller.toggleSelectedCell(x, y, stage);
            }
            case TURN_PLAYER2 -> {
                if (x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE)
                    Controller.toggleSelectedCell(x, y, stage);
            }
        }
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    public List<Point> getExplodedCells() {
        return explodedCells;
    }


}