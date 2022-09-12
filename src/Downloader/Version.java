package Downloader;

import Global.Global;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Version {
    private static String rawUpdateData = "";

    public static boolean setRawUpdateData() {
        URL url = null;

        try {
            url = new URL(Global.updateURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null; ) { rawUpdateData += line; }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean needsUpdate(int ver) {
        if(rawUpdateData.length() <= 0) {
            if(!setRawUpdateData()) {
                return false;
            }
        }
        int version;
        String parsedVersion;

        try {
            JSONObject obj = new JSONObject(rawUpdateData);
            parsedVersion = obj.getString("version");
            version = Integer.parseInt(parsedVersion);
        } catch(Exception e) {
            return false;
        }

        return (ver < version);
    }

    public static String getUpdateFileURL() {
        if(rawUpdateData == null) {
            if(!setRawUpdateData()) {
                return null;
            }
        }
        String link;

        try {
            JSONObject obj = new JSONObject(rawUpdateData);
            link = obj.getString("download");
        } catch(Exception e) {
            return null;
        }

        return link;
    }
}
