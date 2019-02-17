package fileReader;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<String> asLines(String filePath) {
        try {
            URL resource = ClassLoader.getSystemResource(filePath);
            return Files.readAllLines(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
