package Class14;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

import static utils.BaseClass.*;

public class _03_WindowHandle3 {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://demoqa.com/browser-windows");

        String parentWindowTitle = driver.getTitle();
        System.out.println("parentWindowTitle: " + parentWindowTitle);
        String parentWindow = driver.getWindowHandle();
        System.out.println("parentWindow ID: " + parentWindow);

        for (int i = 0; i < 3; i++) {                                  // Specifying number of clicks
            //driver.findElement(By.id("tabButton")).click();          // Open in a new Tab
            driver.findElement(By.id("windowButton")).click();  // Open in a new Window (browser)
            Thread.sleep(1000);
        }

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowOrTab : allWindows) {
            driver.switchTo().window(windowOrTab);
            driver.get("https://google.com");
            System.out.println("Window ID: " + windowOrTab + " Title: " + driver.getTitle());
            Thread.sleep(1000);
        }

        // With iterator
        System.out.println("===================");
        Iterator<String> iterator = allWindows.iterator();
        while (iterator.hasNext()) {
            String windowOrTab = iterator.next();
            driver.switchTo().window(windowOrTab);
            System.out.println("Window ID: " + windowOrTab + " URL: " +  driver.getCurrentUrl());
        }


        tearDown();
    }
}
