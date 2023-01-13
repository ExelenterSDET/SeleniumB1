package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _05_Dropdown3 {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://vitalets.github.io/combodate/");

        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));

        // Go and select April 15th, 2012.
        selectDdValue(dayDD, "15");
        selectDdValue(monthDD, "Apr"); // We can use by Index OR by visible Text
        selectDdValue(yearDD, "2012");

        Thread.sleep(2000);
        // Let's assume dropdown doesn't have Class tag, how would you locate and select dates from it?
        List<WebElement> daysDD = driver.findElements(By.xpath("(//select[@class='day '])[1]/option"));
        selectDdValue(daysDD, "17");

        tearDown();
    }
}
