import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter records. Type 'done' to finish.");

        while (true) {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            if (firstName.equalsIgnoreCase("done")) break;

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("ID Number (6 digits): ");
            String idNumber = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Year of Birth: ");
            String yearOfBirth = scanner.nextLine();

            records.add(String.format("%s, %s, %s, %s, %s", firstName, lastName, idNumber, email, yearOfBirth));
        }

        System.out.print("\nEnter file name to save (add .csv): ");
        String fileName = scanner.nextLine();

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}
