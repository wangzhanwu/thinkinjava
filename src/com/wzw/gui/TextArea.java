package com.wzw.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextArea extends JFrame {
    private JButton
        add = new JButton("ADD"),
            clear = new JButton("CLEAR");
    private JTextArea textArea = new JTextArea(20, 40);
    public TextArea() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Today is  good.\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");
                textArea.append("今天是个好天气。\n");

            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        setLayout(new FlowLayout());
        add(new JScrollPane(textArea));
        add(add);
        add(clear);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextArea(), 475, 425);
    }
}
