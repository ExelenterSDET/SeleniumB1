package Class20_POM.test;

import Class20_POM.pages._01_LoginPageWithoutPageFactory;
import Class20_POM.pages._02_LoginPageWithPageFactory;
import utils.BaseClass;
/**
 * Task: Exelenter Project Logo Validation
 *      1. Navigate to URL https://www.exelentersdet.com
 *      2. Verify Logo is displayed (No need to login)
 *      3. Quit the browser.
 *
 *      You can use LoginPage for storing logo's web element and create a
 *      new LogoTest class for testing.
 */
public class _02_LogoTest_Task extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");

        // without page factory
//        var loginPage = new _01_LoginPageWithoutPageFactory();
//        boolean homepageLogoDisplayed = loginPage.homepageLogo.isDisplayed();
//        if (homepageLogoDisplayed)
//            System.out.println("Logo is displayed");
//        else
//            System.out.println("Logo is not displayed");

        // with PageFactory
        var loginWithPF = new _02_LoginPageWithPageFactory();
        boolean logoDisplayed = loginWithPF.homepageLogo.isDisplayed();
        if (logoDisplayed)
            System.out.println("Logo is displayed");
        else
            System.out.println("Logo is not displayed");


        tearDown();
    }
}
