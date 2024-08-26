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

    private static Set<Point> selectedCellsPlayer1;

    private static Set<Point> selectedCellsPlayer2;

    public Controller(Field field) {
        selectedCellsPlayer1 = new HashSet<>();
        selectedCellsPlayer2 = new HashSet<>();

        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / 40;
                int y = e.getY() / 40;
                Game.getGameModel().cellPressed(x, y, Game.getGameStage());
                field.repaint();
            }
        });

    }

    public static void toggleSelectedCell(int x, int y, GameStage stage) {
        Point cell = new Point(x, y);

        switch (stage) {
            case TURN_PLAYER1 -> {
                selectedCellsPlayer2.add(cell);
            }
            case TURN_PLAYER2 -> {
                selectedCellsPlayer1.add(cell);
            }
            case GAME_OVER -> {
            }
        }
    }

    public static Set<Point> getSelectedCellsPlayer1() {
        return selectedCellsPlayer1;
    }

    public static Set<Point> getSelectedCellsPlayer2() {
        return selectedCellsPlayer2;
    }
}
