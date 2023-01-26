package Class19_Screenshots_Actions_JS;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utils.BaseClass;
import utils.ConfigsReader;

import java.io.File;
import java.io.IOException;

public class _02_ScreenshotSelenium4 extends BaseClass {    // Now this Class has access to BOTH BaseClass and CommonMethods' methods().
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");

        // Login to the web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperties("password"));
        clickButWaitForClickability(driver.findElement(By.id("btnLogin")));

        /**
         *  In Selenium 4 we have two new methods for taking Screenshots.
         *  They are called:
         *      1. getScreenshotAs();
         *      2. getFullPageScreenshotAs();   <== this method is ONLY available with Firefox driver.
         *
         *      These methods are new to Selenium 4, and are not available in Selenium 3.
         *      Using these methods we can take screenshots in two different ways:
         *        1. Section-level screenshots, specific to particular web element of the page.
         *        2. Full-page screenshots, entire page.
         *
         */


        // How to take screenshot of particular section, an element within a page.
        WebElement quickLaunch = driver.findElement(By.className("quickLaungeContainer"));
        File sourceFile = quickLaunch.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(sourceFile, new File("screenshots/quickLaunch.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to take screenshot");
        }


        tearDown();
    }
}
