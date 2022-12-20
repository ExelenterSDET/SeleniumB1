package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class _02_DropdownDemo2 {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country']"));
        Select select = new Select(countryDD);

        // Note: Select class provides three different options (methods) to select a value from a drop-down.

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
                System.out.println(countries.get(i).getText());
                break;
            }
        }

        // Finding a web element from the Dropdown without Select class (including its methods)
        List<WebElement> countriesList = driver.findElements(By.xpath("//*[@name='country']/option"));
        for (WebElement country : countriesList) {
            if (country.getText().equals("Cuba")) {
                country.click();
                break;
            }
        }

        // Check if List of Countries is multiple - if we can select multiple elements at a time
        System.out.println("CountryDD is Multiple: " + select.isMultiple());                        // Can I choose/select more than one at once?

        // Identify if 'Months' dropdown is multiple or not
        WebElement months = driver.findElement(By.cssSelector("select[name='Month']"));
        Select selectMonths = new Select(months);

        System.out.println("MonthsDD is Multiple: " + selectMonths.isMultiple());


        tearDown();
    }
}
