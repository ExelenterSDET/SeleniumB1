package Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_RadioDemo {
    private static String url = "https://formstone.it/components/checkbox/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // Find the checkbox 'Three' and verify if it is enabled or not.
        WebElement checkboxThree = driver.findElement(By.cssSelector("input#checkbox-3"));
        boolean checkboxThreeEnabled = checkboxThree.isEnabled();
        System.out.println("checkboxThreeEnabled = " + checkboxThreeEnabled);


        Thread.sleep(2000);
        driver.close();

    }
}
