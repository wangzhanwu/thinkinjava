package com.wzw.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFields extends JFrame {
    private JButton
        b1 = new JButton("Get Text"),
            b2 = new JButton("Set Text");
    private JTextField
        t1 = new JTextField(30),
        t2 = new JTextField(30),
        t3 = new JTextField(30);
    private String s = "";
    private UpperCaseDocument ucd = new UpperCaseDocument();


    DocumentListener t1Listener = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            t2.setText(t1.getText());
            t3.setText("Text: " + t1.getText());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            t2.setText(t1.getText());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    };

    ActionListener t1aListener = new ActionListener() {
        private int count = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            t3.setText("t1 Action Event " + count++);
        }
    };
    ActionListener b1Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (t1.getSelectedText() == null) {
                s = t1.getText();
            } else {
                s = t1.getSelectedText();
            }
            t1.setEditable(true);
        }
    };
    ActionListener b2Listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ucd.setUpperCase(false);
            t1.setText("Inserted by Button 2: " + s);
            ucd.setUpperCase(true);
            t1.setEditable(false);
        }
    };

    private class UpperCaseDocument extends PlainDocument {
        private boolean upperCase = true;
        public void setUpperCase(boolean flag) {
            upperCase = flag;
        }

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (upperCase) str = str.toUpperCase();
            super.insertString(offs, str, a);
        }
    }

    public TextFields() {
        t1.setDocument(ucd);
        ucd.addDocumentListener(t1Listener);

        b1.addActionListener(b1Listener);
        b2.addActionListener(b2Listener);
        t1.addActionListener(t1aListener);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(t1);
        add(t2);
        add(t3);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TextFields(), 375, 200);
    }
}
