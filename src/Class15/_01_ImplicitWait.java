package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import static utils.BaseClass.*;

public class _01_ImplicitWait {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));        // Selenium 4. This is implicit wait, and its dynamic wait.
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  // Selenium 3.

        Thread.sleep(2000);


        try {
            driver.findElement(By.cssSelector("div#start button")).click();               // Locate 'Start' button element and click on it
            WebElement helloWorld = driver.findElement(By.cssSelector("div#finish h4"));  // Locate Hello World web element and store it
            System.out.println("Hello World text: " + helloWorld.getText());                            // Printing text from the element 'Hello World'
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Element is not found. Wait longer for the element to become visible on the UI");
        }

        tearDown();
    }
}
