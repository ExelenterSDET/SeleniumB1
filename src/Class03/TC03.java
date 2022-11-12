package Class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC03 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); // windows user add .exe (chromedriver.exe)
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/");

        driver.findElement(By.linkText("REGISTER")).click();
        driver.findElement(By.name("firstName")).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");
        driver.findElement(By.name("phone")).sendKeys("310-123-4567");
        driver.findElement(By.id("userName")).sendKeys("test@gmail.com");
        driver.findElement(By.id("email")).sendKeys("johndoe");
        Thread.sleep(3000);
        driver.findElement(By.name("submit")).click();
    }
}
