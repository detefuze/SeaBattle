package com.ru.klimash.model;

import com.ru.klimash.gui.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller extends JPanel {

    private static int[][] fieldPlayer1;

    private static int[][] fieldPlayer2;

    private final Set<Point> selectedCells;

    private static List<Point> explodedCellsPlayer1;
    private static List<Point> explodedCellsPlayer2;

    public Controller(Field field) {
        this.selectedCells = new HashSet<>();
        explodedCellsPlayer1 = new ArrayList<>();
        explodedCellsPlayer2 = new ArrayList<>();

        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / 40;
                int y = e.getY() / 40;

                if (!(x < Field.getFieldSize()+2 && x >= Field.getFieldSize())) {
                    if (x >= 0 && x < Field.getFieldSize() && y >= 0 && y < Field.getFieldSize()) {
                        toggleSelectedCell(x, y);
                        field.repaint();
                    } else if (x >= Field.getFieldSize()+2 && x < Field.getFieldSize()+12 && y >= 0 && y < Field.getFieldSize()) {
                        toggleSelectedCell(x, y);
                        field.repaint();
                    }
                }
            }
        });
    }

    private void toggleSelectedCell(int x, int y) {
        Point cell = new Point(x, y);
        selectedCells.add(cell);
    }

    public static int[][] getFieldPlayer1() {
        return fieldPlayer1;
    }

    public void setFieldPlayer1(int[][] fieldPlayer1) {
        Controller.fieldPlayer1 = fieldPlayer1;
    }

    public static int[][] getFieldPlayer2() {
        return fieldPlayer2;
    }

    public void setFieldPlayer2(int[][] fieldPlayer2) {
        Controller.fieldPlayer2 = fieldPlayer2;
    }

    public Set<Point> getSelectedCells() {
        return selectedCells;
    }

    public static List<Point> getExplodedCellsPlayer1() {
        return explodedCellsPlayer1;
    }

    public static List<Point> getExplodedCellsPlayer2() {
        return explodedCellsPlayer2;
    }
}
