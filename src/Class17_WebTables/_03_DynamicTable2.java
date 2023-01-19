package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _03_DynamicTable2 extends BaseClass {
    public static void main(String[] args) {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        //First we need to login
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        // Getting Rows
        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr"));
        System.out.println("Number of rows before deletion: " + rows.size());

        // Task: Selecting a specific row and perform action on it, such as, edit or delete it.
        String expectedValue = "Mark Smith";
        for (int i = 1; i < rows.size(); i++) {
            if (rows.get(i).getText().contains(expectedValue)) {
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
                break;
            }
        }

        wait(1);
        // Once you find expected value, click delete button and delete it.
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        // Reprint number of rows after deletion:
        rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr"));
        System.out.println("Number of rows after deletion: " + rows.size());

        tearDown();
    }

}
