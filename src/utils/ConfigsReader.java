package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
// NOTE: THIS CLASS READS FROM THE PROPERTIES FILE. Alternative name, to this class, could be "ReadFromProperties"

public class ConfigsReader {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
        FileInputStream fis = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);

        String browser = properties.getProperty("browser");
        System.out.println("browser = " + browser);
    }
}
