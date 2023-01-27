package Class19_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _04_ActionsClassDemo extends BaseClass {
    public static void main(String[] args) throws AWTException {
        setUp("https://www.ebay.com");

        WebElement myEBay = driver.findElement(By.linkText("My eBay"));

        Actions actions = new Actions(driver);
        actions.moveToElement(myEBay).perform();

        // Once you hover over an element, now you can verify anything on that page/dropdown
        String summaryText = driver.findElement(By.xpath("(//ul[@id='gh-ul-nav']//a)[1]")).getText();
        if (summaryText.contains("Summary"))
            System.out.println("Hover over 'My eBay' worked.");
        else
            System.out.println("Hover didn't work.");

        wait(1);
        WebElement electronicsMenu = driver.findElement(By.linkText("Electronics"));
        actions.moveToElement(electronicsMenu).perform();           // Hover on 'Electronics' menu
        wait(1);
        actions.contextClick(electronicsMenu).perform();            // Right-click on 'Electronics' menu
        wait(1);
//        electronicsMenu.sendKeys(Keys.ESCAPE);               // For some reason, this ESCAPE didn't work
//        actions.sendKeys(Keys.ESCAPE).build().perform();     // For some reason, this ESCAPE didn't work
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        wait(1);

        driver.navigate().to("https://demoqa.com/buttons");    // We are navigating from eBay to this new website
        wait(1);
        // Here we are locating 'Double Click Me' button and using double click on it from the Actions Class.
        actions.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());     // Locating and Printing message for Double Click Me.


        wait(1);
        tearDown();
    }
}
