package day20;

import day18.Day18;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day20Test {
    InputReader inputReader = new InputReader();
    Day20 day = new Day20(inputReader.readInput("day20_test"), true);

    Day20Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("3", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("1623178306", day.solvePart2());
    }
}