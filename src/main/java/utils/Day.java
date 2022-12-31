package utils;

import java.util.List;

public abstract class Day implements IPuzzleSolver {
    public List<String> input;

    public Day(List<String> input) {
        this.input = input;
    }
}
