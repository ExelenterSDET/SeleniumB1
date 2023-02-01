package Class20_POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.driver;

// Note: This is just a template for LoginPage where we store everything related to Login page here, in this class.
//  In Page Object Model (Design Pattern), we organize our code by pages. Each web page will have their own class.
public class _01_LoginPageWithoutPageFactory {
    // LoginPage without using PageFactory
    public WebElement username = driver.findElement(By.id("txtUsername"));
    public WebElement password = driver.findElement(By.id("txtPassword"));
    public WebElement loginBtn = driver.findElement(By.id("btnLogin"));
    public WebElement homepageLogo = driver.findElement(By.cssSelector("#divLogo img"));
}
