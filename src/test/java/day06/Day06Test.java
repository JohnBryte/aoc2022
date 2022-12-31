package day06;

import day05.Day05;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day06Test {
    InputReader inputReader = new InputReader();
    Day06 day = new Day06(inputReader.readInput("day06_test"));

    Day06Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("10", day.solvePart1());
    }

    @Test
    public void Part2_Test() {
        assertEquals("29", day.solvePart2());
    }
}