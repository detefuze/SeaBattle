package com.ru.klimash.gui;

import com.ru.klimash.model.Controller;
import com.ru.klimash.model.GameManager;
import com.ru.klimash.model.Ship;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private Controller controller;

    private GameManager manager = new GameManager();

    private static final int FIELD_SIZE = 10;

    public Field() {
        controller = new Controller(this);
        controller.setFieldPlayer1(new int[FIELD_SIZE][FIELD_SIZE]);
        controller.setFieldPlayer2(new int[FIELD_SIZE+12][FIELD_SIZE]);

        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                Controller.getFieldPlayer1()[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание
            }
        }

        for (int i = 12; i < FIELD_SIZE+12; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                Controller.getFieldPlayer2()[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание
            }
        }
    }

    private void drawSelectedCells(Graphics g) {
        for (Point cell : controller.getSelectedCells()) {
            int x = (int) cell.getX() * 40;
            int y = (int) cell.getY() * 40;
            if (cell.x >= 0 && cell.x < FIELD_SIZE && cell.y >= 0 && cell.y < FIELD_SIZE) {
                if (Controller.getFieldPlayer1()[cell.x][cell.y] == 1 || Controller.getFieldPlayer1()[cell.x][cell.y] == 2) {
                    if (Controller.getFieldPlayer1()[cell.x][cell.y] == 1) {
                        Controller.getFieldPlayer1()[cell.x][cell.y] = 2;
                        manager.isDeadPlayer1Ship(Ship.getShipByCoordinates(Game.getShipsPlayer1(), new Point(x / 40, y / 40)));
                    } else {
                        Controller.getFieldPlayer1()[cell.x][cell.y] = 2;
                    }
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                    g.setColor(Color.BLACK);
                    g.drawLine(x + 10, y + 10, x + 30, y + 30);
                    g.drawLine(x + 10, y + 30, x + 30, y + 10);
                } else {
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 15, y + 15, 10, 10);
                }
            } else {
                if (Controller.getFieldPlayer2()[cell.x][cell.y] == 1 || Controller.getFieldPlayer2()[cell.x][cell.y] == 2) {
                    if (Controller.getFieldPlayer2()[cell.x][cell.y] == 1) {
                        Controller.getFieldPlayer2()[cell.x][cell.y] = 2;
                        manager.isDeadPlayer2Ship(Ship.getShipByCoordinates(Game.getShipsPlayer2(), new Point(x / 40, y / 40)));
                    } else {
                        Controller.getFieldPlayer2()[cell.x][cell.y] = 2;
                    }
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                    g.setColor(Color.BLACK);
                    g.drawLine(x + 10, y + 10, x + 30, y + 30);
                    g.drawLine(x + 10, y + 30, x + 30, y + 10);
                } else {
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                    g.setColor(Color.BLACK);
                    g.fillRect(x + 15, y + 15, 10, 10);
                }
            }
        }
    }

    private void drawFieldPlayer1(Graphics g) {
        g.setColor(Color.BLUE.brighter());
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                g.drawRect(i * 40, j * 40, 40, 40);
            }
        }
    }

    private void drawFieldPlayer2(Graphics g) {
        g.setColor(Color.BLUE.brighter());
        for (int i = 12; i < FIELD_SIZE+12; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                g.drawRect(i * 40, j * 40, 40, 40);
            }
        }
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(401, 0, 80, 400);
    }

    void placeShip_player1(int x, int y) {
        Controller.getFieldPlayer1()[x][y] = 1;
        repaint();
    }

    void placeShip_player2(int x, int y) {
        Controller.getFieldPlayer2()[x][y] = 1;
        repaint();
    }

    private void drawShipsPlayer1(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                if (Controller.getFieldPlayer1()[i][j] == 1)
                    g.fillOval(i * 40, j * 40, 39, 39);
            }
        }
    }

    private void drawShipsPlayer2(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int i = 12; i < FIELD_SIZE+12; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                if (Controller.getFieldPlayer2()[i][j] == 1)
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
        drawSelectedCells(g);
    }

    public int getFieldSize() {
        return FIELD_SIZE;
    }
}
