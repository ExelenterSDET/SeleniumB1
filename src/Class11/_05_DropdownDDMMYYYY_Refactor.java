package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

// TASK: Go to this website https://vitalets.github.io/combodate/
//  and select your DOB (example: DD/MM/YYYY, "25/04/1985"), and exit the browser
public class _05_DropdownDDMMYYYY_Refactor {

    public static void main(String[] args) {
        setUp();
        findDay("20");
        findMonth(5);
        findYear("1995");
        selectDay("25");
        tearDown();
    }




    /**
     *
     * @param day String
     * @return day
     */
    static String findDay(String day) {
        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        Select selectDayDD = new Select(dayDD);
        selectDayDD.selectByVisibleText(day);
        System.out.println(day);
        return day;
    }

    /**
     *
     * @param month int (index of given month)
     * @return month
     */
    static int findMonth(int month) {
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        Select selectMonthDD = new Select(monthDD);
        selectMonthDD.selectByIndex(month);
        System.out.println(month);
        return month;
    }

    /**
     * This method accepts year as String and returns the given year
     * @param year String
     * @return year
     */
    static String findYear(String year) {
        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));
        Select selectYearDD = new Select(yearDD);
        selectYearDD.selectByValue(year);
        System.out.println(year);
        return year;
    }

    /**
     *
     * @param pickDay String
     * @return day from the DD
     */
    static String selectDay(String pickDay) {
        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        Select selectDayDD = new Select(dayDD);
        List<WebElement> dayList = selectDayDD.getOptions();
        for (WebElement day : dayList) {
            day.click();
            String dayText = day.getText();
            if (dayText.equals(pickDay)) {
                System.out.println("Date is found: " + dayText);
                break;
            }
        }
        return pickDay;
    }

}
