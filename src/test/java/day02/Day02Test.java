package day02;

import day01.Day01;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {
    InputReader inputReader = new InputReader();
    Day02 day = new Day02(inputReader.readInput("day02_test"));

    Day02Test() throws IOException {
    }

    @Test
    public void Part1_Test() throws IOException {
        assertEquals("15", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("12", day.solvePart2());
    }
}