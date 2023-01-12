package Class16_DevelopFunctions;

public class CustomExceptionDemo {
    public static void main(String[] args) throws Exception {
        int myint = 10;

        if (myint > 5) {
            System.out.println("Hi");
        } else {
            try {
                System.out.println("Custom error message goes here: ");
                throw new Exception(String.valueOf(myint));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
