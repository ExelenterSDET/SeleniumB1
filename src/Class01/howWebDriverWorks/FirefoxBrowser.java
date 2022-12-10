package Class01.howWebDriverWorks;

public class FirefoxBrowser implements ParentBrowser {

    public FirefoxBrowser(){
        System.out.println("Starting Firefox browser...");
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
