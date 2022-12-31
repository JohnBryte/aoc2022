package day03;

import day02.Day02;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day03Test {
    InputReader inputReader = new InputReader();
    Day03 day = new Day03(inputReader.readInput("day03_test"));

    Day03Test() throws IOException {
    }

    @Test
    public void Part1_Test() throws IOException {
        assertEquals("157", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("70", day.solvePart2());
    }
}