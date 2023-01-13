package Class16_DevelopFunctions;

import org.openqa.selenium.By;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;


public class _06_AlertTest {
    public static void main(String[] args)  {
        setUp("https://selenium08.blogspot.com/2019/07/alert-test.html");

        driver.findElement(By.id("simple")).click();
        //driver.findElement(By.cssSelector(".header-widget div a")).click();  // Clicks on Selenium menu, which will cause NoAlertException.
        waitInSeconds(1);
        System.out.println(getAlertText());
        acceptAlert();

        waitInSeconds(2);

        driver.findElement(By.id("confirm")).click();
        waitInSeconds(1);
        System.out.println(getAlertText());
        dismissAlert();

        waitInSeconds(2);

        driver.findElement(By.id("prompt")).click();
        waitInSeconds(1);
        sendAlertText("Said");
        waitInSeconds(1);
        System.out.println(getAlertText());
        acceptAlert();


        tearDown();
    }
}
