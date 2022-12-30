package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    public List<String> readInput(String file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/" + file +".txt"));
        return bufferedReader.lines().collect(Collectors.toList());
//        return Arrays.stream(String.join("#", Files.readAllLines(Path.of("src/main/resources/" + file +".txt"))).split("#")).collect(Collectors.toList());
    }
}
