package Class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindAllLinks {
    private static String url = "https://amazon.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // IQ: Find all existing links in a given website    ===> Answer: by using the tagName.

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("allLinks = " + allLinks.size());

        int allLinksOnAmazon = allLinks.size();
        System.out.println("allLinksOnAmazon = " + allLinksOnAmazon); // 430

        // Task: Count and print all the links
//        for (WebElement link : allLinks) {
//            String linkText = link.getText();
//            System.out.println(linkText);  // ~ 430
//        }

        // Task: Count and print all links that have text (Do not print empty or blank links).
        int count = 0;
        for (WebElement link : allLinks) {
            String linkText = link.getText();
            if (!linkText.isEmpty() && !linkText.isBlank()) {
                System.out.println(linkText);
                count++;
            }
        }
        System.out.println("Total number of the links with text: " + count); // 157


        Thread.sleep(2000);
        driver.close();

    }
}
