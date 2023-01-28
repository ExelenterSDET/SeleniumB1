package Class19_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseClass;

public class _07_ActionsDragAndDrop extends BaseClass {
    public static void main(String[] args) {
        setUp("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        // 1st way
        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();  // works without adding .build() as well.

        wait(2);
        driver.navigate().refresh();   // after this refresh, above elements get detached from the DOM, you must relocate/reassign them before you could use them again.
        wait(2);

        // 2nd way
        draggable = driver.findElement(By.id("draggable"));  // in other words, we are attaching them again to the DOM.
        droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, droppable).perform();

        tearDown();
    }
}
