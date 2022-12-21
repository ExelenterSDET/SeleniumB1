package Class12;

import static utils.BaseClass.*;

public class _03_AuthenticationAlert {
    public static void main(String[] args) {
        setUp("https://foo:bar@httpbin.org/basic-auth/foo/bar");

        /**
         *  1. JS Alert types
         *  2. Modal (HTML based) popup types
         *  3. Basic Authentication Alert type
         *  4. Window based popups (not supported by Selenium).
         *
         *  For above website:
         *  Username = foo
         *  Password = bar
         *
         */

        tearDown();
    }
}
