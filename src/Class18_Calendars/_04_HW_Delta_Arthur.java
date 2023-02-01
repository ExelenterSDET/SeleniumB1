package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _04_HW_Delta_Arthur extends BaseClass {
    public static void main(String[] args) {
        setUp("http://www.delta.com/");
        boolean dateFound = false;
        driver.findElement(By.cssSelector("span.calenderDepartSpan")).click();

//        Select departure as April 13, 2023
        String depMonth = "April";
        String depDay = "13";
        String depYear = "2023";

        String retMonth = "August";
        String retDay = "15";
        String retYear = "2023";


        String firstMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
        String firstYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();

        while (!dateFound) {
            if (firstMonth.equals(depMonth) && firstYear.equals(depYear)) {
                //pick day
                List<WebElement> elements = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td/a"));
                for (WebElement element : elements) {
                    System.out.println(element.getText());
                    if (element.getText().equals(depDay)) {
                        element.click();
                        driver.findElement(By.cssSelector("button.donebutton")).click();
                        dateFound = true;
                        break;
                    }
                }

            } else {
                firstMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
                firstYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();
                driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click();
            }

        }

        wait(10);
        System.out.println("return");
        driver.findElement(By.xpath("//span[@class='calenderReturnSpan calendar-placeholder']")).click();

        wait(10);

        firstMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
        firstYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();

        dateFound = false;
        while (!dateFound) {
            if (firstMonth.equals(retMonth) && firstYear.equals(retYear)) {
                //pick day
                List<WebElement> elements = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td/a"));
                for (WebElement element : elements) {
                    System.out.println(element.getText());
                    if (element.getText().equals(retDay)) {
                        element.click();
                        driver.findElement(By.cssSelector("button.donebutton")).click();
                        break;
                    }
                }
            } else {
                firstMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
                firstYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();
                driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click();
            }


        tearDown();

        }


    }
}
