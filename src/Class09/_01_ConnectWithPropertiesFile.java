package Class09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class _01_ConnectWithPropertiesFile {
    public static void main(String[] args) throws IOException {
        // Step 1. Locate the properties within the project.
//        String filePath = "/Users/John/IdeaProjects/SeleniumNov2022/configs/configuration.properties";  // <--- FUll Path

        // We are identifying File Source, address to the file that we are about to use.
        String filePath = System.getProperty("user.dir") + "/configs/configuration.properties";  // <-- I am telling System where my file is located.

        // To be able to transfer it (via tube)  I need put my file inside this FileInputStream
        FileInputStream fis = new FileInputStream(filePath);  // Filepath handler, establish connection stream with my filepath.

        Properties properties = new Properties(); // Properties class is part of the connection establishment, used to interact with .properties file.
        properties.load(fis);

        // Now It's ready to use. We can call any key value pair form the Properties file.
        String url = properties.getProperty("url");
        System.out.println("url = " + url);

        String browser = properties.getProperty("browser");
        System.out.println("browser = " + browser);

        // Getting keys OR values, or BOTH
        System.out.println("-- Values Only ---");
        Collection<Object> values = properties.values();
        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println("--- Keys Only ---");
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            System.out.println(key);
        }

        System.out.println("--- Key & Values together ---");
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry);
        }
    }
}
