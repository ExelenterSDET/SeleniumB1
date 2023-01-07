package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _05_ExplicitWait {
    public static void main(String[] args) {
        setUp("https://omayo.blogspot.com");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.findElement(By.cssSelector("button[class='dropbtn']")).click();  // Locating Dropdown button and click on it
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Face")));  // We wait for Facebook link to appear based on the given condition
        driver.findElement(By.partialLinkText("Face")).click();   // Click on the facebook link, should take us to Facebook homepage.

        tearDown();
    }
}
