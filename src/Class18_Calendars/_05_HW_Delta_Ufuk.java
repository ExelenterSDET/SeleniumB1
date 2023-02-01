package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _05_HW_Delta_Ufuk extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.delta.com/flight-search/book-a-flight");

        String actualDepartDay="13";
        String actualDepartMonth="April";
        String actualDepartYear="2023";

        String actualReturnDay="15";
        String actualReturnMonth="August";
        String actualReturnYear="2023";

        //release cookie banner
        driver.findElement(By.xpath("//*[@class='cookie-close-icon float-right circle-outline']")).click();
        //click on the calendar
        driver.findElement(By.xpath("//*[@class='calDispValueCont icon-Calendar  ']")).click();

        String departureMonth = driver.findElement(By.xpath("//*[@class='dl-datepicker-month-0']")).getText();
        String departureYear = driver.findElement(By.xpath("//*[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();

        while (!(departureMonth.equals(actualDepartMonth) && (departureYear.equals(actualDepartYear)))){
            driver.findElement(By.xpath("(//*[@class='monthSelector'])[2]")).click();
            departureMonth=driver.findElement(By.xpath("//*[@class='dl-datepicker-month-0']")).getText();
            departureYear=driver.findElement(By.xpath("//*[@class='dl-datepicker-year dl-datepicker-year-0']")).getText();
        }
        List<WebElement> departureDays = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]//td"));
        for (WebElement departureDay : departureDays) {
            if(departureDay.getText().equals(actualDepartDay)){
                departureDay.click();
                System.out.println("Departure day is: "+ departureDay.getText()+" of "+departureMonth+","+departureYear);
                break;
            }
        }

        //Do everything for Return Date

        String returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();
        String returnYear = driver.findElement(By.xpath("//*[@class='dl-datepicker-year dl-datepicker-year-1']")).getText();

        while (!(returnMonth.equals(actualReturnMonth) && (returnYear.equals(actualReturnYear)))){
            driver.findElement(By.xpath("(//*[@class='monthSelector'])[2]")).click();
            returnMonth=driver.findElement(By.xpath("//*[@class='dl-datepicker-month-1']")).getText();
            returnYear=driver.findElement(By.xpath("//*[@class='dl-datepicker-year dl-datepicker-year-1']")).getText();
        }
        List<WebElement> returnDays = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[2]//td"));
        for (WebElement returnDay : returnDays) {
            if(returnDay.getText().equals(actualReturnDay)){
                System.out.println("Return day is: "+ returnDay.getText()+" of "+returnMonth+","+returnYear);
                returnDay.click();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@class='donebutton']")).click();

        tearDown();
    }
}
