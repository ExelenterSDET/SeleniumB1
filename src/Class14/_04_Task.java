package Class14;

import static utils.BaseClass.*;


/**
 *  Task: Go to this URL: https://the-internet.herokuapp.com/windows
 *     1. Identify and print parent window ID and Title
 *     2. Click on the link where it says 'Click Here' three times
 *     3. Switch to new tabs and print their title to the console as well.
 *        Bonus: Load facebook website in all children pages.
 */
public class _04_Task {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/windows");

        tearDown();
    }
}
