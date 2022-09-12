package WUHB;

import GUI.Meta;
import StackOverflow.ImageTools;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class WUHBButton {
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
    private FileFilter filter;
    private Meta metas[];

    public WUHBButton(Component parentWindow, String text, int size[], int location[], boolean opaque, Color foreground, Color background, int horizontalAlignment, int verticalAlignment, Cursor cursor, Meta metas[]) {
        this.text = text;
        this.size = size;
        this.location = location;
        this.opaque = opaque;
        this.foreground = foreground;
        this.background = background;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.cursor = cursor;
        this.metas = metas;

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
        jLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WUHBCreator.createWUHB(metas[0], metas[1], metas[2], metas[3], metas[4], metas[5], metas[6]);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        return jLabel;
    }

    public JLabel getButton() {
        return button;
    }
}
