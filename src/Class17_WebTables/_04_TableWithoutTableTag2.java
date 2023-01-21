package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _04_TableWithoutTableTag2 {
    public static void main(String[] args) {
        setUp("https://demoqa.com/webtables");

        //Find the number of columns and column names
        List<WebElement> columns = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        for (WebElement column : columns) {
            System.out.print(column.getText() + " | ");
        }
        int numOfColumn = columns.size();
        System.out.println("\nnumber of columns is: " + numOfColumn);

        System.out.println("========================================");

        // Find the number of the nonempty lines and write all lines separately.
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[1]"));
        int numOfRow = 0;
//        for (int i = 0; i < rows.size(); i++) {
//            if(!names.get(i).getText().isBlank()){
//                System.out.println(rows.get(i).getText());
//                numOfRow++;
//            }
//        }

        // Above code wrote all the information vertically. We want to write all lines separately.

        for (int i = 0; i < rows.size(); i++) {
            if (!names.get(i).getText().isBlank()) {
                for (int j = 1; j <= columns.size(); j++) {
                    System.out.print(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + (i + 1) + "]/div/div[" + j + "]")).getText() + " ");
                }
                numOfRow++;
                System.out.println();
            }
        }
        System.out.println("\nNumber of Rows is: " + numOfRow);
        System.out.println("============================================");


        //Add a new employer
        driver.findElement(By.cssSelector("#addNewRecordButton")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Ufuk");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Sarac");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("saracufuk77@gmail.com");
        driver.findElement(By.cssSelector("#age")).sendKeys("45");
        driver.findElement(By.cssSelector("#salary")).sendKeys("15000");
        driver.findElement(By.cssSelector("#department")).sendKeys("IT");
        driver.findElement(By.cssSelector("#submit")).click();

        //And print rows again

        rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        names = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[1]"));

        numOfRow = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (!names.get(i).getText().isBlank()) {
                for (int j = 1; j <= columns.size(); j++) {
                    System.out.print(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + (i + 1) + "]/div/div[" + j + "]")).getText() + " ");
                }
                numOfRow++;
                System.out.println();
            }
        }
        System.out.println("\nNumber of Rows is: " + numOfRow);

        tearDown();
    }
}
