package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

// TASK: Go to this website https://vitalets.github.io/combodate/
//  and select your DOB (example: DD/MM/YYYY, "25/04/1985"), and exit the browser
public class _05_DropdownDDMMYYYY {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://vitalets.github.io/combodate/");

        // 1. Find element for Day from the dropdown
        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        Select selectDayDD = new Select(dayDD);
        selectDayDD.selectByVisibleText("25");

        // 2. Find element for the Month from the DD
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        Select selectMonthDD = new Select(monthDD);
        selectMonthDD.selectByIndex(4);  // April

        // 3. Find element for the Year from the DD
        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));
        Select selectYearDD = new Select(yearDD);
        selectYearDD.selectByValue("1985");


        // NOTE: NEVER TYPE YOUR LOCATORS, SUCH AS XPATH, CSS. ALWAYS COPY-PASTE.

        Thread.sleep(2000);

        // Loop through the dayDD, find a specific date ("23") select it and print it to the console
        List<WebElement> dayList = selectDayDD.getOptions();
        for (WebElement day : dayList) {
            day.click();
            String dayText = day.getText();
            if (dayText.equals("23")) {
                System.out.println(dayText);
                break;
            }
        }


        tearDown();

    }
}
