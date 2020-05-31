package com.wzw.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class Buttons extends JFrame {
    private JButton jb = new JButton("JButton");
    private BasicArrowButton up = new BasicArrowButton(BasicArrowButton.NORTH);
    private BasicArrowButton down = new BasicArrowButton(BasicArrowButton.SOUTH);
    private BasicArrowButton right = new BasicArrowButton(BasicArrowButton.EAST);
    private BasicArrowButton left = new BasicArrowButton(BasicArrowButton.WEST);

    public Buttons() {
        setLayout(new FlowLayout());
        add(jb);
        add(new JToggleButton("JToggleButton"));
        add(new JCheckBox("CheckBox"));
        add(new JRadioButton("JRadioButton"));

        JPanel jp = new JPanel();
        jp.setBorder(new TitledBorder("Directions"));
        jp.add(up);
        jp.add(down);
        jp.add(left);
        jp.add(right);
        add(jp);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Buttons(), 350, 200);
    }
}
