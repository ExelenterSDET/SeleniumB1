package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class DropdownDemo2 {
    public static void main(String[] args) throws InterruptedException {
        setUp();

        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country']"));
        Select select = new Select(countryDD);

        // Note: Select Class provides three different options (methods) to select a value from a drop-down.

        // 1. By Index
        select.selectByIndex(1);

        Thread.sleep(2000);

        // 2. By Value
        select.selectByValue("JP");

        Thread.sleep(2000);

        // 3. By Visible Text
        select.selectByVisibleText("Italy");

        // Other way to select using Visible text (Still use Select class, but not VisibleText() method)
        List<WebElement> countries = select.getOptions();   //countries.size() = 248
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getText().equals("France")) {
                countries.get(i).click();
                break;
            }
        }



        tearDown();
    }
}
