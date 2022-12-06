package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
// NOTE: THIS CLASS WRITES TO THE PROPERTIES FILE. Alternative name, to this class, could be "WriteToProperties"
public class ConfigsWriter {
    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";
        FileInputStream fis = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fis);

        // Setup is ready - instead of Reading, this time I will Write to Properties file.
        properties.setProperty("Phone", "310-865-3498");
        properties.setProperty("email","tester@gmail.com");

        FileOutputStream fos = new FileOutputStream(filePath);
        properties.store(fos,"Adding phone number & email address to the properties file");

        /*
            Don't repeat .store() more than once, or it will store everything again as duplicate and
            duplicate key-values are not welcome in a properties file.
         */
        // Let's add an email address to the properties file
//        properties.setProperty("email","tester@gmail.com");
//        properties.store(fos, "Adding email address");

    }
}
