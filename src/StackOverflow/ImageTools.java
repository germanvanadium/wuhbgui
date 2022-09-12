package StackOverflow;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTools {

    //I copied this from StackOverflow, its for resizing Images! Works good :D
    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = null;
        try {
            resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
            graphics2D.dispose();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return resizedImage;
    }
}
