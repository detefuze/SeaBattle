package com.ru.klimash.gui;

import com.ru.klimash.model.*;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private final Controller controller;

    private final GameManager manager = new GameManager();

    public Field() {
        controller = new Controller(this);
    }

    private void drawSelectedCellsPlayer1(Graphics g) {
        for (Point cell : Controller.getSelectedCellsPlayer1()) {
            int x = (int) cell.getX() * 40;
            int y = (int) cell.getY() * 40;
            if (cell.x >= 0 && cell.x < FieldModel.FIELD_SIZE && cell.y >= 0 && cell.y < FieldModel.FIELD_SIZE) {
                if (GameModel.getPlayer1().getField()[cell.x][cell.y] == 1 || GameModel.getPlayer1().getField()[cell.x][cell.y] == 2) {
                    Ship damagedShip = Ship.getShipByCoordinates(Game.getShipsPlayer1(), new Point(x / 40, y / 40)); // поврежденный корабль
                    if (GameModel.getPlayer1().getField()[cell.x][cell.y] == 1) {
                        GameModel.getPlayer1().getField()[cell.x][cell.y] = 2;
                        if (manager.isDeadPlayer1Ship(damagedShip)) { // если корабль подбит
                            manager.paintAroundDefeatedShip(damagedShip, GameModel.getPlayer1(), Game.getGameStage());
                        }
                    } else {
                        GameModel.getPlayer1().getField()[cell.x][cell.y] = 2;
                    }
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                    g.setColor(Color.BLACK);
                    g.drawLine(x + 10, y + 10, x + 30, y + 30);
                    g.drawLine(x + 10, y + 30, x + 30, y + 10);
                } else {
                    if (!GameModel.getPlayer1().getExplodedCellsPlayer1().contains(cell)) {
                        g.setColor(new Color(128, 128, 128, 128));
                        g.fillRect(cell.x * 40, cell.y * 40, 40, 40);
                        g.setColor(Color.BLACK);
                        g.fillRect(cell.x * 40 + 15, cell.y * 40 + 15, 10, 10);
                    }
                }
            }
        }
    }

    private void drawSelectedCellsPlayer2(Graphics g) {
        for (Point cell : Controller.getSelectedCellsPlayer2()) {
            int x = (int) cell.getX() * 40;
            int y = (int) cell.getY() * 40;

            if (cell.x >= FieldModel.FIELD_SIZE + 2 && cell.x < FieldModel.FIELD_SIZE + 12 && cell.y >= 0 && cell.y < FieldModel.FIELD_SIZE) {
                if (GameModel.getPlayer2().getField()[cell.x - 12][cell.y] == 1 || GameModel.getPlayer2().getField()[cell.x - 12][cell.y] == 2) {
                    Ship damagedShip = Ship.getShipByCoordinates(Game.getShipsPlayer2(), new Point((x / 40) - 12, y / 40)); // поврежденный корабль
                    if (GameModel.getPlayer2().getField()[cell.x - 12][cell.y] == 1) {
                        GameModel.getPlayer2().getField()[cell.x - 12][cell.y] = 2;
                        if (manager.isDeadPlayer2Ship(damagedShip)) { // если корабль подбит
                            manager.paintAroundDefeatedShip(damagedShip, GameModel.getPlayer2(), Game.getGameStage());
                        }
                    } else {
                        GameModel.getPlayer2().getField()[cell.x - 12][cell.y] = 2;
                    }
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                    g.setColor(Color.BLACK);
                    g.drawLine(x + 10, y + 10, x + 30, y + 30);
                    g.drawLine(x + 10, y + 30, x + 30, y + 10);
                } else {
                    if (!GameModel.getPlayer2().getExplodedCellsPlayer2().contains(new Point(cell.x-12, cell.y))) {
                        g.setColor(new Color(128, 128, 128, 128));
                        g.fillRect(cell.x * 40, cell.y * 40, 40, 40);
                        g.setColor(Color.BLACK);
                        g.fillRect(cell.x * 40 + 15, cell.y * 40 + 15, 10, 10);
                    }
                }
            }
        }
    }

    private void drawAreaAroundDefeatedShipPlayer1(Graphics g) {
        if (!GameModel.getPlayer1().getExplodedCellsPlayer1().isEmpty()) {
            for (Point cell : GameModel.getPlayer1().getExplodedCellsPlayer1()) {
                g.setColor(new Color(128, 128, 128, 128));
                g.fillRect(cell.x * 40, cell.y * 40, 40, 40);
                g.setColor(Color.BLACK);
                g.fillRect(cell.x * 40 + 15, cell.y * 40 + 15, 10, 10);
            }
        }
    }

    private void drawAreaAroundDefeatedShipPlayer2(Graphics g) {
        if (!GameModel.getPlayer2().getExplodedCellsPlayer2().isEmpty()) {
            for (Point cell : GameModel.getPlayer2().getExplodedCellsPlayer2()) {
                g.setColor(new Color(128, 128, 128, 128));
                g.fillRect((cell.x + 12) * 40, cell.y * 40, 40, 40);
                g.setColor(Color.BLACK);
                g.fillRect((cell.x + 12) * 40 + 15, cell.y * 40 + 15, 10, 10);
            }
        }
    }

    private void drawFieldPlayer1(Graphics g) {
        g.setColor(Color.BLUE.brighter());
        for (int i = 0; i < FieldModel.FIELD_SIZE; i++) {
            for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                g.drawRect(i * 40, j * 40, 40, 40);
            }
        }
    }

    private void drawFieldPlayer2(Graphics g) {
        g.setColor(Color.BLUE.brighter());
        for (int i = 12; i < FieldModel.FIELD_SIZE + 12; i++) {
            for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                g.drawRect(i * 40, j * 40, 40, 40);
            }
        }
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(401, 0, 80, 400);
    }

    void placeShip_player1(int x, int y) {
        GameModel.getPlayer1().getField()[x][y] = 1;
        repaint();
    }

    void placeShip_player2(int x, int y) {
        GameModel.getPlayer2().getField()[x][y] = 1;
        repaint();
    }

    private void drawShipsPlayer1(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int i = 0; i < FieldModel.FIELD_SIZE; i++) {
            for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                if (GameModel.getPlayer1().getField()[i][j] == 1)
                    g.fillOval(i * 40, j * 40, 39, 39);
            }
        }
    }

    private void drawShipsPlayer2(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int i = 12; i < FieldModel.FIELD_SIZE + 12; i++) {
            for (int j = 0; j < FieldModel.FIELD_SIZE; j++) {
                if (GameModel.getPlayer2().getField()[i - 12][j] == 1)
                    g.fillOval(i * 40, j * 40, 39, 39);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFieldPlayer1(g);
        drawBorder(g);
        drawFieldPlayer2(g);
        drawShipsPlayer1(g);
        drawShipsPlayer2(g);
        drawSelectedCellsPlayer1(g);
        drawSelectedCellsPlayer2(g);
        drawAreaAroundDefeatedShipPlayer1(g);
        drawAreaAroundDefeatedShipPlayer2(g);
    }
}