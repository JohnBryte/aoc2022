package day18;

import day17.Day17;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day18Test {
    InputReader inputReader = new InputReader();
    Day18 day = new Day18(inputReader.readInput("day18_test"));

    Day18Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("64", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("58", day.solvePart2());
    }
}