package Class12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _02_ModalAlert {
    public static void main(String[] args) throws InterruptedException {
        setUp();   // switch to URL: https://demoqa.com/modal-dialogs

        WebElement modalAlert = driver.findElement(By.id("showSmallModal"));   // Find web element for modal alert type (HTML based alert) and store it
        modalAlert.click();                                                          // click to trigger (launch) it.
        System.out.println(modalAlert.getText());                                    // Retrieving the text of Modal dialog (WebElement itself)

        // Print in two lines (Title of Modal)
        String modalTitleText = driver.findElement(By.xpath("//div[@class='modal-title h4']")).getText();
        System.out.println("modalTitleText: " + modalTitleText);

        // Print in one line (Body content of Modal)
        System.out.println("modalBodyText: " + driver.findElement(By.xpath("//div[@class='modal-body']")).getText());

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Close']")).click();         // I am closing the modal by clicking 'Close' button

        tearDown();
    }
}
