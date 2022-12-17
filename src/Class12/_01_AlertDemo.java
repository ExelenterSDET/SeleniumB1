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
        String alertText = alert.getText();                  // I am storing the text from the Alert in a String variable
        System.out.println("alertText: " + alertText);
        alert.accept();                                      // accept = 'OK' button

        Thread.sleep(2000);

        // Handling Confirmation Alert
        driver.findElement(By.cssSelector("button#confirm")).click();
        Alert confirmationAlert = driver.switchTo().alert();   // Note: For all alert types we use the same .switchTo().alert();
        String confirmationAlertText = confirmationAlert.getText();
        System.out.println("confirmationAlertText: " + confirmationAlertText);
        Thread.sleep(2000);
        confirmationAlert.dismiss();                       // dismiss = 'Cancel' button

       Thread.sleep(2000);

        // Handling Prompt Alert
        driver.findElement(By.id("prompt")).click();           // identify webElement for the Alert and click on it
        Alert promptAlert = driver.switchTo().alert();                // Switching to Alert (from the browser) to handle it
        String promptAlertText = promptAlert.getText();               // Get the content/text of the Alert (not the browser)
        System.out.println("promptAlertText: " + promptAlertText);
        Thread.sleep(1000);                                      // Add time only when needed. This is totally optional.
        promptAlert.sendKeys("Said");                       // I am sending text/value into the input text box.
        Thread.sleep(1000);
        promptAlert.accept();                                         // Press OK button to close the alert


        // Let's verify our entered text
        String enteredText = driver.findElement(By.xpath("//div[contains(text(),'Said')]")).getText();
        System.out.println("enteredText: " + enteredText);

        String expectedText = "Said";                              // For negative testing, only change here, add sth at the end.
        if (enteredText.contains(expectedText))
            System.out.println("Text is added successfully. Test passed.");
        else
            System.err.println("Text is NOT added. Test failed.");


        tearDown();
    }
}
