package com.ru.klimash.gui;

import com.ru.klimash.model.*;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private final JLabel messageLabel;
    
    public final static int CELL_SIZE = 30;
    private final static int DISTANCE_BETWEEN_FIELDS = 4;
    private final static int MISS_COORDINATES = Math.round(0.375f*CELL_SIZE);
    private final static int HEIGHT_OF_MISS = Math.round(0.25f*CELL_SIZE);
    private final static int WIDTH_OF_MISS = Math.round(0.25f*CELL_SIZE);
    private final static int CROSS_COORDINATE_1 = Math.round(0.25f*CELL_SIZE);
    private final static int CROSS_COORDINATE_2 = Math.round(0.75f*CELL_SIZE);
    public final static int FIELD2_DISTANCE_FROM_START_COORDINATES = 10 + DISTANCE_BETWEEN_FIELDS;
    private final static int SHIP_WIDTH = CELL_SIZE-1;
    private final static int SHIP_HEIGHT = CELL_SIZE-1;


    private final static Color GRAY_COLOR = new Color(128, 128, 128, 128);

    public Field() {
        messageLabel = new JLabel(); // окно состояния игры

        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel, BorderLayout.SOUTH);
    }

    private void drawSelectedCells(Graphics g, FieldModel player) {
        if (player.equals(GameModel.getPlayer1())) {
            for (Point cell : Controller.getSelectedCellsPlayer1()) {
                int x = (int) cell.getX() * CELL_SIZE;
                int y = (int) cell.getY() * CELL_SIZE;
                if (cell.x >= 0 && cell.x < FieldModel.FIELD_SIZE && cell.y >= 0 && cell.y < FieldModel.FIELD_SIZE) {
                    if (GameModel.getPlayer1().getField()[cell.x][cell.y] == 1 || GameModel.getPlayer1().getField()[cell.x][cell.y] == 2) {
                        drawDeadShipCells(g, x, y);
                    } else {
                        if (!GameModel.getPlayer1().getExplodedCells().contains(cell)) {
                            drawMiss(g, cell, GameModel.getPlayer1());
                        }
                    }
                }
            }
        } else if (player.equals(GameModel.getPlayer2())) {
            for (Point cell : Controller.getSelectedCellsPlayer2()) {
                int x = (int) cell.getX() * CELL_SIZE;
                int y = (int) cell.getY() * CELL_SIZE;

                if (cell.x >= FieldModel.FIELD_SIZE + 2 && cell.x < FieldModel.FIELD_SIZE + FIELD2_DISTANCE_FROM_START_COORDINATES && cell.y >= 0 && cell.y < FieldModel.FIELD_SIZE) {
                    if (GameModel.getPlayer2().getField()[cell.x - FIELD2_DISTANCE_FROM_START_COORDINATES][cell.y] == 1 || GameModel.getPlayer2().getField()[cell.x - FIELD2_DISTANCE_FROM_START_COORDINATES][cell.y] == 2) {
                        drawDeadShipCells(g, x, y);
                    } else {
                        if (!GameModel.getPlayer2().getExplodedCells().contains(new Point(cell.x - FIELD2_DISTANCE_FROM_START_COORDINATES, cell.y))) {
                            drawMiss(g, new Point(cell.x - FIELD2_DISTANCE_FROM_START_COORDINATES, cell.y), GameModel.getPlayer2());
                        }
                    }
                }
            }
        }
    }

    private void drawAreaAroundDefeatedShip(Graphics g, FieldModel player) {
        if (player.equals(GameModel.getPlayer1())) {
            if (!GameModel.getPlayer1().getExplodedCells().isEmpty()) {
                for (Point cell : GameModel.getPlayer1().getExplodedCells()) {
                    drawMiss(g, cell, GameModel.getPlayer1());
                }
            }
        } else if (player.equals(GameModel.getPlayer2())) {
            if (!GameModel.getPlayer2().getExplodedCells().isEmpty()) {
                for (Point cell : GameModel.getPlayer2().getExplodedCells()) {
                    drawMiss(g, cell, GameModel.getPlayer2());
                }
            }
        }
    }

    private void drawFields(Graphics g, FieldModel player) {
        g.setColor(Color.BLUE.brighter());
        if (player.equals(GameModel.getPlayer1())) {
            for (int i = 0; i < FieldModel.FIELD_SIZE; i++) {
                for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                    g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        } else if (player.equals(GameModel.getPlayer2())) {
            for (int i = FIELD2_DISTANCE_FROM_START_COORDINATES; i < FieldModel.FIELD_SIZE + FIELD2_DISTANCE_FROM_START_COORDINATES; i++) {
                for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                    g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
        // отрисовка окна
        messageLabel.setBounds(350, 400, 300, 60);
        if (Game.getGameStage().equals(GameStage.GAME_OVER)) {
            messageLabel.setText("Stage: " + Game.getGameStage() + "   " + Game.whoWins());
        }
        else messageLabel.setText("Stage: " + Game.getGameStage());
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect((CELL_SIZE * 10)+1, 0, DISTANCE_BETWEEN_FIELDS * CELL_SIZE, CELL_SIZE * 10);
    }

    void placeShip(int x, int y, FieldModel player) {
        if (player.equals(GameModel.getPlayer1())) {
            GameModel.getPlayer1().getField()[x][y] = 1;
            repaint();
        } else if (player.equals(GameModel.getPlayer2())) {
            GameModel.getPlayer2().getField()[x][y] = 1;
            repaint();
        }
    }

    private void drawShips(Graphics g, FieldModel player) {
        g.setColor(Color.ORANGE);
        if (player.equals(GameModel.getPlayer1())) {
            for (int i = 0; i < FieldModel.FIELD_SIZE; i++) {
                for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                    if (GameModel.getPlayer1().getField()[i][j] == 1)
                        g.fillOval(i * CELL_SIZE, j * CELL_SIZE, SHIP_WIDTH, SHIP_HEIGHT);
                }
            }
        } else if (player.equals(GameModel.getPlayer2())) {
            for (int i = FIELD2_DISTANCE_FROM_START_COORDINATES; i < FieldModel.FIELD_SIZE + FIELD2_DISTANCE_FROM_START_COORDINATES; i++) {
                for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                    if (GameModel.getPlayer2().getField()[i - FIELD2_DISTANCE_FROM_START_COORDINATES][j] == 1)
                        g.fillOval(i * CELL_SIZE, j * CELL_SIZE, SHIP_WIDTH, SHIP_HEIGHT);
                }
            }
        }
    }

    private void drawMiss(Graphics g, Point cell, FieldModel player) {
        if (player.equals(GameModel.getPlayer1())) {
            g.setColor(GRAY_COLOR);
            g.fillRect(cell.x * CELL_SIZE, cell.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            g.setColor(Color.BLACK);
            g.fillRect(cell.x * CELL_SIZE + MISS_COORDINATES, cell.y * CELL_SIZE + MISS_COORDINATES, WIDTH_OF_MISS, HEIGHT_OF_MISS);
        } else if (player.equals(GameModel.getPlayer2())) {
            g.setColor(GRAY_COLOR);
            g.fillRect((cell.x + FIELD2_DISTANCE_FROM_START_COORDINATES) * CELL_SIZE, cell.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            g.setColor(Color.BLACK);
            g.fillRect((cell.x + FIELD2_DISTANCE_FROM_START_COORDINATES) * CELL_SIZE + MISS_COORDINATES, cell.y * CELL_SIZE + MISS_COORDINATES, WIDTH_OF_MISS, HEIGHT_OF_MISS);
        }
    }

    private void drawDeadShipCells(Graphics g, int x, int y) {
        g.setColor(GRAY_COLOR); // Полупрозрачный серый
        g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        g.setColor(Color.RED);
        g.fillOval(x, y, CELL_SIZE, CELL_SIZE);
        g.setColor(Color.BLACK);
        g.drawLine(x + CROSS_COORDINATE_1, y + CROSS_COORDINATE_1, x + CROSS_COORDINATE_2, y + CROSS_COORDINATE_2);
        g.drawLine(x + CROSS_COORDINATE_1, y + CROSS_COORDINATE_2, x + CROSS_COORDINATE_2, y + CROSS_COORDINATE_1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFields(g, GameModel.getPlayer1());
        drawBorder(g);
        drawFields(g, GameModel.getPlayer2());
        drawShips(g, GameModel.getPlayer1());
        drawShips(g, GameModel.getPlayer2());
        drawSelectedCells(g, GameModel.getPlayer1());
        drawSelectedCells(g, GameModel.getPlayer2());
        drawAreaAroundDefeatedShip(g, GameModel.getPlayer1());
        drawAreaAroundDefeatedShip(g, GameModel.getPlayer2());
    }
}