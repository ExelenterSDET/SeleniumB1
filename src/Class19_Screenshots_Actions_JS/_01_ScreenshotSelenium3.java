package Class19_Screenshots_Actions_JS;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import utils.BaseClass;
import utils.ConfigsReader;

import java.io.File;
import java.io.IOException;

public class _01_ScreenshotSelenium3 extends BaseClass {    // Now this Class has access to BOTH BaseClass and CommonMethods' methods().
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");

        // Login to the web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperties("password"));
        clickButWaitForClickability(driver.findElement(By.id("btnLogin")));

        /**
         *  In Selenium 3, we use 'TakesScreenshot' interface to take snapshots of web pages.
         *  For copying file from source (webpage) to destination (your local folder), we can use either:
         *      1. FileUtils.copyFile(sourceFile, destinationFile)  <== from Commons IO, an Apache Library
         *      2. FileHandler.copy(sourceFile, destinationFile)    <== from Selenium Library
         */

        // Before taking screenshot, wait for any element (yellow circle) to become present

        // One way: local Explicit wait used here.
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flot-overlay")));

        // Second way: we use one of the Waits from the CommonMethods Class;
        waitForPresenceOfElement(By.className("flot-overlay"));            // this method is coming from CommonMethods Class
        //waitForVisibilityOfElement(By.className("flot-overlay"));                      // this method is coming from CommonMethods Class

        // 3rd way, hard wait. coming from Java, not Selenium.
//        wait(2);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/dashboard5.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Screenshot is not taken");
        }

        tearDown();
    }
}
