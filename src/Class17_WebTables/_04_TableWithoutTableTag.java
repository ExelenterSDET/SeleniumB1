package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _04_TableWithoutTableTag {
    public static void main(String[] args) {
        setUp("https://demoqa.com/webtables");

        // Entire header located as a single web element.
        WebElement thead = driver.findElement(By.cssSelector("div[class='rt-thead -header']"));
        //System.out.println(thead.getText());

        // Print columns:
        List<WebElement> columns = driver.findElements(By.cssSelector("div[class='rt-thead -header'] div div div:nth-child(1)"));
        int totalColumns = columns.size();
        System.out.println("Number of columns: " + totalColumns);
        for (WebElement column : columns) {
            System.out.print(column.getText() + " | ");
        }

        // Print rows
        List<WebElement> rows = driver.findElements(By.cssSelector("div.rt-tr-group"));
        int totalRows = rows.size();
        System.out.println("\nNumber of rows: " + totalRows);


        tearDown();
    }
}
