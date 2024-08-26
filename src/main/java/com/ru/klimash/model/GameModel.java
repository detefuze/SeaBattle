package com.ru.klimash.model;

import com.ru.klimash.gui.Game;

import java.awt.*;

public class GameModel {

    private static FieldModel player1;

    private static FieldModel player2;

    public GameModel() {
        player1 = new FieldModel();
        player2 = new FieldModel();

        for (int i = 0; i < FieldModel.FIELD_SIZE; i++){
            for (int j = 0; j < FieldModel.FIELD_SIZE; j++)
            {
                player1.getField()[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание // 3 - промах или взрыв вокруг корабля
                player2.getField()[i][j] = 0;
            }
        }
    }
    public void cellPressed(int x, int y, GameStage stage) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                player2.isPressed(x, y, stage);
                try {
                    if (player2.getField()[x - 12][y] == 0)
                        GameManager.ChangePlayer();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ход 1 игрока!");
                }
            }

            case TURN_PLAYER2 -> {
                player1.isPressed(x, y, stage);
                try {
                    if (player1.getField()[x][y] == 0)
                        GameManager.ChangePlayer();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Ход 2 игрока!");
                }
            }
        }
    }

    public void addExplodedCell(int x, int y, GameStage stage) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                if (!GameModel.getPlayer2().getExplodedCellsPlayer2().contains(new Point(x, y)))
                    GameModel.getPlayer2().getExplodedCellsPlayer2().add(new Point(x, y));
            }
            case TURN_PLAYER2 -> {
                if (!GameModel.getPlayer1().getExplodedCellsPlayer1().contains(new Point(x, y)))
                    GameModel.getPlayer1().getExplodedCellsPlayer1().add(new Point(x, y));
            }
        }
    }



    public static FieldModel getPlayer1() {
        return player1;
    }

    public static FieldModel getPlayer2() {
        return player2;
    }
}