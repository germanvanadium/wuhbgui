package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Placeholder {
    private String text;
    private boolean nameChanged;
    private FocusListener focusListener;

    public Placeholder(String placeholderText) {
        text = placeholderText;
        nameChanged = false;

        focusListener = new FocusListener() { //"Simple" placeholder code *insert dead skull emoji*
            @Override
            public void focusGained(FocusEvent e) {
                if(((JTextField)e.getSource()).getText().equalsIgnoreCase(text) && !nameChanged) {
                    ((JTextField)e.getSource()).setText("");
                    ((JTextField)e.getSource()).setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(((JTextField)e.getSource()).getText().equalsIgnoreCase("")) {
                    nameChanged = false;
                    ((JTextField)e.getSource()).setText(text);
                    ((JTextField)e.getSource()).setForeground(Color.GRAY);
                    return;
                }
                nameChanged = true;
            }
        };
    }

    public FocusListener getPlaceholderHandler() {
        return focusListener;
    }

    public boolean isNameChanged() {
        return nameChanged;
    }
}
