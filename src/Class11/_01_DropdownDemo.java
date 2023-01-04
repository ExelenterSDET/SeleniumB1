package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

/**
 * There are 3 ways we can utilize existing methods of another class inside current class
 * 1. By using 'extends BaseClass'
 * 2. By accessing through class name such as 'BaseClass.setUp();
 * 3. By static import - 'import static utils.BaseClass.*;'
 */

public class _01_DropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        // 1st way: Without using Select Class
//        List<WebElement> countries = driver.findElements(By.cssSelector("select[name='country'] option"));
//        for (WebElement country : countries) {
//            System.out.println(country.getText());
//        }


        // 2nd way: Using the Select class provided by Selenium
        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country']"));
        Select select = new Select(countryDD);

        // Get the size of the dropdown
        List<WebElement> countries = select.getOptions();
        System.out.println("Total number of countries: " + countries.size());

        // Loop through all countries using their index
        for (WebElement country : countries) {
            country.click();
            if (country.getText().equals("Denmark")) {
                country.click();
                System.out.println("County is found: " + country.getText());
                break;
            }
        }

        System.out.println("=== Print ALL Countries ===");
        for (WebElement country : countries) {
            System.out.println(country.getText());
        }

//        for (int i = 0; i < countries.size(); i++) {
//            countries.get(i).click();
//            Thread.sleep(50);
//        }


        tearDown();
    }
}
