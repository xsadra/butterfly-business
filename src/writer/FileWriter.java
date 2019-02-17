package writer;

import model.Purchase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public abstract class FileWriter {
    public void save(List<String> lines, String filePath) {
        List<String> printedLines = getLines(lines);
        try {
            Path path = Paths.get(filePath);
            Files.write(path, printedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract List<String> getLines(List<String> purchases);
}
