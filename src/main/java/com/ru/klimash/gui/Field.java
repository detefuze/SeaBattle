package com.ru.klimash.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class Field extends JPanel {

    private static final int FIELD_SIZE = 10;
    private int[][] field_player1;

    private int[][] field_player2;

    private Set<Point> selectedCells = new HashSet<>();


    public Field() {
        field_player1 = new int[FIELD_SIZE][FIELD_SIZE];
        field_player2 = new int[FIELD_SIZE+12][FIELD_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                field_player1[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание
            }
        }

        for (int i = 12; i < FIELD_SIZE+12; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                field_player2[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание
            }
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / 40;
                int y = e.getY() / 40;

                if (!(x < FIELD_SIZE+2 && x >= FIELD_SIZE && y >= 0 && y < FIELD_SIZE)) {
                    toggleSelectedCell(x, y);
                    repaint();
                }
            }
        });
    }

    private void toggleSelectedCell(int x, int y) {
        Point cell = new Point(x, y);
        selectedCells.add(cell);
    }

    private void drawSelectedCells(Graphics g) {
        g.setColor(Color.BLACK);
        for (Point cell : selectedCells) {
            int x = (int) cell.getX() * 40;
            int y = (int) cell.getY() * 40;
            if (cell.x >= 0 && cell.x < FIELD_SIZE && cell.y >= 0 && cell.y < FIELD_SIZE) {
                if (field_player1[cell.x][cell.y] == 1 || field_player1[cell.x][cell.y] == 2) {
                    field_player1[cell.x][cell.y] = 2;
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                } else {
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                }
                g.setColor(Color.BLACK);
                g.drawLine(x + 10, y + 10, x + 30, y + 30);
                g.drawLine(x + 10, y + 30, x + 30, y + 10);
            } else {
                if (field_player2[cell.x][cell.y] == 1 || field_player2[cell.x][cell.y] == 2) {
                    field_player2[cell.x][cell.y] = 2;
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                } else {
                    g.setColor(new Color(128, 128, 128, 128)); // Полупрозрачный серый
                    g.fillRect(x, y, 40, 40);
                }
                g.setColor(Color.BLACK);
                g.drawLine(x + 10, y + 10, x + 30, y + 30);
                g.drawLine(x + 10, y + 30, x + 30, y + 10);
            }
        }
    }

    private void drawField_player1(Graphics g) {
        g.setColor(Color.BLUE.brighter());
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                g.drawRect(i * 40, j * 40, 40, 40);
            }
        }
    }

    private void drawField_player2(Graphics g) {
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
        field_player1[x][y] = 1;
        repaint();
    }

    void placeShip_player2(int x, int y) {
        field_player2[x+12][y] = 1;
        repaint();
    }

    private void drawShips_player1(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                if (field_player1[i][j] == 1)
                    g.fillOval(i * 40, j * 40, 39, 39);
            }
        }
    }

    private void drawShips_player2(Graphics g) {
        g.setColor(Color.ORANGE);
        for (int i = 12; i < FIELD_SIZE+12; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                if (field_player2[i][j] == 1)
                    g.fillOval(i * 40, j * 40, 39, 39);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawField_player1(g);
        drawBorder(g);
        drawField_player2(g);
        drawShips_player1(g);
        drawShips_player2(g);
        drawSelectedCells(g);
    }
}
