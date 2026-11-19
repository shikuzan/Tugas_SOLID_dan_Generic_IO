import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadEmployees {

    public static void main(String[] args) {
        String fileName = args.length > 0 ? args[0] : "employees.txt";
        Path source = Paths.get(fileName);
        Path target = Paths.get("copy_employees.txt");

        if (Files.notExists(source)) {
            System.out.println("File tidak ditemukan: " + source.toAbsolutePath());
            return;
        }

        List<String> employees = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(source, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    employees.add(line);
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("File tidak ditemukan: " + e.getFile());
            return;
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        System.out.println("Isi " + fileName + " (" + employees.size() + " baris):");
        employees.forEach(System.out::println);

        try (BufferedWriter bw = Files.newBufferedWriter(target, StandardCharsets.UTF_8)) {
            for (String emp : employees) {
                bw.write(emp);
                bw.newLine();
            }
            System.out.println("\nData berhasil ditulis ke " + target.getFileName());
        } catch (IOException e) {
            System.out.println("Gagal menulis file: " + e.getMessage());
        }
    }
}
