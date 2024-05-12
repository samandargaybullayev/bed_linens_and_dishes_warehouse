package s1mpl3.coder.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CustomFileReader {

    public List<String> readFile(String path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get(path));
        return reader.lines().skip(1).toList();
    }
}
