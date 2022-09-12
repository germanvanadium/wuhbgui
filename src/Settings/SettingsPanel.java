package Settings;

import ExceptionHandler.GUIException;
import GUI.Placeholder;
import GUI.SimpleButton;
import GUI.TextInputField;
import Global.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SettingsPanel extends JPanel {
    public SettingsPanel() {
        this.setLayout((LayoutManager) null);

        TextInputField wuhbToolPath = new TextInputField(Global.getWuhbtool(), 1, new int[]{205, 20}, new int[]{10, 10}, Color.GRAY, Color.LIGHT_GRAY, null, new Placeholder(Global.getWuhbtool()));
        SimpleButton saveButton = new SimpleButton(null, "Save", new int[]{60, 20}, new int[]{220, 10}, true, Color.BLACK, Color.LIGHT_GRAY, SwingConstants.CENTER, SwingConstants.CENTER, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Global.setWuhbtool(wuhbToolPath.getTextInputField().getText());
                wuhbToolPath.getTextInputField().setText(Global.getWuhbtool());
                GUIException.show(null, "New WUHBTool Path saved!", JOptionPane.INFORMATION_MESSAGE);
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

        JLabel notice = new JLabel("<html>" +
                "Hello, this is a quick notice of the dev of this program! " +
                "I hope the experience is \"useable\",<br> ive rushed out this program " +
                "in the current state because I want to get a first version out " +
                "this is<br>a pretty early version and its way behind what version 1 " +
                "is gonna offer.Im probably gonna make a big update in the next update<br>" +
                "where I also clean up the code. This program has a Auto-Updater!<br>" +
                "</html>");
        notice.setLocation(10, 20);
        notice.setSize(290, 180);


        this.add(wuhbToolPath.getTextInputField());
        this.add(saveButton.getButton());
        this.add(notice);
    }
}
