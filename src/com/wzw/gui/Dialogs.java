package com.wzw.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialogs extends JFrame {
    private JButton bl = new JButton("Dialog Box");
    private MyDialog dlg = new MyDialog(null);
    public Dialogs() {
        bl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlg.setVisible(true);
            }
        });
        add(bl);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Dialogs(), 125, 75);
    }
}

class MyDialog extends JDialog {
    public MyDialog(JFrame parent) {
        super(parent, "My Dialog", true);
        setLayout(new FlowLayout());
        add(new JLabel("here is  my dialog"));
        JButton ok = new JButton("ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(ok);
        setSize(150, 125);
    }
}

