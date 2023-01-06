package day08;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day08Test {
    InputReader inputReader = new InputReader();
    Day08 day = new Day08(inputReader.readInput("day08_test"));

    Day08Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("21", day.solvePart1());
    }

    @Test
    public void Part2_Test() {
        assertEquals("8", day.solvePart2());
    }
}