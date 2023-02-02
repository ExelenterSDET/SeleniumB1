package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utils.BaseClass.*;

// TASK: Go to this website https://vitalets.github.io/combodate/
//  and select your DOB (example: DD/MM/YYYY, "25/04/1985"), and exit the browser
public class _05_DropdownDDMMYYYY_Refactor2 {

    public static void main(String[] args) {
        setUp("https://vitalets.github.io/combodate/");
        findDate(8,"30", "2014");       // <--- THIS IS CALLED CLEAN CODING. All distractions are hidden elsewhere.
        tearDown();
    }



    static void findDate(int month, String day, String year) { // US Date format MM/DD/YYYY, Rest of the world: DD/MM/YYYY
        WebElement monthDD = driver.findElement(By.xpath("(//select[@class='month '])[1]"));
        Select selectMonthDD = new Select(monthDD);
        selectMonthDD.selectByIndex(month);
        System.out.println(month);

        WebElement dayDD = driver.findElement(By.xpath("(//select[@class='day '])[1]"));
        Select selectDayDD = new Select(dayDD);
        selectDayDD.selectByVisibleText(day);
        System.out.println(day);

        WebElement yearDD = driver.findElement(By.xpath("(//select[@class='year '])[1]"));
        Select selectYearDD = new Select(yearDD);
        selectYearDD.selectByValue(year);
        System.out.println(year);
    }

}
