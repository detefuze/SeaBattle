package com.ru.klimash.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FieldModel {

    private int[][] field;

    public static final int FIELD_SIZE = 10;

    private final List<Point> explodedCellsPlayer1;
    private final List<Point> explodedCellsPlayer2;

    public FieldModel() {
        field = new int[FIELD_SIZE][FIELD_SIZE];
        explodedCellsPlayer1 = new ArrayList<>();
        explodedCellsPlayer2 = new ArrayList<>();
    }

    public void isPressed(int x, int y, GameStage stage) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                if ((x-FIELD_SIZE >= 0 && x-12 < FIELD_SIZE && y >= 0 && y < FIELD_SIZE)) {
                    Controller.toggleSelectedCell(x, y, stage);
                }
            }
            case TURN_PLAYER2 -> {
                if (x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE) {
                    Controller.toggleSelectedCell(x, y, stage);
                }
            }
        }
    }
    public int[][] getField() {
        return field;
    }

    public List<Point> getExplodedCellsPlayer1() {
        return explodedCellsPlayer1;
    }

    public List<Point> getExplodedCellsPlayer2() {
        return explodedCellsPlayer2;
    }
}