package utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Day {
    public List<String> input = new ArrayList<>();

    public Day(List<String> input) throws FileNotFoundException {
        this.input = input;
    }
}
