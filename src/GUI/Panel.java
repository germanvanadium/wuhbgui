package GUI;

import Settings.SettingsWindow;
import WUHB.WUHBButton;
import WUHB.WUHBCreator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Panel extends JPanel {
    private static final String iconText = "<html>Select<br/>Icon</html>";
    private static final String drcText = "<html>Select<br/>DRC Image</html>";
    private static final String tvText = "<html>Select<br/>TV Image</html>";
    private static final String shortNameText = "Shortname";
    private static final String nameText = "Name (optional)";
    private static final String authorText = "Author (optional)";
    private static final String rpxText = "Select RPX File";
    private static final String wuhbText = "Create WUHB";
    private static final String settingsText = "Settings";
    private static final Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    //TODO: Simplify this whole ImageSelector, TextInputField and FileSelector Garbage. The way I did it is straight up hell
    //and overcomplicated OOP

    public Panel() {
        this.setLayout((LayoutManager) null);

        ImageSelector image = new ImageSelector(this, iconText, new int[]{70, 70}, new int[] {128, 128}, new int[] {10, 10}, true, Color.BLACK, Color.LIGHT_GRAY, new Color(180, 180, 180, 255), SwingConstants.CENTER, SwingConstants.CENTER, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        image.getButton().setBorder(border);

        Placeholder shortNamePlaceholder = new Placeholder(shortNameText);
        TextInputField shortName = new TextInputField(shortNameText, 1, new int[]{250, 20}, new int[]{100, 10}, Color.GRAY, Color.LIGHT_GRAY, null, shortNamePlaceholder);

        Placeholder namePlaceholder = new Placeholder(nameText);
        TextInputField name = new TextInputField(nameText, 1, new int[]{250, 20}, new int[]{100, 35}, Color.GRAY, Color.LIGHT_GRAY, null, namePlaceholder);

        Placeholder authorPlaceholder = new Placeholder(authorText);
        TextInputField author = new TextInputField(authorText, 1, new int[]{250, 20}, new int[]{100, 60}, Color.GRAY, Color.LIGHT_GRAY, null, authorPlaceholder);

        ImageSelector drcImage = new ImageSelector(this, drcText, new int[]{165, 80}, new int[] {1280, 720}, new int[] {10, 120}, true, Color.BLACK, Color.LIGHT_GRAY, new Color(180, 180, 180, 255), SwingConstants.CENTER, SwingConstants.CENTER, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageSelector tvImage = new ImageSelector(this, tvText, new int[]{165, 80}, new int[] {854, 480}, new int[] {185, 120}, true, Color.BLACK, Color.LIGHT_GRAY, new Color(180, 180, 180, 255), SwingConstants.CENTER, SwingConstants.CENTER, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        drcImage.getButton().setBorder(border);
        tvImage.getButton().setBorder(border);

        FileSelector rpxFile = new FileSelector(this, rpxText, new int[]{340, 20}, new int[]{10, 90}, true, Color.BLACK, Color.LIGHT_GRAY, SwingConstants.CENTER, SwingConstants.CENTER, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f.getName().endsWith(".rpx")) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return null;
            }
        });

        WUHBButton wuhbButton = new WUHBButton(this, wuhbText, new int[]{340, 35}, new int[] {10, 210}, true, Color.BLACK, Color.LIGHT_GRAY, SwingConstants.CENTER, SwingConstants.CENTER, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), new Meta[]{new Meta(shortName),new Meta(name),new Meta(author),new Meta(rpxFile),new Meta(drcImage),new Meta(tvImage),new Meta(image)});

        SimpleButton settingsButton = new SimpleButton(null, settingsText, new int[]{50, 30}, new int[]{300, 245}, false, Color.BLUE, null, SwingConstants.CENTER, SwingConstants.CENTER, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SettingsWindow();
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

        this.add(image.getButton());
        this.add(shortName.getTextInputField());
        this.add(name.getTextInputField());
        this.add(author.getTextInputField());
        this.add(drcImage.getButton());
        this.add(tvImage.getButton());
        this.add(rpxFile.getButton());
        this.add(wuhbButton.getButton());
        this.add(settingsButton.getButton());
    }
}
