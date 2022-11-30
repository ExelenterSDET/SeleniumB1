package Class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_RadioDemo {
    private static String url = "https://formstone.it/components/checkbox/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver"); // window users add '.exe' at the end
        WebDriver driver = new ChromeDriver();
        driver.get(url);


        // Checkbox One
        WebElement checkboxOne = driver.findElement(By.cssSelector("input#checkbox-1"));
        boolean checkboxOneSelected = checkboxOne.isSelected();
        System.out.println("Checkbox One is Selected = " + checkboxOneSelected);  // true

        // Checkbox Two
        WebElement checkboxTwo = driver.findElement(By.xpath("(//input[@class='fs-checkbox-element'])[2]"));
        boolean checkboxTwoEnabled = checkboxTwo.isEnabled();
        System.out.println("Checkbox Two is Enabled = " + checkboxTwoEnabled); // true

        // Find the checkbox 'Three' and verify if it is enabled or not.
        WebElement checkboxThree = driver.findElement(By.cssSelector("input#checkbox-3"));
        boolean checkboxThreeEnabled = checkboxThree.isEnabled();
        System.out.println("Checkbox Three is Enabled = " + checkboxThreeEnabled); // true or false


        Thread.sleep(2000);
        driver.close();

    }
}
