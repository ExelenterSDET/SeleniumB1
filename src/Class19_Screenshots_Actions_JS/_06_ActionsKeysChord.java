package Class19_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.BaseClass;

public class _06_ActionsKeysChord extends BaseClass {
    public static void main(String[] args) {
        setUp("https://google.com");

        wait(1);
        driver.findElement(By.name("q")).sendKeys("Exelenter SDET");
        wait(1);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        // another way to do above action
        driver.navigate().back();
        wait(2);

        // this is shorter way, on one line.
        driver.findElement(By.name("q")).sendKeys("Exelenter SDET", Keys.ENTER);

        driver.navigate().back();
        wait(2);

        // another way, 3rd way
        driver.findElement(By.name("q")).sendKeys(Keys.chord("Exelenter SDET", Keys.ENTER));



        tearDown();
    }
}
