import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) {
        File file = null;

        if (args.length > 0) {
            file = new File("src/" + args[0]);
        } else {
            JFileChooser fileChooser = new JFileChooser("src");
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            } else {
                System.out.println("No file selected.");
                return;
            }
        }

        if (file != null && file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found.");
        }
    }
}