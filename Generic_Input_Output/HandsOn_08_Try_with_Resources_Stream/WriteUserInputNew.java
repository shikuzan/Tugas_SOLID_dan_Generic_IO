import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WriteUserInputNew {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int count = 0;

        // Scanner dan BufferedWriter otomatis ditutup oleh try-with-resources
        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = Files.newBufferedWriter(Paths.get("user_input.txt"))) {

            System.out.println("Ketik teks (ketik 'exit' untuk berhenti):");
            while (true) {
                System.out.print("Enter text: ");
                if (!sc.hasNextLine()) {
                    break;                       // input habis (mis. Ctrl+D)
                }
                String text = sc.nextLine();
                if (text.equalsIgnoreCase("exit")) {
                    break;
                }
                String timestamp = LocalDateTime.now().format(fmt);
                bw.write("[" + timestamp + "] " + text);
                bw.newLine();
                count++;
            }
            System.out.println("\nSaved! " + count + " baris tersimpan di user_input.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
