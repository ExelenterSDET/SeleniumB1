package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _09_HW_AA_Bahodur extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.aa.com/");

        String departureMonth = "June 2023";
        String departureDate = "15";
        String returnMonth = "July 2023";
        String returnDate = "26";
        String numberForPassenger = "2";

        WebElement fromInput = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
        sendText(fromInput, "LAX");
        WebElement laxAirport = driver.findElement(By.id("ui-id-1"));
        clickButWaitForClickability(laxAirport);

        WebElement destinationInput = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
        sendText(destinationInput,"JFK");
        WebElement jfkAirport = driver.findElement(By.id("ui-id-2"));
        clickButWaitForClickability(jfkAirport);

        WebElement numberOfPassenger = driver.findElement(By.id("flightSearchForm.adultOrSeniorPassengerCount"));
        selectDdValue(numberOfPassenger, numberForPassenger);

        WebElement departureCalender = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]"));
        clickButWaitForVisibility(departureCalender);

        String monthAndYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[2]")).getText();
        while (!monthAndYear.equals(departureMonth)){

            WebElement nextMonth = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
            clickButWaitForClickability(nextMonth);
            monthAndYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[2]")).getText();
        }

        List<WebElement> fromDates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//a[@class='ui-state-default']"));
        for (int i = 0; i < fromDates.size(); i++) {
            if(fromDates.get(i).getText().equals(departureDate)){
                System.out.println("Departure : " + monthAndYear + " " + fromDates.get(i).getText());
                clickButWaitForClickability(fromDates.get(i));
                break;
            }
        }

        WebElement returnCalender = driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]"));
        clickButWaitForVisibility(returnCalender);

        monthAndYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[2]")).getText();
        while (!monthAndYear.equals(returnMonth)){
            wait(2);
            WebElement nextMonth = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
            clickButWaitForClickability(nextMonth);
            monthAndYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[2]")).getText();
        }

        List<WebElement> toDates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//a[@class='ui-state-default']"));
        for (int i = 0; i < toDates.size(); i++) {
            if(toDates.get(i).getText().equals(returnDate)){
                System.out.println("Return : " + monthAndYear + " " + toDates.get(i).getText());
                clickButWaitForClickability(toDates.get(i));
                break;
            }
        }

        WebElement btnSearch = driver.findElement(By.id("flightSearchForm.button.reSubmit"));
        wait(2);
        clickButWaitForClickability(btnSearch);

        try {
            WebElement choseFlight = driver.findElement(By.xpath("//ul[@class='search-results-normal js-forsort']"));
            waitForVisibilityOfElement(By.xpath("//ul[@class='search-results-normal js-forsort']"));
            //screenshot(choseFlight, "choseFlights");
            System.out.println("Successfully able to see flight");
        }catch (Exception exception){
            exception.printStackTrace();
            System.out.println("Flights are not available check the code");
        }
        tearDown();
    }
}
