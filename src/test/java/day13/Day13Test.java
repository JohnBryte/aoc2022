package day13;

import day12.Day12;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day13Test {
    InputReader inputReader = new InputReader();
    Day13 day = new Day13(inputReader.readInput("day13_test"));

    Day13Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("13", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("140", day.solvePart2());
    }
}