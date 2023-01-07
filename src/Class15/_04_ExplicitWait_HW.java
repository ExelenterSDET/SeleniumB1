package Class15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.BaseClass.*;

/**
 * Task: HW: Explicit Wait
 *    1. Go to this URL: "https://the-internet.herokuapp.com/dynamic_loading/2"
 *    2. Click on the 'Start' button, it will load 'Hello World' text after some time.
 *    3. Using Explicit Wait (NOT implicit) wait for the Hello World text to become available.
 *    4. Once the element is visible, grab it and print it to the console.
 *    5. Close the browser.
 *       Bonus: Use Try-Catch in case if your automation fails, but your browser still does close. (Intentionally fail it = Negative Testing).
 */
public class _04_ExplicitWait_HW {

    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/dynamic_loading/2");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");          // This line of code will get rid of extra error logs from the console.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); // Implicit wait, dynamic wait.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        try {
            driver.findElement(By.cssSelector("div[id='start'] button")).click(); // div#start button
            //Thread.sleep(10);  // static wait, even element is fond in 3 sec, we will be wasting another 7 sec.
            wait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish h4"), "Hello World!"));
            System.out.println(driver.findElement(By.cssSelector("div#finish h4")).getText());
        } catch (NoSuchElementException e) { // Note: if you get this type of exception, just replace with this: TimeOutException
            e.printStackTrace();
            System.out.println("Element is not found. Wait longer for the element to become visible on the UI");
        }

        tearDown();

    }
}
