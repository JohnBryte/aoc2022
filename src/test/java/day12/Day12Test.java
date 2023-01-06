package day12;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day12Test {
    InputReader inputReader = new InputReader();
    Day12 day = new Day12(inputReader.readInput("day12_test"));

    Day12Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("31", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("29", day.solvePart2());
    }
}