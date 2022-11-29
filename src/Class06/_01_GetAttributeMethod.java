package Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_GetAttributeMethod {
    private static String url = "https://exelentersdet.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement username = driver.findElement(By.name("txtUsername")); // <--- First we identify web element and store it with a name

        String id = username.getAttribute("id"); // <--- This will retrieve value for the attribute 'id'.
        System.out.println("id = " + id);

        System.out.println("type = " + username.getAttribute("type"));

        username.sendKeys("Tester");
        String value = username.getAttribute("value");
        System.out.println("value = " + value);


        Thread.sleep(2000);
        driver.close();

    }
}
