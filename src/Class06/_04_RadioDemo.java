package Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _04_RadioDemo {
    private static String url = "https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // We are retrieving the list of web elements
        List<WebElement> browsers = driver.findElements(By.xpath("//input[@name='browser']"));

        // Get the size of the list
        int browserCount = browsers.size();
        System.out.println("browserCount = " + browserCount); // return 3 = IE, Mozilla, Opera

        //Iterate through the list and print them on the console:
        // 1. Regular Loop
        System.out.println("--- Regular Loop ---");
        int count = 1;
        for (int i = 0; i < browsers.size(); i++) {
            String attrValue = browsers.get(i).getAttribute("value");
            System.out.println(count + ". " + attrValue);
            count++;
        }

        System.out.println("--- For Each Loop ---");
        // 2. Enhanced Loop (For Each Loop)
        for (WebElement element : browsers) {
            System.out.println(element.getAttribute("value"));
        }


        System.out.println("-----------------------");
        // Select only elements which are enabled, but not selected
        for (WebElement element : browsers) {
            if (element.isEnabled() && !element.isSelected()) {
                System.out.println(element.getAttribute("value"));
            }
        }

        // Loop through the list of the web elements and when 'Opera' is found, click on it.
        for (WebElement browser : browsers) {
            String attrValue = browser.getAttribute("value");
            if (attrValue.equals("Opera")) {
                browser.click();
                System.out.println("'Opera' is found and selected");
                break;
            }
        }


        Thread.sleep(2000);
        driver.close();

    }
}
