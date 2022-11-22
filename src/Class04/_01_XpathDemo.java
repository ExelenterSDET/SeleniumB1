package Class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_XpathDemo {
    private static String url = "https://exelentersdet.com/";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // we are locating username and fill in with the 'Admin' text
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        // we are locating password and fill in with the 'password' text
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Exelent2022Sdet!");
        Thread.sleep(2000);
        // locate and click login button
        driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
        Thread.sleep(2000);
        // In order to verify we are logged in, we locate and click on the 'Welcome Admin' - top right corner of the dashboard.
        driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();

        Thread.sleep(2000);
        // We locate and click on the Logout button.
//        driver.findElement(By.xpath("//div[@id='welcome-menu']//a")).click();
        //Another way, using Starts-with:
        driver.findElement(By.xpath("//a[starts-with(text(),'Log')]")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
