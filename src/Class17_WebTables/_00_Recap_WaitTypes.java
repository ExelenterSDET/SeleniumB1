package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;

import static utils.BaseClass.*;

public class _00_Recap_WaitTypes extends CommonMethods {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));                      // IMPLICIT WAIT
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));                     // This fails, because it's for webpage to load, not AJAX type wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // EXPLICIT WAIT

        driver.findElement(By.linkText("Dynamic Controls")).click();
        wait(1);
        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println("Checkbox is selected: " + checkbox.isSelected());  // false
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());  // true
        wait(1);
        WebElement button = driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
        System.out.println("Button text: " + button.getText());   // button ==> 'Remove' text
        button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));   // this is for Explicit wait only, comment it out when using Implicit wait
        String message = driver.findElement(By.id("message")).getText();
        System.out.println("message: " + message);                // it's gone!
        System.out.println("Button text: " + button.getText());   // button ==> 'Add' text
        wait(1);
        button.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));     // this is for Explicit wait only, comment it out when using Implicit wait
        message = driver.findElement(By.id("message")).getText();
        System.out.println("message: " + message);                // It's back!

        tearDown();
    }
}
