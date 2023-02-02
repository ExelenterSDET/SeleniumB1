package Class18_Calendars;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseClass;

import java.util.List;

public class _07_HW_AA_Arthur extends BaseClass {
    public static void main(String[] args) {
        setUp(" https://www.aa.com/");
        driver.findElement(By.id("cookieBannerClose")).click();
//        Select departure as April 13, 2023
        boolean dateFound = false;
        String depMonth = "April";
        String depDay = "13";
        String depYear = "2023";

        String retMonth = "August";
        String retDay = "15";
        String retYear = "2023";

        driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
        wait(3);
        WebElement countryCode = driver.findElement(By.id("countryCode"));
        Select select = new Select(countryCode);
        List<WebElement> country = select.getOptions();
        for (WebElement element : country) {
            if (element.getText().equals("United States"))
                element.click();
        }
        wait(3);
        //state click
        WebElement stateCode = driver.findElement(By.id("stateCode"));

        Select selectState = new Select(stateCode);
        List<WebElement> state = selectState.getOptions();
        for (WebElement elementS : state) {

            if (elementS.getText().equals("California")) {
                elementS.click();
                break;
            }

        }
        wait(3);
//        List<WebElement> airportCodes = driver.findElements(By.xpath("//tbody[@id='airportList']/tr/td/a/span"));
        List<WebElement> airportCodes = driver.findElements(By.xpath("//tbody[@id='airportList']/tr/td/a/span[@class='airport-code']"));

        wait(3);
        for (int i = 0; i < airportCodes.size(); i++) {
            if (airportCodes.get(i).getText().equals("LAX")) {
                airportCodes.get(i).click();
                break;
            }
        }

        System.out.println("return");
        WebElement searchMagnifierIcon = driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]"));// Click on the 'Search' icon
        //searchMagnifierIcon.click();  // This is regular Selenium click which didn't work. we get ElementClickInterceptedException
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].click();", searchMagnifierIcon);
        jsClick(searchMagnifierIcon);

        countryCode = driver.findElement(By.id("countryCode"));
        select = new Select(countryCode);
        country = select.getOptions();
        for (WebElement element : country) {
            if (element.getText().equals("United States")) {
                element.click();
                break;
            }
        }

        //state click
        stateCode = driver.findElement(By.id("stateCode"));

        selectState = new Select(stateCode);
        state = selectState.getOptions();
        for (WebElement elementS : state) {
            System.out.println(elementS.getText());
            if (elementS.getText().equals("New York")) {
                elementS.click();
                break;
            }
        }
//        airportCodes = driver.findElements(By.xpath("//tbody[@id='airportList']/tr/td/a/span"));
        airportCodes = driver.findElements(By.xpath("//tbody[@id='airportList']/tr/td/a/span[@class='airport-code']"));

        for (int i = 0; i < airportCodes.size(); i++) {
            if (airportCodes.get(i).getText().equals("JFK")) {
                airportCodes.get(i).click();
            }
        }
//choose number of passengers

        WebElement numPsg = driver.findElement(By.xpath("//select[@name='adultOrSeniorPassengerCount']"));

        Select psgList = new Select(numPsg);
        List<WebElement> options = psgList.getOptions();
        for (WebElement n : options) {
            System.out.println(n.getText());
            if (n.getText().equals("2")) {
                System.out.println("got inside if");
                System.out.println("select 2");
                n.click();
                break;
            }
        }
// choose departure and return dates

        //calendar test
        wait(2);
        driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger'][1]")).click();

        String dMonth = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[1]")).getText();
        String dYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[2]")).getText();
        wait(2);
        while (!dateFound) {
            System.out.println("inside loop");
            if (dMonth.equals(depMonth) && dYear.equals(depYear)) {
                //pick day
                List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td"));
                for (WebElement element : elements) {
                    System.out.println(element.getText());
                    if (element.getText().equals(depDay)) {
                        element.click();
//                        driver.findElement(By.cssSelector("button.donebutton")).click();
                        dateFound = true;
                        break;
                    }
                }

            } else {
                driver.findElement(By.xpath("//a[@data-handler='next']")).click();
                dMonth = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[1]")).getText();
                dYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[2]")).getText();

            }
        }
        wait(3);
        //choose return
        driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();

        String rMonth = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[1]")).getText();
        String rYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[2]")).getText();
        wait(2);
        dateFound = false;
        while (!dateFound) {
            System.out.println("inside loop2");

            if (rMonth.equals(retMonth) && rYear.equals(retYear)) {
                //pick day
                System.out.println("retMonth");
                List<WebElement> elements = driver.findElements(By.xpath("//table/tbody/tr/td"));
                for (WebElement element : elements) {
//                    System.out.println(element.getText());
                    if (element.getText().equals(retDay)) {
                        element.click();
//                        driver.findElement(By.cssSelector("button.donebutton")).click();
                        wait(2);
                        driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']")).click();
                        dateFound = true;
                        break;
                    }
                }

            } else {
                System.out.println("hello");
                driver.findElement(By.xpath("//a[@data-handler='next']")).click();
                rMonth = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[1]")).getText();
                rYear = driver.findElement(By.xpath("(//div[@class='ui-datepicker-title'])[1]/span[2]")).getText();
            }
        }

        tearDown();
    }
}
