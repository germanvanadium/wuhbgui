package Settings;

import GUI.Panel;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final String title = "Settings";
    public static final int width = 300;
    public static final int height = 190;

    public SettingsWindow() {
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(new SettingsPanel());
        this.setVisible(true);
    }
}
