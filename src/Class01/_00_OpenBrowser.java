package Class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _00_OpenBrowser {
    public static void main(String[] args) {
        // 1. Establish a connection with the driver(s)
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // Windows users add .exe at the end ("drivers/chromedriver.exe")
        // 2. Open the browser using the Chromedriver's class constructor
        WebDriver driver = new ChromeDriver(); // Launch the browser for us

        // Navigate to Google website
        driver.get("https://google.com");

        // Retrieve the title of the current website and store it in a String
        String title = driver.getTitle();
        System.out.println("Title: " + title);
//        System.out.println(driver.getTitle());

        // Go to Google website and retrieve the URL and print it to the console:
        System.out.println("getCurrentUrl: " + driver.getCurrentUrl());

        driver.quit();
    }
}
