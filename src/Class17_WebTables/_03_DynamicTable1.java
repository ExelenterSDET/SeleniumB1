package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _03_DynamicTable1 extends BaseClass {
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
        String expected_Value = "Steve Johns";
        String expectedValue = "Steve Johns";

        // 1st way: Ufuk Code:
        List<WebElement> actualValues = driver.findElements(By.xpath("(//table[@class='SampleTable']//tr/td[2])"));
        for (int i = 0; i < actualValues.size(); i++) {
            if (actualValues.get(i).getText().equals(expected_Value)) {
                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i + 1) + "]")).click();    // +1 We need to skip header,
                wait(1);
                driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete")).click();
                wait(1);
                break;
            }
        }

        //Verify it is deleted or not
        rows = driver.findElements(By.xpath("//table[@class='SampleTable']//tr")); // re-calculating rows after deletion.
        System.out.println("Number of rows after deletion: " + rows.size());
//        System.out.println("Number of rows after deletion: " + numOfRows2);
//        if (numOfRows2 == (rows.size() - 1)) {
//            System.out.println("Deletion is successful.");
//        }


        // 2nd way: Dilnoza Code
//        String expectedValue = "Clare Jefferson";
//        List<WebElement> actualValues = driver.findElements(By.xpath("//table[@class='SampleTable']//tr/td[2]"));
//        for (int i = 0; i < actualValues.size(); i++) {
//            if (actualValues.get(i).getText().equals(expectedValue)) {
//                driver.findElement(By.xpath("(//input[@type='checkbox'])[" + (i+1) + "]")).click();
//                wait(1);
//                driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();//
//                wait(1);
//                break;
//            }
//        }


        //3rd way: Bahodur Code:

//        List<WebElement> tableName = driver.findElements(By.cssSelector("table.SampleTable tr td:nth-child(2)"));
//        //td[text() = 'Paul Brown']//preceding-sibling::td//input
//
//        for (int i = 0; i < tableName.size(); i++) {
//            if (tableName.get(i).getText().equals(expectedValue)){
//                driver.findElement(By.xpath("//td[text() = '" + tableName.get(i).getText() + "']//preceding-sibling::td//input")).click();
//            }
//        }


        tearDown();
    }
}
