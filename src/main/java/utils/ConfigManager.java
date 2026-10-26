package utils;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class ConfigManager {

    private static final ISettingsFile SETTINGS_FILE = new JsonSettingsFile("config.json");

    private ConfigManager() {
    }

    public static String getValue(String jsonPath) {
        return SETTINGS_FILE.getValue(jsonPath).toString();
    }

    public static int getInt(String jsonPath) {
        return Integer.parseInt(getValue(jsonPath));
    }


}
