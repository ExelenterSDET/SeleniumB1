package Class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_WebElementsFacebook {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to Facebook page
        driver.get("https://fb.com");

        Thread.sleep(2000);
        // Let's practice using locators to locate web elements on FB page:
        driver.findElement(By.id("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("abc123");
        Thread.sleep(2000);
        driver.findElement(By.name("login")).click();

        Thread.sleep(2000);
//        driver.findElement(By.className("_97w4")).click();
//        driver.findElement(By.linkText("Forgot password?")).click();
//        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.findElement(By.partialLinkText("password?")).click();


        Thread.sleep(2000);
//        driver.close();
    }
}
