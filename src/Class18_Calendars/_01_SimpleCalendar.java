package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;


public class _01_SimpleCalendar extends BaseClass {
    public static void main(String[] args) {
        setUp("https://demoqa.com/date-picker");

        // Let's pick October 17, 2018

        // Click on the date-picker field to pop/activate the calendar.
        driver.findElement(By.id("datePickerMonthYearInput")).click();

        // Select month(s) from the calendar dropdown
        WebElement monthDD = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
        selectDdValue(monthDD, "July");      // also By Index = 9.

        // Pick year
        WebElement yearDD = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
        selectDdValue(yearDD, "2023");

        // Pick day
        List<WebElement> daysDD = driver.findElements(By.cssSelector("div.react-datepicker__week div"));
        selectDdValue(daysDD, "15");


        WebElement datePickerField = driver.findElement(By.id("datePickerMonthYearInput"));
        String pickerFieldText = datePickerField.getAttribute("value");
        System.out.println("Date picker input value: " + pickerFieldText);

        tearDown();
    }
}
