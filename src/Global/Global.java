package Global;

public class Global {
    public static String wuhbtool = "C:\\devkitPro\\tools\\bin\\wuhbtool.exe";
    public static String updateURL = "https://raw.githubusercontent.com/germanvanadium/wuhbgui/main/version.json";
    public static final int version = 100;

    public static void setWuhbtool(String wuhbtool) {
        Global.wuhbtool = wuhbtool;
    }

    public static void setUpdateURL(String updateURL) {
        Global.updateURL = updateURL;
    }

    public static String getWuhbtool() {
        return wuhbtool;
    }

    public static String getUpdateURL() {
        return updateURL;
    }

    public static final int getVersion() {
        return version;
    }
}
