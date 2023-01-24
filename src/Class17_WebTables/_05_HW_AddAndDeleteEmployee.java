package Class17_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseClass;
import utils.ConfigsReader;

import java.util.List;

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

        String firstName = "John";
        String lastName = "Doe";
        //Login to web application
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperties("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperties("password"));
        clickButWaitForClickability(driver.findElement(By.id("btnLogin")));
        wait(1);

        // Navigate to PIM page (where 'Add employee' is located)
        driver.findElement(By.linkText("PIM")).click();
        wait(1);
        driver.findElement(By.linkText("Add Employee")).click();

        // Add Employee
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        // Get employee ID before you click 'Save' button (because we need it later for verification).
        String employeeID = driver.findElement(By.id("employeeId")).getAttribute("value");   // Retrieving employee ID and store it in a String

        // Identify web element for 'Save' button and click on it
        driver.findElement(By.id("btnSave")).click();
        wait(1);

        // Once you click on Save button, takes you to Details Page --> verify employee is added.
        String addedEmployeeFullName = driver.findElement(By.cssSelector("div#profile-pic h1")).getText();
        if (addedEmployeeFullName.equals(firstName + " " + lastName))
            System.out.println("Employee is added successfully");
        else
            System.out.println("Employee is NOT added");

        // From Employee Details Page, navigate to Employee List
        driver.findElement(By.linkText("Employee List")).click();
        wait(1);

        // Delete added employee from the Employee List Table
        // On the Employee List Page, loop through the table rows and find added employee and delete it.
        boolean found = false;
        while (!found){
            List<WebElement> rows = driver.findElements(By.cssSelector("div#tableWrapper tbody tr"));   // Get number of rows per page.
            for (int i = 0; i < rows.size(); i++) {
                String empID = driver.findElement(By.cssSelector("table#resultTable tbody tr:nth-child(" + (i+1) + ") td:nth-child(2)")).getText();
                if (rows.get(i).getText().equals(empID)) {
                    found = true;
                    // Select checkbox next to employee and click on delete button
                    driver.findElement(By.cssSelector("table#resultTable tbody tr:nth-child(" + i + ") td:nth-child(1)")).click();  // click the checkbox
                    wait(1);
                    driver.findElement(By.id("btnDelete")).click();  // Locate element for 'delete' button and click on it
                    wait(1);
                    driver.findElement(By.id("dialogDeleteBtn")).click();  // Click on the second delete button (html alert/dialog)
                    wait(1);
                    System.out.println("Employee " + firstName + " " + lastName + " with employee ID: " + employeeID + " has been deleted"); // Optionally, add confirmation message.
                    break;
                }
            }
            wait(1);
            driver.findElement(By.linkText("Next")).click();  // Click on the 'Next' arrow button.
        }

        tearDown();
    }
}
