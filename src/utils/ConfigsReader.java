package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
// NOTE: THIS CLASS LOADS FIS AND READS FROM THE PROPERTIES FILE.

public class ConfigsReader {
    static Properties properties;

    /**
     * This method will locate and prepare (load) the Properties file
     * @param filePath specify file path/location here
     */
    public static void loadProperties(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method will return value of the specified key from the properties file
     * @param key accepted as a String
     * @return value of the given key (from the Properties file).
     */
    public static String getProperties(String key) {
        return properties.getProperty(key);
    }




}
