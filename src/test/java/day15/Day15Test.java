package day15;

import day14.Day14;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day15Test {
    InputReader inputReader = new InputReader();
    Day15 day = new Day15(inputReader.readInput("day15_test"), 10, 20);

    Day15Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("26", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("56000011", day.solvePart2());
    }
}