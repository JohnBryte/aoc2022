package day16;

import day14.Day14;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class Day16Test {
    InputReader inputReader = new InputReader();
    Day16 day = new Day16(inputReader.readInput("day16_test"));

    Day16Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("1651", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("1707", day.solvePart2());
    }
}