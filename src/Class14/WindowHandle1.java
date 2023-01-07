package Class14;

import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

import static utils.BaseClass.*;

public class WindowHandle1 {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://the-internet.herokuapp.com/windows");

        /**
         *  How to handle new TABS and new WINDOWS in Selenium?
         *  We have two methods for handling new tabs/windows.
         *      1. getWindowHandle();    ==> handles main window only
         *      2. getWindowHandles();   ==> handles ALL windows (or tabs) including the main/parent window
         */

        String mainWindowTitle = driver.getTitle();
        System.out.println("Main Window Title: " + mainWindowTitle);

        String windowHandle = driver.getWindowHandle();              // this will return parent's window unique ID
        System.out.println("Main window ID: " + windowHandle);

        driver.findElement(By.linkText("Click Here")).click();

        // Focus is still in the main/parent window, because we have not switched to the child window yet.
        // System.out.println(driver.getTitle());  // Which window title will print here?

        Set<String> allWindows = driver.getWindowHandles();       // this will return unique IDs for ALL windows
        int allOpenWindows = allWindows.size();
        System.out.println("All tabs currently open: " + allOpenWindows);

        System.out.println("===================");
        //System.out.println(allWindows);
        //allWindows.forEach(System.out::println);       // <--- use forEach() - if you want to print them all on each new line

        // Here comes your iterator skills - put them in good use
        Iterator<String> iterator = allWindows.iterator();
        String mainWindow = iterator.next();
        String childWindow = iterator.next();
        System.out.println("mainWindow: " + mainWindow);
        System.out.println("childWindow: " + childWindow);

        System.out.println("===================");
        System.out.println("Get title before the switch: " + driver.getTitle());

        // How to switch focus to the child window and print its title
        driver.switchTo().window(childWindow);               // Here we are switching from the Parent window to Child window

        System.out.println("Get title after the switch: " + driver.getTitle());

        // if I call driver.close() in this line, which window/tab will close?
        Thread.sleep(1000);
        driver.close();                   // it should close child, because as of this line FOCUS is on the child.

        //Thread.sleep(1000);
       // driver.close();                   // if we try to close it again. Child window is already closed, and when it is not found, we get NoSuchWindowException

        tearDown();
    }
}
