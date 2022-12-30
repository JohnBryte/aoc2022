package day01;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    InputReader inputReader = new InputReader();
    Day01 day = new Day01(inputReader.readInput("day01_test"));

    Day01Test() throws IOException {
    }

    @Test
    public void Part1_Test() throws IOException {
        assertEquals("24000", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("45000", day.solvePart2());
    }

}