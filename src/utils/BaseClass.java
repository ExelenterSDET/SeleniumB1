package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// NOTE: THIS CLASS IS USED TO LAUNCH AND QUIT THE BROWSER
public class BaseClass {
    public static WebDriver driver;
    public static void setUp() {
        // 1st way: Hard-Coding (Not recommended).
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH); // window users add '.exe' at the end
       // WebDriver driver = new ChromeDriver();
       // driver.get(url);

        // 2nd way: Soft Coding (Recommended).
        ConfigsReader.loadProperties(Constants.CONFIGURATION_FILEPATH); // Replaced hard-coded filePath with Constants
        switch (ConfigsReader.getProperties("browser").toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                WebDriver driver = new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
                WebDriver driver = new FirefoxDriver();
            }
            default -> throw new RuntimeException("Browser is not supported");
        }

        driver.get(ConfigsReader.getProperties("url"));

    }

    void quit() {

    }

}
