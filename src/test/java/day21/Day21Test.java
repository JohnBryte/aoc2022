package day21;

import day20.Day20;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day21Test {
    InputReader inputReader = new InputReader();
    Day21 day = new Day21(inputReader.readInput("day21_test"));

    Day21Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("152", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("301", day.solvePart2());
    }
}