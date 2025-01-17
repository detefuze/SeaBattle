package com.ru.klimash.model;

import com.ru.klimash.gui.Field;
import com.ru.klimash.gui.Game;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public class Controller extends JPanel {

    private static Set<Point> selectedCellsPlayer1;

    private static Set<Point> selectedCellsPlayer2;

    public Controller(Field field) {
        selectedCellsPlayer1 = new HashSet<>();
        selectedCellsPlayer2 = new HashSet<>();

        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / Field.CELL_SIZE;
                int y = e.getY() / Field.CELL_SIZE;
                Game.getGameModel().cellPressed(Field.areCoordinatesCorrect(new Pair<>(x, y), Game.getGameStage()).getKey(),
                        Field.areCoordinatesCorrect(new Pair<>(x, y), Game.getGameStage()).getValue(), Game.getGameStage());
                field.repaint();
            }
        });
    }

    public static void toggleSelectedCell(int x, int y, GameStage stage) {
        Point cell = new Point(x, y);

        switch (stage) {
            case TURN_PLAYER1 -> selectedCellsPlayer2.add(cell);

            case TURN_PLAYER2 -> selectedCellsPlayer1.add(cell);
        }
    }

    public static Set<Point> getSelectedCellsPlayer1() {
        return selectedCellsPlayer1;
    }

    public static Set<Point> getSelectedCellsPlayer2() {
        return selectedCellsPlayer2;
    }
}
