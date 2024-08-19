package com.ru.klimash.model;

import com.ru.klimash.gui.Field;
import com.ru.klimash.gui.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public class Controller extends JPanel {

    private Field field;

    private static int[][] fieldPlayer1;

    private static int[][] fieldPlayer2;

    private Set<Point> selectedCells = new HashSet<>();

    public Controller(Field field) {
        this.field = field;
        this.selectedCells = new HashSet<>();

        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / 40;
                int y = e.getY() / 40;

                if (!(x < field.getFieldSize()+2 && x >= field.getFieldSize())) {
                    if (x >= 0 && x < field.getFieldSize() && y >= 0 && y < field.getFieldSize()) {
                        toggleSelectedCell(x, y);
                        field.repaint();
                    } else if (x >= field.getFieldSize()+2 && x < field.getFieldSize()+12 && y >= 0 && y < field.getFieldSize()) {
                        toggleSelectedCell(x, y);
                        field.repaint();
                    }
                }
            }
        });
    }

    public void toggleSelectedCell(int x, int y) {
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
}
