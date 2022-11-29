package Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_RadioDemo {
    private static String url = "https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // Go to given website, find Mozilla radio button and click on it.
//        driver.findElement(By.xpath("//input[@name='browser'][2]")).click();

        // Go to given website, find Mozilla radio button from the list and verify if it is 1. Displayed, 2.Enabled, 3.Selected.
        boolean displayed = driver.findElement(By.xpath("//input[@name='browser'][2]")).isDisplayed();    // true
        boolean enabled = driver.findElement(By.xpath("//input[@name='browser'][2]")).isEnabled();        // true
        boolean selected = driver.findElement(By.xpath("//input[@name='browser'][2]")).isSelected();      // false

        System.out.println("displayed = " + displayed);
        System.out.println("enabled = " + enabled);
        System.out.println("selected = " + selected);

        boolean ieSelected = driver.findElement(By.xpath("//input[@name='browser'][1]")).isSelected();
        System.out.println("ieSelected = " + ieSelected);


        Thread.sleep(2000);
        driver.close();

    }
}
