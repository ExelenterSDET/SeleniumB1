package Class16_DevelopFunctions;

public class CustomExceptionDemo {
    public static void main(String[] args) throws Exception {
        int myint = 10;

        if (myint >= 15) {
            System.out.println("Hi");
        } else {
            try {
                System.out.println("Please enter a number equal to or less than " + myint);
                throw new Exception(String.valueOf(myint));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
