package Class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_cssDemo {
    private static String url = "https://exelentersdet.com/";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // Note: Change all xPath locators with CSS Selectors:
        // we are locating username and fill in with the 'Admin' text
        driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");

        // we are locating password and fill in with the 'password' text
        driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("Exelent2022Sdet!");
        Thread.sleep(2000);

        // locate and click login button
        driver.findElement(By.cssSelector("input.button")).click();
        Thread.sleep(2000);

        // In order to verify we are logged in, we locate and click on the 'Welcome Admin' - top right corner of the dashboard.
        driver.findElement(By.cssSelector("a[class$='Trigger']")).click();

        Thread.sleep(2000);
        // We locate and click on the Logout button.
//        driver.findElement(By.cssSelector("//div[@id='welcome-menu']//a")).click();
        //Another way, using Starts-with:
        driver.findElement(By.cssSelector("#welcome-menu a")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
