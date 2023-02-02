package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _04_HW_Delta_Arthur extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.delta.com/flight-search/book-a-flight");
        boolean dateFound = false;
        driver.findElement(By.cssSelector("span.calenderDepartSpan")).click();
//        Select departure as April 13, 2023
        String depMonth = "April";
        String depDay = "13";
        String depYear = "2023";
        String retMonth = "August";
        String retDay = "15";
        String retYear = "2023";

        String leftTableMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
        String leftTableYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();

        while (!dateFound) {
            if (leftTableMonth.equals(depMonth) && leftTableYear.equals(depYear)) {
                //pick day
                System.out.println("Itinerary Details:");
                List<WebElement> elements = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td"));
                for (WebElement element : elements) {
                    if (element.getText().equals(depDay)) {
                        System.out.println("Departure Month Day Year: " + leftTableMonth + " " + element.getText() + " " + leftTableYear);
                        element.click();
                        wait(2);
                        driver.findElement(By.cssSelector("button.donebutton")).click();
                        dateFound = true;
                        break;
                    }
                }


            } else {
                driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click();
                leftTableMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
                leftTableYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();
            }
        }

        driver.findElement(By.id("input_returnDate_1")).click();

//        wait(10);

        leftTableMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
        leftTableYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();

        dateFound = false;
        while (!dateFound) {
            if (leftTableMonth.equals(retMonth) && leftTableYear.equals(retYear)) {
                //pick day
                List<WebElement> days = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']//td/a"));
                for (WebElement day : days) {
                    if (day.getText().equals(retDay)) {
                        System.out.println("Return Month Day Year: " + leftTableMonth + " " + day.getText() + " " + leftTableYear);
                        day.click();

                        wait(3);
                        driver.findElement(By.cssSelector("button.donebutton")).click();
                        dateFound = true;
                        break;
                    }
                }

            } else {
                driver.findElement(By.xpath("(//span[@class='monthSelector'])[2]")).click();
                leftTableMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
                leftTableYear = driver.findElement(By.xpath("//span[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();
            }
        }
        tearDown();
    }
}
