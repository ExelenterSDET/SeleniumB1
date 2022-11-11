package Class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01 {
    public static void main(String[] args) {
        /**
         *  TC 1: Amazon Page Title Verification:
         *  1. Open the chrome browser
         *  2. Go to “https://www.amazon.com”
         *  3. Verify expected Title “Whatever title will be…” is correct
         *  4. Print the title to the console
         *  5. Close the browser
         *
         * */

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        // Retrieve the title (actual title)
        String title = driver.getTitle();
        System.out.println(title);

        // Verify the title is correct (as expected).  Verification before/without TestNG or JUnit
        String expectedTitle = "Amazon.com. Spend less. Smile more!!!.";
        if (title.equals(expectedTitle)) {
            System.out.println("Test Passed. The title is correct.");
        } else {
            System.out.println("Test Failed. The title is not correct.");
        }

        driver.close();


    }
}
