package GUI;

import org.w3c.dom.Text;

import java.io.File;

public class Meta {
    private ImageSelector imageSelector;
    private FileSelector fileSelector;
    private TextInputField textInputField;
    private MetaType metaType;

    enum MetaType {
        Image,
        File,
        Text
    }

    public Meta(ImageSelector imageSelector) {
        this.imageSelector = imageSelector;
        metaType = MetaType.Image;
    }

    public Meta(FileSelector fileSelector) {
        this.fileSelector = fileSelector;
        metaType = MetaType.File;
    }

    public Meta(TextInputField textInputField) {
        this.textInputField = textInputField;
        metaType = MetaType.Text;
    }

    public MetaType getMetaType() {
        return metaType;
    }

    public FileSelector getFileSelector() {
        return fileSelector;
    }

    public ImageSelector getImageSelector() {
        return imageSelector;
    }

    public TextInputField getTextInputField() {
        return textInputField;
    }
}
