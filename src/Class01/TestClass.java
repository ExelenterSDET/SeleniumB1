package Class01;

public class TestClass {

    public static void main(String[] args) {

        ParentBrowser chrome = new ChromeBrowser();
        chrome.goTo("https://www.google.com");
        chrome.getTitle();
        chrome.close();

        System.out.println("-----------------");

        ParentBrowser firefox = new FirefoxBrowser();
        firefox.goTo("https://www.google.com");
        firefox.getTitle();
        firefox.close();

    }

}
