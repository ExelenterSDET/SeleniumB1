package Class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * TC 4.3: Print visible links from the Exelenter Homepage
 *      1. Open the Chrome browser
 *      2. Go to Exelenter Website
 *      3. Iterate through the links until you find "Enroll Now"
 *      4. Once expected keyword is found, print it and exit
 *      5. Close the browser
 */
public class FindSpecificLink {
    static String expectedText = "Enroll Now";
    private static String url = "https://exelenter.com";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);


        // Find all links on the Exelenter webpage
        List<WebElement> allLinksOnExelenter = driver.findElements(By.tagName("a"));
        System.out.println("allLinksOnExelenter = " + allLinksOnExelenter.size());


        // Store total number of the links in an INT data type
        int totalLinks = allLinksOnExelenter.size();
        System.out.println("Total number of Links on Exelenter = " + totalLinks);

        // Count and print only the link with the text that says 'Enroll Now'
        int count = 0;
        for (WebElement link : allLinksOnExelenter) {
            String linkText = link.getText();
            if (!linkText.isEmpty()) {
                System.out.println(linkText);
                count++;
            }
            if (linkText.contentEquals(expectedText)) {
                System.out.println("Expected phrase is found: " + linkText);
                break;
            }
        }

        System.out.println("-------------------");
        System.out.println("Total number of the links with text: " + count);


        /**
         *
         *
         *   List ==
         *   Map is made of K,V
         *      map.keySet()=== keys, map.values()
         */


        Thread.sleep(2000);
        driver.close();

    }
}
