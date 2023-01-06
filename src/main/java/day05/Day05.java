package day05;

import utils.Day;

import java.util.*;
import java.util.stream.Collectors;

public class Day05 extends Day {
    Map<Integer, List<String>> crates = new HashMap<>();
    List<List<Integer>> instructions = new ArrayList<>();

    public Day05(List<String> input) {
        super(input);
        List<String> crateInput = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals("")) {
                parseInstructions(input.subList(i + 1, input.size()));
                break;
            }
            crateInput.add(input.get(i));
        }
        parseCrates(crateInput.subList(0, crateInput.size() - 1));
    }

    private void parseInstructions(List<String> subList) {
        for (String line : subList) {
            String[] words = line.split(" ");
            instructions.add(List.of(Integer.parseInt(words[1]), Integer.parseInt(words[3]), Integer.parseInt(words[5])));
        }
    }

    private void parseCrates(List<String> crateInput) {
        int currentCrate;
        for (String line : crateInput) {
            currentCrate = 0;
            for (int i = 0; i < line.length(); i++) {
                if (i % 4 == 0) {
                    currentCrate++;
                }
                String cargo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                if (cargo.indexOf(line.charAt(i)) != -1) {
                    crates.computeIfAbsent(currentCrate, k -> new ArrayList<>()).add(String.valueOf(line.charAt(i)));
                }
            }
        }
    }

    @Override
    public String solvePart1() {
        for (List<Integer> instruction : instructions) {
            List<String> toBeMoved = getCargoToBeMoved(instruction);
            Collections.reverse(toBeMoved);
            crates.computeIfAbsent(instruction.get(2), k -> new ArrayList<>()).addAll(0, toBeMoved);
        }
        return crates.values().stream().map(v -> v.get(0)).collect(Collectors.joining());
    }

    @Override
    public String solvePart2() {
        for (List<Integer> instruction : instructions) {
            List<String> toBeMoved = getCargoToBeMoved(instruction);
            crates.computeIfAbsent(instruction.get(2), k -> new ArrayList<>()).addAll(0, toBeMoved);
        }
        return crates.values().stream().map(v -> v.get(0)).collect(Collectors.joining());
    }

    private List<String> getCargoToBeMoved(List<Integer> instruction) {

        List<String> crate = crates.get(instruction.get(1));
        Integer cargoToMove = instruction.get(0);
        List<String> toBeMoved = new ArrayList<>(crate.subList(0, cargoToMove));
        crates.computeIfAbsent(instruction.get(1), k -> new ArrayList<>()).subList(0, cargoToMove).clear();
        return toBeMoved;
    }
}
