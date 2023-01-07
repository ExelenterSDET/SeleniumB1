package Class14;

import org.openqa.selenium.WindowType;
import utils.ConfigsReader;

import java.util.Set;

import static utils.BaseClass.*;

public class WindowHandle3_Refactor1 {
    static String expectedTitle = "Store";
    public static void main(String[] args) {
        setUp("https://google.com");

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window: " + parentWindow);

        driver.switchTo().newWindow(WindowType.TAB);    // This will open a new BLANK TAB and switch (the focus) to it
        driver.get("https://about.google/");                    // This will open given URL in our new blank tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://store.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://exelenter.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        Set<String> allWindows = driver.getWindowHandles();          // This will store all TABS in a Set of Strings
        //allWindows.forEach(System.out::println);                   // This will print ALL Tabs/Windows using forEach() method.


        // I am printing ALL children Tabs/Window except parent window:
//        for (String window : allWindows) {
//            if (!window.contains(parentWindow)) {
//                System.out.println("This is a child window: " + driver.switchTo().window(window).getTitle());
//            }
//        }

        // Note: Ternary operator ==> This is similar to the one above, instead of enhanced loop we are using ternary here.
//        allWindows.forEach(window -> System.out.println(!window.contains(parentWindow)?"Child: " + window:"Parent: " + parentWindow));



        // We are calling the switchToWindow() method in three different ways in below examples:

        //switchToWindow("Store", allWindows);                      // 1st way: Loop through all windows and when 'Store' is found' print it
        //switchToWindow(expectedTitle, allWindows);                // 2nd way:
        switchToWindow(ConfigsReader.getProperties("expectedTitle"), allWindows);   // 3rd way: In this line, it is reading from properties file.


        tearDown();
    }

    public static void switchToWindow(String windowTitle, Set<String> windows) {
        for (String windowOrTab : windows) {
            String title = driver.switchTo().window(windowOrTab).getTitle();
            if (title.contains(windowTitle)) {
                System.err.println("Window is found! Page Title: " + driver.getTitle() +  " URL: " + driver.getCurrentUrl());
                break; // With 'break', If I search windowTitle by 'Google' only first title will print, without break ALL titles that contain text 'Google' will print
            }
        }
    }
}
