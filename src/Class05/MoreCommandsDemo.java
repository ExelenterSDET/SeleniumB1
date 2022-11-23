package Class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoreCommandsDemo {
    private static String url ="http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
    private static String user = "Tester";
    private static String pwd = "test";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement userName = driver.findElement(By.xpath("//input[contains(@id,'username')]"));
        Thread.sleep(2000);
        userName.sendKeys("QAEngineer");
        Thread.sleep(2000);
        userName.clear();
        Thread.sleep(2000);
        userName.sendKeys(user);

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys(pwd);

        Thread.sleep(1000);
        WebElement loginBtn = driver.findElement(By.cssSelector("input.button"));
        loginBtn.click();

        // Once we are on the dashboard, lets verify it using an element from the dashboard page
        WebElement webOrdersLogo = driver.findElement(By.xpath("//ul[@id='ctl00_menu']/preceding-sibling::h1"));
        boolean logoDisplayed = webOrdersLogo.isDisplayed();

        if (logoDisplayed) {
            System.out.println("Logo is displayed. Test case passed.");
        } else {
            System.out.println("Logo is NOT displayed. Test case failed.");
        }

        // Identify logged-in user on the dashboard page
        WebElement loggedInUser = driver.findElement(By.cssSelector("div.login_info"));
        String loggedInUserText = loggedInUser.getText();

        String expectedLoggedInUserText = "Welcome, Tester! | Logout";

        if (loggedInUserText.contains(user)) {
            System.out.println("Authorized user is able to login successfully. Test Passed.");
        } else {
            System.out.println("Authorized user is NOT able to login successfully. Test Failed.");
        }
        System.out.println(loggedInUserText);


        Thread.sleep(2000);
        driver.close();
    }
}
