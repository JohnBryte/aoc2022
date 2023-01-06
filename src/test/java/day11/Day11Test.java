package day11;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day11Test {
    InputReader inputReader = new InputReader();
    Day11 day = new Day11(inputReader.readInput("day11_test"));

    Day11Test() throws IOException {
    }

    @Test
    public void Part1_Test() {
        day.monkeyList.get(0).monkeyOperations = new MonkeyTest0();
        day.monkeyList.get(1).monkeyOperations = new MonkeyTest1();
        day.monkeyList.get(2).monkeyOperations = new MonkeyTest2();
        day.monkeyList.get(3).monkeyOperations = new MonkeyTest3();
        assertEquals("10605", day.solvePart1());
    }

    @Test
    public void Part2_Test() throws IOException {
        day = new Day11(inputReader.readInput("day11_test"));
        day.monkeyList.get(0).monkeyOperations = new MonkeyTest0();
        day.monkeyList.get(1).monkeyOperations = new MonkeyTest1();
        day.monkeyList.get(2).monkeyOperations = new MonkeyTest2();
        day.monkeyList.get(3).monkeyOperations = new MonkeyTest3();
        assertEquals("2713310158", day.solvePart2());
    }
}