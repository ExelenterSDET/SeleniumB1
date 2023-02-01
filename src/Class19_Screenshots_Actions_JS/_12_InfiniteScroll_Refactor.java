package Class19_Screenshots_Actions_JS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

import java.util.List;

public class _12_InfiniteScroll_Refactor extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Infinite Scroll")).click();
        wait(2);

       scrollToParagraph(13);
//       scrollToParagraph2(20);

        tearDown();
    }

    public static void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor) driver;

        while (getNumberOfParagraphs() < index) {
            jsExecutor.executeScript(script); // scroll down by one <p>
        }
        System.out.println("Total paragraphs: " + getNumberOfParagraphs());
    }

    public static int getNumberOfParagraphs() {
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        return paragraphs.size();
    }

    // This second method is not universal, cannot be used everywhere, because depends on the
    // <p> element, this element locator could be different on each different page/website.
    public static void scrollToParagraph2(int index) {
        List<WebElement> paragraphs = driver.findElements(By.className("jscroll-added"));
        var jsExecutor = (JavascriptExecutor) driver;
        String script = "window.scrollTo(0, document.body.scrollHeight)";

        while (paragraphs.size() < index) {
            jsExecutor.executeScript(script);
            paragraphs = driver.findElements(By.className("jscroll-added"));
        }
        System.out.println("Total paragraphs: " + paragraphs.size());

    }



}
