package Class16_DevelopFunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigsReader;

import static utils.BaseClass.*;

public class _01_LoginTest {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");

        // This is without function, direct access, locate and use.
//        WebElement username = driver.findElement(By.id("txtUsername"));
//        username.sendKeys("Admin");

        // Second way, with function
        WebElement username = driver.findElement(By.id("txtUsername"));
        //sendText(username, "Admin");
        CommonMethods.sendText(username, ConfigsReader.getProperties("username"));
        
        tearDown();
    }


    /**
     *  To access method of one class from another class/package.
     *      1. import statically
     *      2. Extends nameOfCLass
     *      3. NameOfClass.method()
     */


}
