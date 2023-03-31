import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AllasParser {


    static final Pattern PHONE    = Pattern.compile("[0-9]+");
    static final Pattern BIRTHDAY = Pattern.compile("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}");


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            for (;;) {
                String line = scanner.nextLine();
                if (line.isBlank()) break;
                Record rec;
                try {
                    rec = Record.parse(line);
                } catch (InvalidFormatException e) {
                    System.err.println(e.getMessage());
                    continue;
                }
                String fileName = rec.lastName;
                try (FileWriter writer = new FileWriter(fileName, StandardCharsets.UTF_8, true)) {
                    rec.writeTo(writer);
                    writer.write(System.lineSeparator());
                } catch (IOException e) {
                    System.err.println("Could not add record to file '" + fileName + "'");
                }
            }
        }
    }


    static class Record {

        static Record parse(String line) throws InvalidFormatException {
            String[] fields = line.trim().split(" +");
            if (fields.length != 6) throw new InvalidFormatException("Not enough data: 6 arguments expected");
            Record rec = new Record();
            for (String f : fields) {
                if (rec.sex == 0 && f.length() == 1) { // sex?
                    char s = f.charAt(0);
                    switch (s) {
                        case 'm':
                        case 'f':
                            rec.sex = s;
                            continue;
                        default:
                            throw new InvalidFormatException("Wrong sex marker '" + s + "'");
                    }
                }
                if (rec.phone == null && PHONE.matcher(f).matches()) {
                    rec.phone = f;
                    continue;
                }
                if (rec.birthday == null && f.indexOf('.') >= 0) { // birthday
                    if (BIRTHDAY.matcher(f).matches()) {
                        rec.birthday = f;
                        continue;
                    } else {
                        throw new InvalidFormatException("Wring date format '" + f + "'");
                    }
                } else
                if (Character.isUpperCase(f.charAt(0))) { // name?
                    if (rec.  lastName == null) { rec.  lastName = f; continue; } else
                    if (rec. firstName == null) { rec. firstName = f; continue; } else
                    if (rec.middleName == null) { rec.middleName = f; continue; }
                }
                throw new InvalidFormatException("Unrecognized value '" + f + "'");
            }
            return rec;
        }

        String  firstName;
        String   lastName;
        String middleName;
        String   birthday;
        String      phone;
        char          sex;

        void writeTo(Writer out) throws IOException {
            out.write(  lastName); out.write(' ');
            out.write( firstName); out.write(' ');
            out.write(middleName); out.write(' ');
            out.write(  birthday); out.write(' ');
            out.write(     phone); out.write(' ');
            out.write(       sex);
        }
    }


    static class InvalidFormatException extends Exception {
        public InvalidFormatException(String message) {
            super(message);
        }
    }
}