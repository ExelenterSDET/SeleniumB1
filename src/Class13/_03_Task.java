package Class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _03_Task {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://ui.vision/demo/webtest/frames/");

        // Task: Go to Frame 5 and get the text from the link, and print it to the console. Then click on the link.

        /**
         *  1. First identify webElement for the frame
         *  2. Switch to frame using ID, Name, index OR webElement
         *  3. Locate web element for the link, and retrieve text from it, orint to console
         *  4. Quit the browser
         */

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='frame_5.html']")));
        WebElement link = driver.findElement(By.linkText("https://a9t9.com"));
        System.out.println("linkText: " + link.getText());


        Thread.sleep(2000);
        link.click();
        Thread.sleep(2000);

        tearDown();
    }
}
