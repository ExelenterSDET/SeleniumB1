package Class19_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

import java.util.List;

public class _13_HW_ActionClass_Tohir extends BaseClass {

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

        //Navigate to exelenter
        setUp("https://www.exelenter.com");
        Actions actions = new Actions(driver);

        //Hover over the 'Courses+' menu, and a sub-menu dropdown will open
        WebElement courseMenu = driver.findElement(By.xpath("(//span[text()='Courses'])[1]"));
        actions.moveToElement(courseMenu).perform();

        //From the sub-menu select 'Java-sdet' and click on it

        driver.findElement(By.xpath("//li[@id='menu-item-9053']/a")).click();
        wait(1);

        String textFromSDET = driver.findElement(By.xpath("//div[@class='ct-title1 style4']/h3")).getText();
        System.out.println(textFromSDET);
        wait(1);


        //Open a new tab and navigate to Google homepage on this newly opened tab
        driver.navigate().to("https://google.com");
        wait(1);

        //On the Google search box, type "Exelenter" +  Title (concatenate), which you copied from the exelenter sdet page  (Step 4),
        //Press Enter, and you will be taken to the Google Search result page
        driver.findElement(By.name("q")).sendKeys(("Exelenter "+textFromSDET)+ Keys.ENTER);
        wait(1);

        //From the Search Results, loop through until you find a link with the title 'Exelenter' click on it

        List<WebElement> results = driver.findElements(By.xpath("//div/a/h3"));
        for (WebElement result : results) {
            if (result.getText().contains("Exelenter")){
                result.click();
                break;
            }
        }

        wait(1);
        tearDown();
    }
}
