package day10;

import day09.Day09;
import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day10Test {
    InputReader inputReader = new InputReader();
    Day10 day = new Day10(inputReader.readInput("day10_test"));

    Day10Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        assertEquals("13140", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        assertEquals("##..##..##..##..##..##..##..##..##..##.." +
                "###...###...###...###...###...###...###." +
                "####....####....####....####....####...." +
                "#####.....#####.....#####.....#####....." +
                "######......######......######......####" +
                "#######.......#######.......#######.....", day.solvePart2());
    }
}