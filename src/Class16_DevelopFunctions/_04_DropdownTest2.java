package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class _04_DropdownTest2 {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        String expectedText = "April";

        // Method 1 ==> without Select class  (we need to locate ALL children within the dropdown == List<WebElement>)
        List<WebElement> listOfMonths = driver.findElements(By.cssSelector("select[name='Month'] option"));
        selectDdValue(listOfMonths, "July");

        // Method 2 ==> use Select Class (if DD is built with Select class and has options, use this approach).
        // We only need to locate parent of dropdown (not Options) == single WebElement
        WebElement monthsDD = driver.findElement(By.cssSelector("select[name='Month']"));
        selectDdValue(monthsDD, expectedText);


        tearDown();
    }


    public static void selectDdValue(List<WebElement> dropdownList, String expectedValue) {
        for (WebElement element : dropdownList) {
            String actualValue = element.getText();
            if (actualValue.equals(expectedValue)) {
                element.click();
                break;
            }
        }
    }

    public static void selectDdValue(WebElement element, String expectedValue) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(expectedValue)) {
                select.selectByVisibleText(expectedValue);
                break;
            }
        }
    }

}
