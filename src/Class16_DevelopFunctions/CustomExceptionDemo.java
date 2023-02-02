package Class16_DevelopFunctions;

public class CustomExceptionDemo {
        static final int TEN = 10;
    public static void main(String[] args) throws Exception {
        int myInt = 11;
        if (TEN >= myInt) {
            System.out.println("Hi");
        } else {
            try {
                System.out.println("Please enter a number equal to or less than " + TEN);
                throw new Exception(myInt + " entered");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
