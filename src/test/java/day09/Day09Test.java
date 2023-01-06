package day09;

import day08.Day08;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day09Test {
    InputReader inputReader = new InputReader();
    Day09 day = new Day09(inputReader.readInput("day09_test"));

    Day09Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("13", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        day = new Day09(inputReader.readInput("day09_test_p2"));
        assertEquals("36", day.solvePart2());
    }
}