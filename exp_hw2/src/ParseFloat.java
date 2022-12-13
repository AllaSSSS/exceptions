import java.util.Scanner;

public class ParseFloat {
    public static void main(String[] args) {
        float value = askFloatNumber("Enter a float number");
        System.out.println("The entered value is " + value);
    }

    private static float askFloatNumber(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            System.out.print(": ");
            String line = scanner.nextLine();
            try {
                return Float.parseFloat(line);
            } catch (NumberFormatException ignore) {
            }
        }
    }
}
