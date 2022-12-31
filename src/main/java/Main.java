import day01.Day01;
import day02.Day02;
import day03.Day03;
import day04.Day04;
import utils.InputReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        Day01 day01 = new Day01(inputReader.readInput("day01"));
        System.out.println("Day01 Part1: " + day01.solvePart1());
        System.out.println("Day01 Part1: " + day01.solvePart2());

        Day02 day02 = new Day02(inputReader.readInput("day02"));
        System.out.println("Day02 Part1: " + day02.solvePart1());
        System.out.println("Day02 Part2: " + day02.solvePart2());

        Day03 day03 = new Day03(inputReader.readInput("day03"));
        System.out.println("Day03 Part1: " + day03.solvePart1());
        System.out.println("Day03 Part2: " + day03.solvePart2());

        Day04 day04 = new Day04(inputReader.readInput("day04"));
        System.out.println("Day04 Part1: " + day04.solvePart1());
        System.out.println("Day04 Part2: " + day04.solvePart2());
    }

}
