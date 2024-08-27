package com.ru.klimash.gui;

import com.ru.klimash.model.GameStage;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {

    private JRadioButton player1RadioButton;
    private JRadioButton player2RadioButton;
    private JButton startButton;
    public StartWindow() {
        setTitle("Sea Battle");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        ButtonGroup buttonGroup = new ButtonGroup();

        player1RadioButton = new JRadioButton("Player 1 starts");
        player2RadioButton = new JRadioButton("Player 2 starts");
        startButton = new JButton("Start Game");

        buttonGroup.add(player1RadioButton);
        buttonGroup.add(player2RadioButton);

        panel.add(player1RadioButton);
        panel.add(player2RadioButton);
        panel.add(startButton);

        add(panel, BorderLayout.CENTER);

        startButton.addActionListener(e -> {
            dispose(); // Закрываем окно
            if (player1RadioButton.isSelected())
                Game.setGameStage(GameStage.TURN_PLAYER1);
            else if (player2RadioButton.isSelected())
                Game.setGameStage(GameStage.TURN_PLAYER2);
            Game game = new Game(); // запуск игры
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StartWindow::new);
    }
}