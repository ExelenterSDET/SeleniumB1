package Class19_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;
import utils.ConfigsReader;

public class _10_JSExecutorDemo3 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");

        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));

        sendText(username, ConfigsReader.getProperties("username"));
        sendText(password, ConfigsReader.getProperties("password"));

        wait(2);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.backgroundColor='yellow'", password);

        wait(2);


        tearDown();
    }
}
