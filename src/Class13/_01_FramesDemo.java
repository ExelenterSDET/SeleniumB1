package Class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _01_FramesDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://www.uitestpractice.com/Students/Switchto");

        // I am identifying web element and print it at the same line - all in one here
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'2022')]")).getText());

        // Trying to send text 'SDET' to the Frame's input text-box.
        // Note: Before interacting with a Frame, first we need to switch to it, then take action. Otherwise we get Exception.

        /**
         * We can switch to a frame using three different methods:
         *  1. By index
         *  2. By ID or Name
         *  3. By WebElement of the frame/iframe
         */

        // 1. By Index
        driver.switchTo().frame(0);                               // Switch to Frame by Index
        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys("SDET");

        driver.switchTo().defaultContent();                            // Switch back to main browser/window (parent window)

        // Let's try to get text from the main window/browser without switching to it first
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'2022')]")).getText());

        Thread.sleep(2000);

        // 2. By Name or ID
        driver.switchTo().frame("iframe_a");                  // Switch to Frame by Name/ID
        textBox.clear();
        textBox.sendKeys("QA Engineer");

        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        // 3. By Frame Web Element
        WebElement frame = driver.findElement(By.cssSelector("iframe[src='/Demo.html']")); // Here we identify web element and store it in a variable
        driver.switchTo().frame(frame);                               // Switch to Frame by its element
        textBox.clear();
        textBox.sendKeys("Frame by WebElement");


        tearDown();
    }

}
