package Class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_NavagationsCommands {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); // Windows users add .exe
        WebDriver driver = new ChromeDriver();  // This will launch a BLANK browser for us

        driver.get("https://www.google.com");   // right after we call this method, driver.get("URL")

        Thread.sleep(2000);

        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.close();

    }
}
