package com.ru.klimash.model;

import java.awt.*;

public class GameManager {

    public boolean isDeadPlayer1Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (Controller.getFieldPlayer1()[p.x][p.y] == 1) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    public boolean isDeadPlayer2Ship(Ship ship) {
        for (Point p : ship.getCells()) {
            if (Controller.getFieldPlayer2()[p.x][p.y] == 1) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }

    public void paintAroundDefeatedShip(Ship ship, boolean isVertical) {

    }
}
