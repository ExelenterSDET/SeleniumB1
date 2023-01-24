package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;


public class _01_SimpleCalendar2 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://demoqa.com/date-picker");

        // Click on the date-picker field to pop/activate the calendar.
        driver.findElement(By.id("datePickerMonthYearInput")).click();

        List<WebElement> day = driver.findElements(By.cssSelector("div.react-datepicker__week div"));
        for (int i = 0; i < day.size(); i++) {
            System.out.print(day.get(i).getText() + " | ");
        }


        tearDown();
    }
}
