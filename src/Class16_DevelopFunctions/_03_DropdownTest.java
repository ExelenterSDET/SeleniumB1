package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

public class _03_DropdownTest {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        String expectedText = "January";

        List<WebElement> listOfMonths = driver.findElements(By.cssSelector("select[name='Month'] option"));
        for (WebElement month : listOfMonths) {
            String actualText = month.getText();
            if (actualText.equals(expectedText)) {
                month.click();
                break;
            }
        }

        selectFromDropbox(listOfMonths, "February");
        WebElement monthsDD = driver.findElement(By.cssSelector("select[name='Month']"));
        selectDropDown(monthsDD, "March");


        tearDown();
    }

    // Task: HW Take this logic and put it inside its own independent method just like we did with RadioOrCheckbox

    public static void selectDdValue() {
    }

    public static void selectFromDropbox(List<WebElement> dropboxSelection, String expectedValue) {
        for (WebElement element : dropboxSelection) {
            String actualValue = element.getText();
            if (actualValue.equals(expectedValue)) {
                element.click();
                break;
            } else {

            }
        }
        System.out.println("Test failed. Expected value does not match actual value");
    }

    public static void selectDropDown(WebElement element, String expected) {
        Select select = new Select(element);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(expected)){
                select.getOptions().get(i).click();
                break;
            }
        }
    }
}
