import java.util.Scanner;

public class EmptyLineException extends Exception {

    public EmptyLineException() {
        super("You have entered an empty string!");
    }

    public static void main(String[] args) throws EmptyLineException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a line: ");
        String line = scanner.nextLine();
        if (line.isBlank()) {
            throw new EmptyLineException();
        }
        System.out.print("You entered: ");
        System.out.print(line);
    }
}
