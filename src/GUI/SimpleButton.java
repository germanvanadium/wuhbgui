package GUI;

import ExceptionHandler.GUIException;
import StackOverflow.ImageTools;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SimpleButton {
    //TODO: Clean this up and make all the button things into one
    private JLabel button;
    private String text;
    private int size[];
    private int location[];
    private boolean opaque;
    private Color foreground;
    private Color background;
    private int horizontalAlignment;
    private int verticalAlignment;
    private Cursor cursor;
    private MouseListener onClickListener;

    public SimpleButton(Component parentWindow, String text, int size[], int location[], boolean opaque, Color foreground, Color background, int horizontalAlignment, int verticalAlignment, Cursor cursor, MouseListener mouseListener) {
        this.text = text;
        this.size = size;
        this.location = location;
        this.opaque = opaque;
        this.foreground = foreground;
        this.background = background;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.cursor = cursor;
        this.onClickListener = mouseListener;

        this.button = createJLabel(parentWindow);
    }

    private JLabel createJLabel(Component parentWindow) {
        JLabel jLabel = new JLabel();
        jLabel.setText(this.text);
        jLabel.setSize(this.size[0], this.size[1]);
        jLabel.setLocation(this.location[0], this.location[1]);
        jLabel.setOpaque(this.opaque);
        jLabel.setForeground(this.foreground);
        jLabel.setBackground(this.background);
        jLabel.setHorizontalAlignment(this.horizontalAlignment);
        jLabel.setVerticalAlignment(this.verticalAlignment);
        jLabel.setCursor(this.cursor);
        jLabel.addMouseListener(this.onClickListener);
        return jLabel;
    }

    public JLabel getButton() {
        return button;
    }

    private void makeButtonText(JLabel jLabel, String text) {
        jLabel.setIcon(null);
        jLabel.setText(text);
    }
}
