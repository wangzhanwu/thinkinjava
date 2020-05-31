package com.wzw.gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TabbedPanel extends JFrame {
    private String[] flavors = {"Sunday", "Saturday", "Wensday", "Friday"};
    private JTabbedPane tabs = new JTabbedPane();
    private JTextField txt = new JTextField(20);

    public TabbedPanel() {
        int i = 0;
        for (String s : flavors) {
            tabs.add(s, new JButton("Tabbed pane " + i++));
        }
        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                txt.setText("Tab selected: " + tabs.getSelectedIndex());
            }
        });
        add(BorderLayout.SOUTH, txt);
        add(tabs);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TabbedPanel(), 400, 250);
    }
}
