package Class14;

import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static utils.BaseClass.*;

public class _02_WindowHandle {
    public static void main(String[] args) {
        setUp("https://google.com");

        System.out.println("Parent window: " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.TAB);   // This will open a new BLANK TAB and switch (the focus) to it
        driver.get("https://about.google/");                    // This will open given URL in our new blank tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://store.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://exelenter.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");


        Set<String> allWindows = driver.getWindowHandles();                          // This will store all TABS in a Set of Strings
        System.out.println("How many tabs open right now: " + allWindows.size());    // We are printing total TABS open right now


        System.out.println("==============================");
        // Let's iterate through all windows/tabs
        Iterator<String> iterator = allWindows.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            String nextWindow = iterator.next();
            //System.out.println(nextWindow);                    // This method doesn't care where the focus is, it will print ALL unique IDs regardless.
            driver.switchTo().window(nextWindow);   // First we MUST switch to child window before we can get its title or perform action on it
            String title = driver.getTitle();                    // This method cares about the FOCUS, thus we need to first switch to current window THEN retrieve the title
            System.out.println("Window " + count + " title: " + title);
            count++;


            // What if we want to switch focus to a specific tab/window?
            if (title.contains("Store")) {
                driver.switchTo().window(nextWindow);
                System.err.println("Window is found and switched to: " + driver.getTitle());
                System.err.println("Window ID: " + nextWindow);
                //break;
            }
        }

        tearDown();
    }
}
