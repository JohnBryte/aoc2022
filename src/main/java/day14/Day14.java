package day14;

import utils.Day;

import java.util.List;

public class Day14 extends Day {
    public Day14(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        CaveMap caveMap = new CaveMap(500);
        caveMap.createMap(input, true);
        return String.valueOf(caveMap.calculateSand());
    }

    @Override
    public String solvePart2() {
        CaveMap caveMap = new CaveMap(500);
        caveMap.createMap(input, false);
        return String.valueOf(caveMap.calculateSand());
    }
}
