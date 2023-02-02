package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.BaseClass;

import java.time.Duration;
import java.util.List;

public class _08_HW_AA_Ufuk extends BaseClass {
    public static void main(String[] args) {
        setUp(" https://www.aa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //release cookise
        driver.findElement(By.id("cookieBannerClose")).click();

        //fist locate "From" element and then clear its content with action then sent to its new content that you want

        WebElement inputFrom = driver.findElement(By.xpath("//*[@id='reservationFlightSearchForm.originAirport']"));
        wait(1);

        Actions actions = new Actions(driver);
        inputFrom.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        inputFrom.sendKeys("LAX");

        //second locate "To" element and clear its content and sent to its new content
        WebElement inputTo = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
        inputTo.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        inputTo.sendKeys("JFK");
        wait(1);

        //Number of passenger from a dropdown by using Select
        WebElement numOfPassDD = driver.findElement(By.xpath("//*[@name='adultOrSeniorPassengerCount']"));
        Select select = new Select(numOfPassDD);
        select.selectByVisibleText("2");
        wait(1);

        //Initiate Depart Calender and choose date
        driver.findElement(By.xpath("(//*[@class='ui-datepicker-trigger'])[1]")).click(); //click date
        String month = driver.findElement(By.xpath("(//*[@class='ui-datepicker-month'])[1]")).getText();
        String year = driver.findElement(By.xpath("(//*[@class='ui-datepicker-year'])[1]")).getText();

        while (!(month.equals("March") && year.equals("2023"))) {
            driver.findElement(By.xpath("//*[@data-handler='next']")).click();
            wait(1);
            month = driver.findElement(By.xpath("(//*[@class='ui-datepicker-month'])[1]")).getText();
            year = driver.findElement(By.xpath("(//*[@class='ui-datepicker-year'])[1]")).getText();
        }

        List<WebElement> days = driver.findElements(By.xpath("(//*[@class='ui-datepicker-calendar'])[1]//a"));
        for (WebElement day : days) {
            if (day.getText().equals("1")) {
                System.out.println("Departure day is: " + day.getText() + " of " + month + "," + year);
                day.click();
                break;
            }
        }

        //Select arrival date
        driver.findElement(By.xpath("(//*[@class='ui-datepicker-trigger'])[2]")).click();
        while (!(month.equals("April") && year.equals("2023"))) {
            driver.findElement(By.xpath("//*[@data-handler='next']")).click();
            month = driver.findElement(By.xpath("(//*[@class='ui-datepicker-month'])[1]")).getText();
            year = driver.findElement(By.xpath("(//*[@class='ui-datepicker-year'])[1]")).getText();
        }
        days = driver.findElements(By.xpath("(//*[@class='ui-datepicker-calendar'])[1]//a"));
        for (WebElement day : days) {
            if (day.getText().equals("15")) {
                System.out.println("Arrival day is: " + day.getText() + " of " + month + "," + year);
                day.click();
                break;
            }
        }

        //click search button
        driver.findElement(By.xpath("//*[@id='flightSearchForm.button.reSubmit']")).click();
        wait(30);

//        ((//ul[@class='search-results-normal js-forsort']/li)[1]/div[1]/div[2]//button)[1]

        List<WebElement> airlines = driver.findElements(By.xpath("(//ul[@class='search-results-normal js-forsort']/li)"));
        System.out.println("economyClassPrices");
        System.out.println("===================");
        for (int i = 0; i < airlines.size(); i++) {
            String economyClassPrices = driver.findElement(By.xpath("((//ul[@class='search-results-normal js-forsort']/li)[" + (i + 1) + "]/div[1]/div[2]//button)[1]")).getAttribute("data-fare-amount");
            System.out.println(economyClassPrices);
        }
//        (//ul[@class='search-results-normal js-forsort']/li)/div[1]/div[1]/div[1]/div[4]/div[1]

        tearDown();
    }
}
