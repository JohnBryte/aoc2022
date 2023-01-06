package day14;

import day13.Day13;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day14Test {
    InputReader inputReader = new InputReader();
    Day14 day = new Day14(inputReader.readInput("day14_test"));

    Day14Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("24", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("93", day.solvePart2());
    }
}