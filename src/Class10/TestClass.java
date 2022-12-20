package Class10;

import utils.BaseClass;

import static utils.BaseClass.*;

public class TestClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com");      // <--- Launch the browser.

        System.out.println(driver.getTitle());   // <--- Perform an action on the browser (actual Testing).

        tearDown();                              // <--- Quit the browser.
    }
}

