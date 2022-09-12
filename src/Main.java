import Downloader.Downloader;
import Downloader.Version;
import ExceptionHandler.GUIException;
import GUI.Window;
import Global.Global;
import Downloader.Updater;
import Settings.SettingsWindow;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Init");
        System.out.println("Checking for update...");

        if(Updater.perform()) {
            return;
        }

        new Window();

        while(true) {
            //Main loop
        }
    }
}