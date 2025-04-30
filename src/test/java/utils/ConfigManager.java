package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigManager {
	  private static Properties properties;

	    static {
	        try {
	            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	            properties = new Properties();
	            properties.load(fis);
	         // Replace ${HOME} with actual user home directory
	            String userHome = System.getProperty("user.home");

	            for (String key : properties.stringPropertyNames()) {
	                String value = properties.getProperty(key);
	                if (value != null && value.contains("${HOME}")) {
	                    properties.setProperty(key, value.replace("${HOME}", userHome));
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String getProperty(String key) {
	        return properties.getProperty(key);
	    }
	    
//	    public static String getAppPath() {
//	        String appName = getProperty("app.name");  // e.g., SkyTube-Oss-2.995.apk
//	        return Paths.get(System.getProperty("user.dir"), "apps", appName).toString();
//	    }
//	    
	    
	    public static String getAppPath() {
	        String platform = getProperty("platform").toLowerCase();
	        String appName = getProperty("app.name"); // e.g., SkyTube-Oss-2.995.apk or Spotube-iOS.ipa

	        if ("android".equalsIgnoreCase(platform)) {
	            return Paths.get(System.getProperty("user.dir"), "apps", appName).toString();
	        } else if ("ios".equalsIgnoreCase(platform)) {
	            return Paths.get(System.getProperty("user.dir"), "apps", appName).toString();
	        } else {
	            throw new IllegalStateException("Platform not specified or unsupported.");
	        }
	    }
	    
}
