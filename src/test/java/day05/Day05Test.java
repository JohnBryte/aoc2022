package day05;

import day04.Day04;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day05Test {
    InputReader inputReader = new InputReader();
    Day05 day = new Day05(inputReader.readInput("day05_test"));

    Day05Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("CMZ", day.solvePart1());
    }

    @Test
    public void Part2_Test() {
        assertEquals("MCD", day.solvePart2());
    }
}