package ExceptionHandler;

import GUI.Window;

import javax.swing.*;
import java.awt.*;

public class GUIException {

    public static void show(String message) {
        JOptionPane.showMessageDialog(null, message, Window.title, JOptionPane.ERROR_MESSAGE);
    }

    public static void show(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, Window.title, JOptionPane.ERROR_MESSAGE);
    }

    public static void show(Component parent, String message, int messageType) {
        JOptionPane.showMessageDialog(parent, message, Window.title, messageType);
    }
}
