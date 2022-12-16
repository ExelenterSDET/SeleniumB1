package Class12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _01_AlertDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp();  // switch to URL: https://selenium08.blogspot.com/2019/07/alert-test.html

        // How to handle a simple alert
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
        Thread.sleep(2000);

        // Question: What happens when we try to click on another element without handling an ALERT first?
//        driver.findElement(By.xpath("//div[text()='Search']")).click();
        // Answer: You will get "UnhandledAlertException" if you don't handle alert before doing anything else.

        Alert alert = driver.switchTo().alert();             // We switch the focus of the web browser to the alert window
        String alertText = alert.getText();                  // I am storing the text from the Alert in a String var.
        System.out.println("alertText: " + alertText);
        alert.accept();                                      // accept = OK


        // Handling Confirmation Alert


        // Handling Prompt Alert


        tearDown();
    }
}
