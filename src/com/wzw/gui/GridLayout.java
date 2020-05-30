package com.wzw.gui;

import javax.swing.*;

public class GridLayout extends JFrame {
    public GridLayout() {
        setLayout(new java.awt.GridLayout(7, 3));
        for (int i = 0; i < 20; i++) {
            add(new JButton("Button " + i));
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new GridLayout(), 300, 300);
    }
}
