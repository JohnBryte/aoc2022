package day17;

import utils.Day;

import java.util.List;

public class Day17 extends Day {

    public Day17(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        Cave cave = new Cave(input.get(0), false, 2022);
        return String.valueOf(cave.simulateRockFall());
    }

    @Override
    public String solvePart2() {
        Cave cave = new Cave(input.get(0), false, 1000000000000L);
        return String.valueOf(cave.simulateRockFall());
    }
}
