package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _02_DynamicTable {
    public static void main(String[] args) {
        setUp("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

        //First we need to login
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        // Getting Rows
        List<WebElement> rows = driver.findElements(By.cssSelector("table[class='SampleTable'] tr"));
        System.out.println("Number of rows: " + rows.size());

        System.out.println("=== Print Rows ===");
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }

        System.out.println("=== Print Rows regular For Loop ===");
        // Note: Benefit of using For Loop with web tables is that we can skip header. We have more control with 'For Loop' how to iterate a list of Web Elements.
        for (int i = 1; i < rows.size(); i++) {          // Instead of zero, we start printing from 1, because 0 holds header, which we don't want to print.
            System.out.println(rows.get(i).getText());
        }

        System.out.println("=== Print Columns ===");
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='SampleTable']//tr[1]/th"));
        int totalColumns = columns.size();
        System.out.println("Number of columns: " + totalColumns);


        tearDown();
    }
}
