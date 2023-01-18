package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _03_DynamicTable1 {
    public static void main(String[] args) {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        //First we need to login
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        // Getting Rows
        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr"));
        System.out.println("Number of rows: " + rows.size());

        // Task: Selecting a specific row and perform action on it, such as, edit or delete it.
        String expectedValue = "Charles Dodgeson";

        List<WebElement> actualValue = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[2]")); // Names column

        // Task: Compare expected with Actual, once match is found, click on the checkbox and then click on the delete button.

        for (int i = 0; i < rows.size(); i++) {
            // Logic: Step 1: if Name column contains expectedValue go ahead and click checkbox next to it.
            driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(" + i + ")")); // <== we can also use xPath version of this css
        }

        // Step 2: locate Delete web element and click on it to delete selected name
        // Step 3: Print all rows again, now you should have one less row.

        tearDown();
    }
}
