package Class01.howWebDriverWorks;

import java.net.URL;

public class ChromeBrowser implements ParentBrowser {
    public ChromeBrowser(){
        System.out.println("Starting Chrome browser...");
    }

    @Override
    public void goTo(String URL) {
        System.out.println("Navigating to URL " + URL);
    }

    @Override
    public void getTitle() {
        System.out.println("Getting title of the current website");
    }

    @Override
    public void close() {
        System.out.println("Closing the browser");
    }
}
