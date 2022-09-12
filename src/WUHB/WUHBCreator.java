package WUHB;

import ExceptionHandler.GUIException;
import GUI.Meta;
import Global.Global;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WUHBCreator {
    //TODO: Clean this up I guess

    public static void createWUHB(Meta shortname, Meta name, Meta author, Meta rpxFile, Meta drc, Meta tv, Meta icon) {
        String command = Global.wuhbtool + " "; //Create a command-String and set it to the WUHBTool.exe

        if(rpxFile.getFileSelector().getFile() != null) { //Check if the RPX File is given
            command += "\"" + rpxFile.getFileSelector().getFile().getPath() + "\" \"" + (rpxFile.getFileSelector().getFile().getPath().replaceAll(".rpx", "") + ".wuhb\"") + " "; //Add the RPX Params
        } else {
            GUIException.show("Please set a RPX-File");
            return;
        }

        if(shortname.getTextInputField().getPlaceholder().isNameChanged()) {
            command += " --short-name=\"" + shortname.getTextInputField().getText() + "\" "; //Add the shortname params
        } else {
            GUIException.show("Please set a Shortname");
            return;
        }

        if(!name.getTextInputField().getPlaceholder().isNameChanged()) {
            command += " --name=\"" + shortname.getTextInputField().getText() + "\" "; //Add the name params
        }

        if(!author.getTextInputField().getPlaceholder().isNameChanged()) {
            command += " --author=\"" + author.getTextInputField().getText() + "\" "; //Add the author params
        }

        if(drc.getImageSelector().getImageFile() != null) {
            command += " --drc-image=\"" + drc.getImageSelector().getImageFile().getPath() + "\" "; //Add the drc splash params
        }

        if(tv.getImageSelector().getImageFile() != null) {
            command += " --tv-image=\"" + tv.getImageSelector().getImageFile().getPath() + "\" "; //Add the tv splash params
        }

        if(icon.getImageSelector().getImageFile() != null) {
            command += " --icon=\"" + icon.getImageSelector().getImageFile().getPath() + "\" "; //Add the icon params
        }

        try {
            Process pr = Runtime.getRuntime().exec(command);
            GUIException.show(null, ".WUHB File packaged!", JOptionPane.PLAIN_MESSAGE);
        } catch(IOException e) {
            GUIException.show(null, "Error creating the WUHB File!");
            e.printStackTrace();
        }
    }
}
