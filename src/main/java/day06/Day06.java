package day06;

import utils.Day;

import java.util.List;

public class Day06 extends Day {
    public Day06(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        int result = charsBeforeMarker(4, input.get(0));
        return String.valueOf(result);
    }

    private int charsBeforeMarker(int size, String message) {
        for (int i = 0, j = size; j < message.length(); i++, j++) {
            if (message.substring(i, j).chars().distinct().count() == size) {
                return j;
            }
        }
        return 0;
    }

    @Override
    public String solvePart2() {
        int result = charsBeforeMarker(14, input.get(0));
        return String.valueOf(result);
    }
}
