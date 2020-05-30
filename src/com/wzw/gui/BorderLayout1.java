package com.wzw.gui;

import javax.swing.*;
import java.awt.*;

public class BorderLayout1 extends JFrame {
    public BorderLayout1() {
        add(BorderLayout.NORTH, new JButton("NORTH"));
        add(BorderLayout.SOUTH, new JButton("SOUTH"));
        add(BorderLayout.EAST, new JButton("EAST"));
        add(BorderLayout.WEST, new JButton("WEST"));
        add(BorderLayout.CENTER, new JButton("CENTER"));
    }

    public static void main(String[] args) {
        SwingConsole.run(new BorderLayout1(), 300, 200);
    }
}
