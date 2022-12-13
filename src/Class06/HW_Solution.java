package Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;
 /*
         *  HW: Checkboxes & Radio Buttons
         *   1. Go to https://the-internet.herokuapp.com/
         *   2. Find the Checkboxes link, click on it
         *   3. Once you are on the Checkboxes homepage you will see two Checkboxes:
         *       - checkbox 1
         *       - checkbox 2
         *
         *   4. Using your Selenium knowledge. Please check and verify if each checkbox is:
         *         1. isDisplayed (True or False) ?
         *         2. isEnabled (T or F) ?
         *         3. isSelected (T or F) ?
         *
         *   5. Print the results to the console.
         *   6. Exit the browser.
         *
         * */

public class HW_Solution {
    public static void main(String[] args) {
        setUp();

        driver.findElement(By.linkText("Checkboxes")).click();

        WebElement checkbox1 = driver.findElement(By.xpath("//form/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form/input[2]"));

        System.out.println("checkbox1 is Displayed: " + checkbox1.isDisplayed()
                         + "\ncheckbox1 is Enabled: " + checkbox1.isEnabled()
                         + "\ncheckbox1 is Selected: " + checkbox1.isSelected());

        System.out.println("----------------------");

        System.out.println("checkbox2 is Displayed: " + checkbox2.isDisplayed()
                         + "\ncheckbox2 is Enabled: " + checkbox2.isEnabled()
                         + "\ncheckbox2 is Selected: " + checkbox2.isSelected());


        tearDown();
    }
}
