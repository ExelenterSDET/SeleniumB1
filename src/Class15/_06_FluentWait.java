package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _06_FluentWait {
    public static void main(String[] args) {
        setUp("https://omayo.blogspot.com");

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);  // Declare and initialize object of fluent wait
        fluentWait.withTimeout(Duration.ofSeconds(15));     // Wait for up to given time (15 seconds).
        fluentWait.pollingEvery(Duration.ofSeconds(1));     // Keep checking for the presence of the element every 1 second.
        fluentWait.ignoring(NoSuchElementException.class);     // Do NOT throw given exception until max time (15 sec) is reached.

        driver.findElement(By.cssSelector("button[class='dropbtn']")).click();
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Facebook")));
        driver.findElement(By.partialLinkText("Face")).click();

        // Note: Think of Fluent Wait similar to Explicit Wait, but with more controls.

        tearDown();
    }

}
