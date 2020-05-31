package com.wzw.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ButtonGroups extends JFrame {
    private static String[] ids = {"June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"};
    static JPanel makePanel(Class<? extends AbstractButton> kind, String[] ids) {
        ButtonGroup bg = new ButtonGroup();
        JPanel jp = new JPanel();
        String title = kind.getSimpleName();
        jp.setBorder(new TitledBorder(title));
        for (String id : ids) {
            AbstractButton ab = new JButton("failed");
            try {
                Constructor constructor = kind.getConstructor(String.class);
                ab = (AbstractButton) constructor.newInstance(id);
                ab.setToolTipText(title);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            bg.add(ab);
            jp.add(ab);
        }
        return jp;
    }
    public ButtonGroups() {
        setLayout(new FlowLayout());
        add(makePanel(JButton.class, ids));
        add(makePanel(JToggleButton.class, ids));
        add(makePanel(JCheckBox.class, ids));
        add(makePanel(JRadioButton.class, ids));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonGroups(), 500, 350);
    }
}
