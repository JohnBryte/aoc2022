import Day07.Day07;
import day01.Day01;
import day02.Day02;
import day03.Day03;
import day04.Day04;
import day05.Day05;
import day06.Day06;
import day08.Day08;
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
    }

}
