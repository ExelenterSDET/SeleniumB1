package Class14;

import org.openqa.selenium.By;

import java.util.Set;

import static utils.BaseClass.*;


/**
 * Task: Go to this URL: https://the-internet.herokuapp.com/windows
 *     1. Identify and print parent window ID and Title
 *     2. Click on the link where it says 'Click Here' three times
 *     3. Switch to new tabs and print their title to the console as well.
 *        Bonus: Load facebook website in all children pages.
 */
public class _04_Task {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/windows");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.linkText("Click Here")).click();  // Don't type LOCATORS, always copy-paste.
            Thread.sleep(500);
        }

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window ID: " + parentWindow);
        System.out.println("Parent window title: " + driver.getTitle());

        Set<String> allWindows = driver.getWindowHandles();
        int totalNumberOfWindows = allWindows.size();

        for (String tab : allWindows) {
            if (!tab.contains(parentWindow)) {
                //System.out.println("Child page title: " + driver.switchTo().window(tab).getTitle());
                driver.switchTo().window(tab);        // if not parent, go ahead, make a switch.
                driver.get("https://fb.com");                     // Once you make the switch, load the given URL to this new tab.
                System.out.println("Child page title: " + driver.getTitle());   // grab its title and print it, after the switch.
                Thread.sleep(500);
            }
        }

        tearDown();
    }
}
