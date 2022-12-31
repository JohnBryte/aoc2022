package day04;

import day03.Day03;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day04Test {
    InputReader inputReader = new InputReader();
    Day04 day = new Day04(inputReader.readInput("day04_test"));

    Day04Test() throws IOException {
    }

    @Test
    public void Part1_Test() throws IOException {
        assertEquals("2", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("4", day.solvePart2());
    }
}