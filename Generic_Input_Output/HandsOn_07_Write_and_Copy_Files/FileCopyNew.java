import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileCopyNew {
    private static final Path LOG_FILE = Paths.get("log.txt");
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static void log(String message) {
        String line = "[" + LocalDateTime.now().format(FMT) + "] " + message;
        System.out.println(line);
        try {
            Files.write(LOG_FILE, List.of(line),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Gagal menulis log: " + e.getMessage());
        }
    }

    private static void backup(Path source, Path backup) {
        if (!Files.exists(source)) {
            log("GAGAL: file sumber " + source + " tidak ditemukan, backup dibatalkan.");
            return;
        }
        try {
            if (backup.getParent() != null && Files.notExists(backup.getParent())) {
                Files.createDirectories(backup.getParent());
                log("Folder " + backup.getParent() + " dibuat.");
            }
            Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
            log("SUKSES: " + source + " disalin ke " + backup + " (" + Files.size(backup) + " byte).");
        } catch (IOException e) {
            log("GAGAL menyalin " + source + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");

        try {
            Files.write(source, List.of("Report Generated", "Status: OK"));
            log("SUKSES: laporan ditulis ke " + source + ".");
        } catch (IOException e) {
            log("GAGAL menulis laporan: " + e.getMessage());
        }

        backup(source, backup);

        backup(Paths.get("tidak_ada.txt"), Paths.get("backup/tidak_ada.txt"));

        System.out.println("\nSemua operasi tercatat di " + LOG_FILE.toAbsolutePath());
    }
}
