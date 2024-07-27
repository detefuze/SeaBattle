package com.ru.klimash.gui;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private static final int FIELD_SIZE = 10;
    private int[][] field_player1;

    private int[][] field_player2;


    public Field() {
        field_player1 = new int[FIELD_SIZE][FIELD_SIZE];
        field_player2 = new int[FIELD_SIZE][FIELD_SIZE+12];

        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                field_player1[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание
            }
        }

        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 12; j < FIELD_SIZE+12; j++)
            {
                field_player2[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание
            }
        }
    }

    private void drawField_player1(Graphics g) {
        g.setColor(Color.GRAY);
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++)
            {
                g.drawRect(i * 40, j * 40, 40, 40);
            }
        }
    }

    private void drawField_player2(Graphics g) {
        g.setColor(Color.GRAY);
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 12; j < FIELD_SIZE+12; j++)
            {
                g.drawRect(i * 40, j * 40, 40, 40);
            }
        }
    }

    private void drawBorder(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 401, 400, 80);
    }

    void placeShip_player1(int x, int y) {
        field_player1[x][y] = 1;
        repaint();
    }

    void placeShip_player2(int x, int y) {
        field_player2[x][y+12] = 1;
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
        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 12; j < FIELD_SIZE+12; j++)
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
    }
}
