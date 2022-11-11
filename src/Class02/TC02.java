package Class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TC 2: Website Page URL Verification:
 * 1. Open the chrome browser
 * 2. Navigate to “https://www.exelenter.com/"
 * 3. Navigate to “https://www.google.com/"
 * 4. Navigate back to Exelenter Page
 * 5. Refresh the current page
 * 6. Verify URL contains word “exelenter”
 * 7. Close the browser
 */
public class TC02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.exelenter.com");

        driver.navigate().to("https://google.com");
        driver.navigate().back();
        driver.navigate().refresh();

        if (driver.getCurrentUrl().contains("exelenter")) {
            System.out.println("Pass. URL does contain word \"exelenter\" ");
        } else {
            System.out.println("Fail. URL does not contain word \"exelenter\" ");
        }

        // another way to verify
        boolean exelenter = driver.getCurrentUrl().contains("exelenter");
        System.out.println(exelenter); // if pass = true

        driver.close();
    }

}
