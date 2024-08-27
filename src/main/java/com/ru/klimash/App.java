package com.ru.klimash;

import com.ru.klimash.gui.StartWindow;

import javax.swing.*;


public class App 
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(StartWindow::new);
    }
}
