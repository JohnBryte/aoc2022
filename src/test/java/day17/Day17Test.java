package day17;

import day16.Day16;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day17Test {
    InputReader inputReader = new InputReader();
    Day17 day = new Day17(inputReader.readInput("day17_test"));

    Day17Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("3068", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("1707", day.solvePart2());
    }
}