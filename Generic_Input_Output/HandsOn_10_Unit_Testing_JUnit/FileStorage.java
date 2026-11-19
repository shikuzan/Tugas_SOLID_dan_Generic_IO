import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FileStorage<T extends CsvRecord> {
    private final Path filePath;

    public FileStorage(Path filePath) {
        this.filePath = filePath;
    }

    public void save(List<T> data) throws IOException {
        List<String> lines = new ArrayList<>();
        for (T item : data) {
            lines.add(item.toCsv());
        }
        Files.write(filePath, lines);
    }

    public List<String> readLines() throws IOException {
        return Files.readAllLines(filePath);
    }

    public List<T> load(Function<String, T> parser) throws IOException {
        List<T> result = new ArrayList<>();
        for (String line : readLines()) {
            if (!line.isBlank()) {
                result.add(parser.apply(line));
            }
        }
        return result;
    }

    public Path getFilePath() {
        return filePath;
    }
}
