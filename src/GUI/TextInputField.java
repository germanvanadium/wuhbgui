package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TextInputField {
    private JTextField jTextField;
    private String text;
    private int columns;
    private int size[];
    private int location[];
    private Color foreground;
    private Color background;
    private Border border;
    private Placeholder placeholder;

    public TextInputField(String text, int columns, int size[], int location[], Color foreground, Color background, Border border, Placeholder placeholder) {
        this.text = text;
        this.columns = columns;
        this.size = size;
        this.location = location;
        this.foreground = foreground;
        this.background = background;
        this.border = border;
        this.placeholder = placeholder;

        this.jTextField = createTextInputField();
    }

    private JTextField createTextInputField() {
        JTextField jTextFieldTmp;
        jTextFieldTmp = new JTextField(this.text);
        jTextFieldTmp.setColumns(this.columns);
        jTextFieldTmp.setSize(this.size[0], this.size[1]);
        jTextFieldTmp.setLocation(this.location[0], this.location[1]);
        jTextFieldTmp.setForeground(this.foreground);
        jTextFieldTmp.setBackground(this.background);
        jTextFieldTmp.setBorder(this.border);
        jTextFieldTmp.addFocusListener(this.placeholder.getPlaceholderHandler());
        return jTextFieldTmp;
    }

    public JTextField getTextInputField() { //If additional things need to be added, just grab this and do so
        return jTextField;
    }

    public String getText() {
        return text;
    }

    public int getColumns() {
        return columns;
    }

    public Color getForeground() {
        return foreground;
    }

    public Color getBackground() {
        return background;
    }

    public Border getBorder() {
        return border;
    }

    public int[] getLocation() {
        return location;
    }

    public int[] getSize() {
        return size;
    }

    public Placeholder getPlaceholder() {
        return placeholder;
    }
}
