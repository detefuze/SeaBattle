package com.ru.klimash.model;

import java.awt.*;

public class GameModel {

    private final FieldModel player1;

    private final FieldModel player2;

    private static GameStage stage;

    public GameModel(GameStage stage) {
        player1 = new FieldModel();
        player2 = new FieldModel();
        GameModel.stage = stage;

        for (int i = 0; i < FieldModel.FIELD_SIZE; i++){
            for (int j = 0; j < FieldModel.FIELD_SIZE; j++)
            {
                player1.getField()[i][j] = 0; // 0 - пустая ячейка, 1 - занята кораблем
                // 2 - попадание // 3 - промах или взрыв вокруг корабля
                player2.getField()[i][j] = 0;
            }
        }
    }
    public void cellPressed(int x, int y) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                player2.isPressed(x, y, stage);
            }

            case TURN_PLAYER2 -> {
                player1.isPressed(x, y, stage);
            }

            case GAME_OVER -> {

            }
        }
    }

    public void addExplodedCell(int x, int y, GameStage stage) {
        GameModel gameModel = new GameModel(stage);
        switch (stage) {
            case TURN_PLAYER1 -> {
                if (!gameModel.getPlayer2().getExplodedCells().contains(new Point(x, y)))
                    gameModel.getPlayer2().getExplodedCells().add(new Point(x, y));
            }
            case TURN_PLAYER2 -> {
                if (!gameModel.getPlayer1().getExplodedCells().contains(new Point(x, y)))
                    gameModel.getPlayer1().getExplodedCells().add(new Point(x, y));
            }
        }
    }

    public static GameStage getStage() {
        return stage;
    }

    public static void setStage(GameStage stage) {
        GameModel.stage = stage;
    }

    public FieldModel getPlayer1() {
        return player1;
    }

    public FieldModel getPlayer2() {
        return player2;
    }
}