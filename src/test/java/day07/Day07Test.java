package day07;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day07Test {
    InputReader inputReader = new InputReader();
    Day07 day = new Day07(inputReader.readInput("day07_test"));

    Day07Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("95437", day.solvePart1());
    }

    @Test
    public void Part2_Test() {
        assertEquals("24933642", day.solvePart2());
    }
}