package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

public class _03_ExplicitWait {
    public static void main(String[] args) {
        setUp("http://uitestpractice.com/Students/Contact");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));                         // This is a GLOBAL wait. Applies to entire elements in the class.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));      // Explicit wait is not Global, waits for a specific condition of the element.

        try {
            driver.findElement(By.linkText("This is a Ajax link")).click();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ContactUs"))); // This is Explicit wait, waiting based on the condition of Visibility of Element
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ContactUs"))); // This is Explicit wait, waiting based on the condition of Visibility of Element
            System.out.println(driver.findElement(By.className("ContactUs")).getText());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Element is not found. Wait longer for the element to become visible on the UI ");
        }

        WebElement element = driver.findElement(By.className("ContactUs"));  // This is web element
        By by = By.className("ContactUs");                                       // This is locator.



        tearDown();

    }
}
