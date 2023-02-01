package Class20_POM.test;

import Class20_POM.pages._01_LoginPageWithoutPageFactory;
import Class20_POM.pages._02_LoginPageWithPageFactory;
import utils.BaseClass;
import utils.ConfigsReader;

public class _01_LoginTest extends BaseClass {
    public static void main(String[] args) {
        setUp("https://exelentersdet.com/");
// Note: Make sure you comment out one before using the other.
        // Without PageFactory
//        var loginPage = new _01_LoginPageWithoutPageFactory();
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password, ConfigsReader.getProperties("password"));
//        click(loginPage.loginBtn);

        // With PageFactory
        var login = new _02_LoginPageWithPageFactory();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        click(login.loginBtn);

        tearDown();
    }
}
