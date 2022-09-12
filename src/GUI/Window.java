package GUI;

import javax.swing.*;

public class Window extends JFrame {
    public static final String title = "WUHBGui";
    public static final int width = 375;
    public static final int height = 310;

    public Window() {
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(new Panel());
        this.setVisible(true);
    }
}
