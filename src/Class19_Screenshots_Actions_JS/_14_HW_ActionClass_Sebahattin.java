package Class19_Screenshots_Actions_JS;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.time.Duration;
import java.util.List;

public class _14_HW_ActionClass_Sebahattin extends BaseClass {

    /**  HW: Actions Class
     *      1. Go to exelenter.com
     *      2. Hover over the 'Courses+' menu, and a sub-menu dropdown will open
     *      3. From the sub-menu select 'Java-sdet' and click on it
     *      4. On the Java SDET page, grab the title 'SDET Automation Course'
     *      5. Open a new tab and navigate to Google homepage on this newly opened tab
     *      6. On the Google search box, type "Exelenter" +  Title (concatenate), which you copied
     from the exelenter sdet page  (Step 4)
     *      7. Press Enter, and you will be taken to the Google Search result page
     *      8. From the Search Results, loop through until you find a link with the title 'Exelenter' click on it
     *      9. Now you should end up on the exelenter.com page again.
     *      10. Quit the browser.
     */

    public static void main(String[] args) {
        setUp("https://exelenter.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement courses = driver.findElement(By.xpath("//*[@id='menu-item-8674']/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(courses).perform();
        wait(1);

        driver.findElement(By.linkText("Java-sdet")).click();
        wait(1);
        String sdetCourse = driver.findElement(By.linkText("SDET Automation Course")).getText();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com");
        wait(1);
        WebElement googleSearch = driver.findElement(By.xpath("//input[@name='q']"));
        sendText(googleSearch, sdetCourse);
        wait(1);
        googleSearch.sendKeys(Keys.ENTER);
        wait(1);

        String search = "Exelenter";
        List<WebElement> titleList = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        quit:
        for (int i = 0; i < titleList.size(); i++) {
            titleList = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
            for (WebElement title : titleList){
                String text = title.getText();
                if (text.contains(search)){
                    title.click();
                    break quit;
                }
            }
            var jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            wait(2);
        }
        String newTitleSdetCourse = driver.findElement(By.linkText("SDET Automation Course")).getText();
        if (sdetCourse.equals(newTitleSdetCourse)){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
        wait(1);
        tearDown();
    }

}
