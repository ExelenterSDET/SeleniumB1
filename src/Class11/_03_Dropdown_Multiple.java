package Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

import static utils.BaseClass.*;

public class _03_Dropdown_Multiple {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://selenium08.blogspot.com/2019/11/dropdown.html");

        WebElement months = driver.findElement(By.cssSelector("select[name='Month']"));
        Select select = new Select(months);

        List<WebElement> listOfMonths = select.getOptions();
        int totalMonths = listOfMonths.size();
        System.out.println("totalMonths: " + totalMonths);


        // Task: Print ALL months using  1. For Loop, 2.Enhanced Loop, 3.Iterator Loop.

        // Before looping we need to know the size/length of what we are about to loop.

        System.out.println("==== For Loop ====");
        for (int i = 1; i < totalMonths; i++) {
            String month = listOfMonths.get(i).getText();
            System.out.println(month);
        }

        System.out.println("==== Enhanced Loop ====");
        for (WebElement month : listOfMonths) {
            System.out.println(month.getText());
        }

        System.out.println("==== Iterator ====");
        Iterator<WebElement> iterator = listOfMonths.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getText());
        }

        // Task 2: Print Only a specific (selected) months from the list. For example, March, May and September.
        // Hint: we can use loop or we can use one of existing Select class methods such as byVisibleText(), by index/value.

        // 1st way: without Select
//        for (WebElement month : listOfMonths) {
//            if (month.getText().equals("March") || month.getText().equals("May") || month.getText().equals("September")) {
//                month.click();
//                //break;      // if you use 'if' don't use 'break', if you use 'while' then you can use 'break' to exit the code.
//            }
//        }

        // 2nd way:
        if (select.isMultiple()) {
            select.selectByIndex(3);              // March
            select.selectByVisibleText("May");     // May
            select.selectByValue("Sept");         // September
            Thread.sleep(2000);
            select.deselectByIndex(3);            // Deselect month of March
            Thread.sleep(2000);
            select.deselectAll();
        }







        tearDown();
    }
}
