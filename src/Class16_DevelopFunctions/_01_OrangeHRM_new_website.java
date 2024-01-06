package Class16_DevelopFunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigsReader;

import static utils.BaseClass.*;

public class _01_OrangeHRM_new_website {
    public static void main(String[] args) {
        setUp("https://opensource-demo.orangehrmlive.com/");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type ='submit']"));
        loginBtn.click();

        driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]")).click();
        driver.findElement(By.linkText("Add Employee")).click();


        tearDown();
    }



}
