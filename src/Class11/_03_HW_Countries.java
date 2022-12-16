package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class _03_HW_Countries {
    public static void main(String[] args) throws InterruptedException {
        setUp();

        WebElement countryDD = driver.findElement(By.cssSelector("select[name='country']"));
        Select select = new Select(countryDD);

        // 1st way: Using Select class
//        select.selectByVisibleText("United States of America");

        // 2nd way:
        // Before looping I need list of web elements which I am about to loop
        List<WebElement> listOfCountries = select.getOptions();
        for (WebElement country : listOfCountries) {
            if (country.getText().equals("United States of America")) {
                country.click();
                System.out.println("USA is found and selected: " + country.getText());
                break;
            }
        }

        Thread.sleep(2000);

        // Task: Loop through the list of countries until 'Morocco' country is found, select and exit.
        for (WebElement country : listOfCountries) {
            Thread.sleep(100);
            country.click();
            if (country.getText().equals("Morocco")) {
                country.click();
                System.out.println("Country is found: " + country.getText());
                break;
            }
        }

        tearDown();
    }
}
