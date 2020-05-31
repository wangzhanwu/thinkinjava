package com.wzw.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MessageBoxes extends JFrame {
    private JButton[] b = {
            new JButton("Alert"), new JButton("Yes/No"), new JButton("Color"),
            new JButton("Input"), new JButton("3 Vals")
    };
    private JTextField txt = new JTextField(15);
    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = ((JButton) e.getSource()).getText();
            if (Objects.equals(id, "Alert")) {
                JOptionPane.showMessageDialog(null, "There's a bug on you!", "Hey!",
                        JOptionPane.ERROR_MESSAGE);
            } else if(Objects.equals(id, "Yes/No")) {
                JOptionPane.showConfirmDialog(null, "or no", "choose  yes", JOptionPane.YES_NO_OPTION);
            } else if(Objects.equals(id, "Color")) {
                Object[] options = {"Red", "Yellow"};
                int sel = JOptionPane.showOptionDialog(null, "Choose a Color!", "Warning",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                if (sel != JOptionPane.CLOSED_OPTION) {
                    txt.setText("Color Selected: " + options[sel]);
                }
            } else if(Objects.equals(id, "Input")) {
                String val = JOptionPane.showInputDialog("How many fingers do you see?");
                txt.setText(val);
            } else if(Objects.equals(id, "3 Vals")) {
                Object[] selections = {"First", "Second", "Third"};
                Object val = JOptionPane.showInputDialog(null, "Choose one", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        selections, selections[0]);
                if (val != null) {
                    txt.setText(val.toString());
                }
            }
        }
    };
    public MessageBoxes() {
        setLayout(new FlowLayout());
        for (int i = 0; i < b.length; i++) {
            b[i].addActionListener(listener);
            add(b[i]);
        }
        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MessageBoxes(), 200, 200);
    }
}
