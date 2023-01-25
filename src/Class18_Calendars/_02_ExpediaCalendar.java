package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _02_ExpediaCalendar extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.expedia.com/Flights");  // or remove /Flights from the URL.

        /*
            Let's say we want to pick  for
            Depart: May 17th, 2023
            Return: July 26th, 2023
         */
        String departMonthAndYear = "May 2023";
        String departDay = "8";
        String returnMonthAndYear = "September 2023";
        String returnDay = "17";

        // Click on the 'Departing' field/button to pop the calendar
        driver.findElement(By.cssSelector("h1[class='uitk-heading uitk-heading-3']")).click(); // Click elsewhere for the alert to go away.
        driver.findElement(By.id("d1-btn")).click();

        // From the opened Calendar, find Month and Year and store it in a String for later use
        String monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();

        while (!monthAndYear.equals(departMonthAndYear)) {   // validation line
            driver.findElement(By.cssSelector(".uitk-calendar button:nth-child(2)")).click();  // Click on the Next button
            wait(1);
            // When we click Next Button it is no longer 'February 2023', it is 'March 2023' , so we need to reassign again, store it again for validation inside while loop
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();
        }

        // Once you are on the desired element (expected Month and Year), loop though the days (td) and get the text/value
        List<WebElement> days = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]//button"));
        for (WebElement day : days) {
            if (day.getAttribute("data-day").equals(departDay)){
                System.out.println("Your itinerary details:");
                System.out.println("Departure: " + day.getAttribute("data-day") + " of " + monthAndYear);  // Departing: 15 of August 2023
                day.click();
                break;
            }
        }

        wait(1);

        // Selecting month and year, again, for Return
        while (!monthAndYear.equals(returnMonthAndYear)) {   // validation line
            driver.findElement(By.cssSelector(".uitk-calendar button:nth-child(2)")).click();  // Click on the Next button
            wait(1);
            // When we click Next Button it is not longer 'February 2023', it is 'March 2023' , so we need reassign again, store it again for validation
            monthAndYear = driver.findElement(By.xpath("(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")).getText();
        }

        // Selecting day for return
        days = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]//button"));
        for (WebElement day : days) {
            if (day.getAttribute("data-day").equals(returnDay)){
                System.out.println("Return: " + day.getAttribute("data-day") + " of " + monthAndYear);
                day.click();
                break;
            }
        }

        wait(1);

        // Once Depart and Return dates are selected, click on the 'Done' button
        driver.findElement(By.xpath("(//button[text()='Done'])[2]")).click();

        tearDown();
    }
}
