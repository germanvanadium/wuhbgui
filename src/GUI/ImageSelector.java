package GUI;

import ExceptionHandler.GUIException;
import StackOverflow.ImageTools;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSelector {
    private JLabel button;
    private JFileChooser fileChooser;
    private File imageFile;
    private Image image;
    private String text;
    private int size[];
    private int location[];
    private boolean opaque;
    private Color foreground;
    private Color background;
    private Color backgroundHovered;
    private int horizontalAlignment;
    private int verticalAlignment;
    private Cursor cursor;
    private MouseListener onClickListener;
    private int prefferedSize[];

    public ImageSelector(Component parentWindow, String text, int size[], int prefferedSize[], int location[], boolean opaque, Color foreground, Color background, Color backgroundHovered, int horizontalAlignment, int verticalAlignment, Cursor cursor) {
        this.text = text;
        this.size = size;
        this.location = location;
        this.opaque = opaque;
        this.foreground = foreground;
        this.background = background;
        this.backgroundHovered = backgroundHovered;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.cursor = cursor;
        this.prefferedSize = prefferedSize;

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
                imageFile = showFileChooser(parentWindow);

                if(imageFile == null) {
                    makeButtonText(jLabel, text);
                    return;
                }

                try {
                    makeButtonImage(jLabel, ImageIO.read(imageFile), size[0], size[1]);

                    if(ImageIO.read(imageFile).getWidth() != prefferedSize[0] || ImageIO.read(imageFile).getHeight() != prefferedSize[1]) {
                        GUIException.show(parentWindow, "WARNING: The selected image is not the prefered size\nof " + prefferedSize[0] + "x" + prefferedSize[1] + ". This should not be a\nproblem though, as WUHBTool will downscale it!");
                    }
                } catch(IOException ioE) {
                    makeButtonText(jLabel, text);
                    new Exception("Selected file is not a image error").printStackTrace();
                    return;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

                System.out.println(((JLabel)e.getComponent()).getBackground().getRed() + " " + ((JLabel)e.getComponent()).getBackground().getGreen() + " " + ((JLabel)e.getComponent()).getBackground().getBlue() + " " + ((JLabel)e.getComponent()).getBackground().getAlpha());
                ((JLabel)e.getComponent()).setBackground(backgroundHovered);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JLabel)e.getComponent()).setBackground(background);
            }
        });
        return jLabel;
    }

    private JFileChooser createFileChooser() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.getName().endsWith(".png") || f.getName().endsWith(".jpg") || f.isDirectory()) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return null;
            }
        });
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

    private void makeButtonImage(JLabel jLabel, Image image) {
        try {
            jLabel.setIcon(new ImageIcon(image));
            jLabel.setText("");
        } catch(Exception e) {
            e.printStackTrace();
        }
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

    public File getImageFile() {
        return imageFile;
    }
}
