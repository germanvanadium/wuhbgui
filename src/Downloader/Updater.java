package Downloader;

import ExceptionHandler.GUIException;
import Global.Global;

import java.io.File;
import java.io.IOException;

public class Updater {
    public static boolean perform() {
        boolean needsUpdate = Version.needsUpdate(Global.version);
        System.out.println("Needs update: " + needsUpdate);

        if(needsUpdate) {
            String updateURL = Version.getUpdateFileURL();
            System.out.println("Parsing download... " + updateURL);
            try {
                Downloader.downloadFile(updateURL, new File(".").getCanonicalPath() + ".jar");
            } catch(IOException e) {
                e.printStackTrace();
                return false;
            }

            GUIException.show("Update done! Please restart this program!");
            return true;
        }
        return false;
    }
}
