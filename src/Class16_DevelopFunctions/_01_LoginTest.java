package Class16_DevelopFunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigsReader;

import static utils.BaseClass.*;
import static utils.CommonMethods.*;

public class _01_LoginTest {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");

        // First way, without function, direct access, locate and use.
//        WebElement username = driver.findElement(By.id("txtUsername"));
//        username.sendKeys("Admin");

        // Second way, with function, call method from different class.
        WebElement username = driver.findElement(By.id("txtUsername"));
        //sendText(username, "Admin");
        sendText(username, ConfigsReader.getProperties("username"));

        WebElement password = driver.findElement(By.id("txtPassword"));
        sendText(password, ConfigsReader.getProperties("password"));

        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        //CommonMethods.click(loginBtn);
        clickButWaitForClickability(loginBtn);

        tearDown();
    }



}
