package Class16_DevelopFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.BaseClass.*;

public class _03_DropdownTest {
    public static void main(String[] args) {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        String expectedText = "May";

//        List<WebElement> listOfMonths = driver.findElements(By.cssSelector("select[name='Month'] option"));
//        for (WebElement month : listOfMonths) {
//            String actualText = month.getText();
//            if (actualText.equals(expectedText)) {
//                month.click();
//                break;
//            }
//        }

        tearDown();
    }

    // Task: HW Take this logic and put it inside its own independent method just like we did with RadioOrCheckbox

    public static void selectDdValue() {

    }
}
