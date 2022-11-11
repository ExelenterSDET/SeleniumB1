package Class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_OpenNewWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); // Windows users add .exe
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.yahoo.com");
//        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.navigate().refresh();

        Thread.sleep(3000);

//        driver.close(); // This will only close the current page which is Yahoo website
        driver.quit(); // This will close(quit) the entire page regardless of how many tabs are open.
    }
}
