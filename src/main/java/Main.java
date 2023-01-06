import day02.Day02;
import day03.Day03;
import day04.Day04;
import day05.Day05;
import day06.Day06;
import day07.Day07;
import day08.Day08;
import day09.Day09;
import day10.Day10;
import day11.Day11;
import day12.Day12;
import day01.Day01;
import day13.Day13;
import day14.Day14;
import utils.Day;
import utils.InputReader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        Day day = new Day01(inputReader.readInput("day01"));
        System.out.println("Day01 Part1: " + day.solvePart1());
        System.out.println("Day01 Part1: " + day.solvePart2());

        day = new Day02(inputReader.readInput("day02"));
        System.out.println("Day02 Part1: " + day.solvePart1());
        System.out.println("Day02 Part2: " + day.solvePart2());

        day = new Day03(inputReader.readInput("day03"));
        System.out.println("Day03 Part1: " + day.solvePart1());
        System.out.println("Day03 Part2: " + day.solvePart2());

        day = new Day04(inputReader.readInput("day04"));
        System.out.println("Day04 Part1: " + day.solvePart1());
        System.out.println("Day04 Part2: " + day.solvePart2());

        day = new Day05(inputReader.readInput("day05"));
        System.out.println("Day05 Part1: " + day.solvePart1());
        day = new Day05(inputReader.readInput("day05"));
        System.out.println("Day05 Part2: " + day.solvePart2());

        day = new Day06(inputReader.readInput("day06"));
        System.out.println("Day06 Part1: " + day.solvePart1());
        System.out.println("Day06 Part2: " + day.solvePart2());

        day = new Day07(inputReader.readInput("day07"));
        System.out.println("Day07 Part1: " + day.solvePart1());
        System.out.println("Day07 Part2: " + day.solvePart2());

        day = new Day08(inputReader.readInput("day08"));
        System.out.println("Day08 Part1: " + day.solvePart1());
        System.out.println("Day08 Part2: " + day.solvePart2());

        day = new Day09(inputReader.readInput("day09"));
        System.out.println("Day09 Part1: " + day.solvePart1());
        System.out.println("Day09 Part2: " + day.solvePart2());

        day = new Day10(inputReader.readInput("day10"));
        System.out.println("Day10 Part1: " + day.solvePart1());
        System.out.println("Day10 Part2: "); day.solvePart2();

        day = new Day11(inputReader.readInput("day11"));
        System.out.println("Day11 Part1: " + day.solvePart1());
        day = new Day11(inputReader.readInput("day11"));
        System.out.println("Day11 Part2: " + day.solvePart2());

        day = new Day12(inputReader.readInput("day12"));
        System.out.println("Day12 Part1: " + day.solvePart1());
        System.out.println("Day12 Part2: " + day.solvePart2());

        day = new Day13(inputReader.readInput("day13"));
        System.out.println("Day13 Part1: " + day.solvePart1());
        System.out.println("Day13 Part2: " + day.solvePart2());

        day = new Day14(inputReader.readInput("day14"));
        System.out.println("Day14 Part1: " + day.solvePart1());
        System.out.println("Day14 Part2: " + day.solvePart2());
    }

}
