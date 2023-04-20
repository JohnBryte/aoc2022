package day21;

import utils.Day;

import java.text.DecimalFormat;
import java.util.*;

public class Day21 extends Day {

    Map<String, MonkeyDay21> map = new HashMap<>();

    public Day21(List<String> input) {
        super(input);
    }

    private void parseInput(List<String> input) {
        map = new HashMap<>();
        for (String line : input) {
            String[] lineArray = line.split(": ");
            String monkeyName = lineArray[0];
            String[] monkeyJob = lineArray[1].split(" ");
            try {
                Long number = Long.parseLong(monkeyJob[0]);
                map.put(monkeyName, new MonkeyDay21(monkeyName, number));
            } catch (Exception e) {
                map.put(monkeyName, new MonkeyDay21(monkeyName, monkeyJob[0], monkeyJob[1], monkeyJob[2]));
            }
        }
    }

    private void calculateRoot() {
        while (map.get("root").getResult() == null) {
            for (MonkeyDay21 monkey : map.values()) {
                if (monkey.getResult() == null) {
                    MonkeyDay21 monkeyLeft = map.get(monkey.getLeft());
                    MonkeyDay21 monkeyRight = map.get(monkey.getRight());
                    if (monkeyLeft.getResult() != null && monkeyRight.getResult() != null) {
                        monkey.doOperation(monkeyLeft.getResult(), monkeyRight.getResult());
                        monkeyLeft.setParent(monkey.getName());
                        monkeyRight.setParent(monkey.getName());
                    }
                }
            }
        }
    }

    @Override
    public String solvePart1() {
        parseInput(input);
        calculateRoot();
        Long root = map.get("root").getResult();
        System.out.println(Objects.equals(map.get(map.get("root").getLeft()).getResult(), map.get(map.get("root").getRight()).getResult()));
        return String.valueOf(root);
    }

    @Override
    public String solvePart2() {
        parseInput(input);
        calculateRoot();
        //Find path for human
        MonkeyDay21 nextMonkey = map.get("humn");
        List<String> tree = new ArrayList<>();

        while (!nextMonkey.getName().equals("root")) {
            tree.add(nextMonkey.getName());
            nextMonkey = map.get(nextMonkey.getParent());
        }
        long target;
        if (map.get("root").getLeft().equals(tree.get(tree.size() - 1))) {
            target = map.get(map.get("root").getRight()).getResult();
        } else {
            target = map.get(map.get("root").getLeft()).getResult();
        }
        //tree.add(nextMonkey.getName());

        Collections.reverse(tree);
        for (String monkeyName : tree) {
            MonkeyDay21 monkey = map.get(monkeyName);
            monkey.setResult(target);

            if (tree.contains(monkey.getLeft())) {
                target = monkey.doOperationInverseLeft(monkey.getResult(), map.get(monkey.getRight()).getResult());
                //map.get(monkey.getLeft()).setResult(newTarget);
            } else if (tree.contains(monkey.getRight())) {
                target = monkey.doOperationInverseRight(monkey.getResult(), map.get(monkey.getLeft()).getResult());
                //map.get(monkey.getRight()).setResult(newTarget);
            } else if (monkey.getName().equals("humn")){
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }

        return String.valueOf(map.get("humn").getResult());
    }
}
