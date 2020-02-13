package net.nlovell.jaslin.tools;

import net.nlovell.jaslin.tools.data.Constants;

public class ConfigReader {

    private static ConfigReader cr;

    private ConfigReader() {

    }

    public static ConfigReader getConfigReader() {
        if (cr == null) {
            cr = new ConfigReader();
        }
        return cr;
    }

    public String getConfig(String key) {
        return null;
    }

    public String getConfigOrDefault(String key) {
        String conf = getConfig(key);
        if (conf == null) {
            switch (key.toLowerCase()) {
                case "port":
                    conf = String.valueOf(Constants.PORT);
            }
        }
        return conf;
    }

    ;
}
