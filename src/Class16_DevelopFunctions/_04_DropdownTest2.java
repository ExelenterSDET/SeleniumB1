package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;
public class _04_DropdownTest2  {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        String expectedText = "January";

        // Method 1 ==> without Select class  (we need to locate ALL children within the dropdown == List<WebElement>)
        List<WebElement> listOfMonths = driver.findElements(By.cssSelector("select[name='Month'] option"));
        for (WebElement month : listOfMonths) {
            String actualText = month.getText(); // or .getValue();
            if (actualText.equals(expectedText)) {
                month.click();
                break;
            }
        }

        // Method 2 ==> use Select Class (if DD is built with Select class and has options, use this approach).
        // We only need to locate parent of dropdown (not Options) == single WebElement
        WebElement monthsDD = driver.findElement(By.cssSelector("select[name='Month']"));
        Select select = new Select(monthsDD);
        select.selectByIndex(4);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(expectedText)) {
                select.selectByVisibleText(expectedText);
                break;
            }
        }

        // Calling both Method 1 & Method 2 from the CommonMethods Class.
        selectDdValue(monthsDD, expectedText);   // Selecting by visible text
        selectDdValue(listOfMonths, "March");
        selectDdValue(monthsDD, 55);                   // Selecting by index
        selectDdValue(driver.findElement(By.cssSelector("select[name='country']")), 400);

        tearDown();
    }




}
