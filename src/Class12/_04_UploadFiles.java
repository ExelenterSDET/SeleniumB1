package Class12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.BaseClass.*;

public class _04_UploadFiles {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/upload");

        /**
         *  How do we upload files using Selenium?
         *  1. Specify file location - get full path of the file you are about to upload
         *  2. Locate web element for 'Choose file' button, and using sendKeys() method, send the location/full path of the file.
         *  3. Locate 'Upload' button element and click it to upload your file
         *
         *      This way we bypass the window popup, which is not supported by Selenium. (Just like we did with Authentication Alert)
         *
         */

        // Step 1. Find the file path in your local machine, and store it in a String
        String filePath = "/Users/shahnoza/Desktop/fileUploadDemo.jpg";

        // Step 2. Locate web element for the 'Choose file' button (Button which triggers Window Popup for file upload)
        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        // Step 3. Locate web element for 'Submit' or 'Upload' button and click on it to upload your file
        driver.findElement(By.id("file-submit")).click();

        // Now, let's verify if file is uploaded or not
        WebElement fileUploadConfirmation = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        if (fileUploadConfirmation.isDisplayed())
            System.out.println("File is uploaded successfully.");
        else
            System.out.println("File is NOT uploaded.");


        tearDown();
    }
}
