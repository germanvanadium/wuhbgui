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

public class FileSelector {
    //TODO: Clean this up and make all the button things into one
    private JLabel button;
    private JFileChooser fileChooser;
    private File file;
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

    public FileSelector(Component parentWindow, String text, int size[], int location[], boolean opaque, Color foreground, Color background, int horizontalAlignment, int verticalAlignment, Cursor cursor, FileFilter filter) {
        this.text = text;
        this.size = size;
        this.location = location;
        this.opaque = opaque;
        this.foreground = foreground;
        this.background = background;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.cursor = cursor;
        this.filter = filter;

        this.fileChooser = createFileChooser();
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
                file = showFileChooser(parentWindow);

                if(file == null) {
                    makeButtonText(jLabel, text);
                    return;
                }
                makeButtonText(jLabel,file.getPath());
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

    private JFileChooser createFileChooser() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(filter);
        return jFileChooser;
    }

    private File showFileChooser(Component parentWindow) {
        int result = this.fileChooser.showOpenDialog(parentWindow);
        if(this.fileChooser.getSelectedFile() != null && result != JFileChooser.CANCEL_OPTION) {
            return this.fileChooser.getSelectedFile();
        }
        return null;
    }

    public JLabel getButton() {
        return button;
    }

    private void makeButtonImage(JLabel jLabel, Image image, int downscaledWidth, int downscaledHeight) {
        try {
            ImageIcon icon = new ImageIcon((Image)ImageTools.resizeImage((BufferedImage) image, size[0], size[1])); //This is hilarious (im bad at coding btw)
            jLabel.setIcon(icon);
            jLabel.setText("");
        } catch(Exception e) {
            e.printStackTrace();
            makeButtonText(jLabel, this.text);
        }
    }

    private void makeButtonText(JLabel jLabel, String text) {
        jLabel.setIcon(null);
        jLabel.setText(text);
    }

    public File getFile() {
        return file;
    }
}
