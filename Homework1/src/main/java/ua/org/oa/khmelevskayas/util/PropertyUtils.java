package ua.org.oa.khmelevskayas.util;

import java.io.*;
import java.util.Properties;

public class PropertyUtils {
    private static String propertiesFilePath = "App.properties";
    private static Properties properties = null;
    
    public static Properties getProperties() {
	if (properties == null) {
	    properties = new Properties();
	    try (InputStream in = ClassLoader.getSystemResourceAsStream(propertiesFilePath)){
		properties.load(in);
	    } catch (IOException e){
		e.printStackTrace();
	    }
	}
	return properties;
    }
    
}
