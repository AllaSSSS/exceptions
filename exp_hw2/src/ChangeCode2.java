// Изменения не требуются

public class ChangeCode2 {

    public static void main(String[] args) {
        int[] intArray = new int[9];
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

}
