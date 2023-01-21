package Class17_WebTables;

import utils.BaseClass;

/**
 * HW: Test Case: Add and then Delete added employee from the table
 * 1. Open Chrome Browser
 * 2. Navigate to URL www.exelentersdet.com
 * 3. Login to the website (Credentials are in your Properties file)
 * 4. Add an employee
 * 5. Verify employee has been added (By retrieving Employee ID).
 * 6. Go to Employee list
 * 7. Delete added employee (By employee ID - ID is unique, could be multiple employees with same name)
 * 8. Quit the browser
 */
public class _05_HW_AddAndDeleteEmployee extends BaseClass {
    public static void main(String[] args) {
        setUp("https://www.exelentersdet.com/");

        // HW Code goes here.

        tearDown();
    }
}
