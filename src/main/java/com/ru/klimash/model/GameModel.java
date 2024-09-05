package com.ru.klimash.model;

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
        if (isNewAction(x, y, stage)) {
            switch (stage) {
                case TURN_PLAYER1 -> player2.isPressed(x, y, stage);

                case TURN_PLAYER2 -> player1.isPressed(x, y, stage);
            }
        }
    }

    public boolean isNewAction(int x, int y, GameStage stage) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                if ((!GameModel.getPlayer2().getExplodedCells().contains(new Point(x, y)) &&
                        !Controller.getSelectedCellsPlayer2().contains(new Point(x, y))))
                    return true;
            }
            case TURN_PLAYER2 -> {
                if (!GameModel.getPlayer1().getExplodedCells().contains(new Point(x, y)) &&
                        (!Controller.getSelectedCellsPlayer1().contains(new Point(x, y))))
                    return true;
            }
        }
        return  false;
    }

    public void addExplodedCell(int x, int y, GameStage stage) {
        switch (stage) {
            case TURN_PLAYER1 -> {
                if (!GameModel.getPlayer2().getExplodedCells().contains(new Point(x, y)))
                    GameModel.getPlayer2().getExplodedCells().add(new Point(x, y));
            }
            case TURN_PLAYER2 -> {
                if (!GameModel.getPlayer1().getExplodedCells().contains(new Point(x, y)))
                    GameModel.getPlayer1().getExplodedCells().add(new Point(x, y));
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