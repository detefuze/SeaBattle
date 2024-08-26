package com.ru.klimash.gui;

import com.ru.klimash.model.Controller;

import javax.swing.*;
import java.awt.*;

public class PreGameWindow extends JFrame {

    private JRadioButton player1RadioButton;
    private JRadioButton player2RadioButton;
    private JButton startButton;
    PreGameWindow() {
        setTitle("Sea Battle");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        // Создание компонентов
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        ButtonGroup buttonGroup = new ButtonGroup();

        player1RadioButton = new JRadioButton("Player 1 starts first");
        player2RadioButton = new JRadioButton("Player 2 starts first");
        startButton = new JButton("Start Game");

        buttonGroup.add(player1RadioButton);
        buttonGroup.add(player2RadioButton);

        panel.add(player1RadioButton);
        panel.add(player2RadioButton);
        panel.add(startButton);

        add(panel, BorderLayout.CENTER);
    }

    public void whoStarts() {
        if (player1RadioButton.isSelected()) {
            Controller.setIsPlayer1Turn(true);
        } else {
            Controller.setIsPlayer2Turn(true);
        }
    }
}
