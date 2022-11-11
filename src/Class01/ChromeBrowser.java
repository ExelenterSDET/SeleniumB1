package Class01;

public class ChromeBrowser implements ParentBrowser {
    public ChromeBrowser(){
        System.out.println("Launching...");
    }

    @Override
    public void goTo(String URL) {
        System.out.println("Navigating to" + URL);
    }

    @Override
    public void getCurrentURL() {
        System.out.println("Launching URL...");
    }

    @Override
    public void getTitle() {
        System.out.println("Getting the title");
    }

    @Override
    public void close() {
        System.out.println("Closing the browser");
    }
}
