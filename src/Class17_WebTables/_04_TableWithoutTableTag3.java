package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _04_TableWithoutTableTag3 extends BaseClass {
    public static void main(String[] args) {
        int ctr = 0;
        setUp("https://demoqa.com/webtables");

        List<WebElement> elements = driver.findElements(By.cssSelector("div[class='rt-thead -header']"));
        List<WebElement> elements1 = driver.findElements(By.cssSelector("div[class='rt-resizable-header-content']"));
        System.out.println(elements1.size());
        List<WebElement> elements2 = driver.findElements(By.className("rt-tr-group"));
        for (WebElement element : elements2) {
            if (!element.getText().isBlank()) {
                System.out.println(element.getText());
                ctr++;
            }
        }
        System.out.println(ctr);

        driver.findElement(By.cssSelector("button[id='addNewRecordButton']")).click();
        driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("Arthur");
        driver.findElement(By.cssSelector("input[id='lastName']")).sendKeys("Bennett");
        driver.findElement(By.cssSelector("input[id='userEmail']")).sendKeys("Arthur@gmail.com");
        driver.findElement(By.cssSelector("input[id='age']")).sendKeys("56");
        driver.findElement(By.cssSelector("input[id='salary']")).sendKeys("200000");
        driver.findElement(By.cssSelector("input[id='department']")).sendKeys("SDET");
        wait(2);
        driver.findElement(By.cssSelector("button[id='submit']")).click();
        System.out.println("After add");
        ctr = 0;
        elements2 = driver.findElements(By.className("rt-tr-group"));
        for (WebElement element : elements2) {
            if (!element.getText().isBlank()) {
                System.out.println(element.getText());
                ctr++;
            }
        }
        System.out.println(ctr);

        tearDown();
    }
}
