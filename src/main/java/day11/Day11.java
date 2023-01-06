package day11;

import utils.Day;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Day11 extends Day {

    List<Monkey> monkeyList = new ArrayList<>();

    public Day11(List<String> input) {
        super(input);
        List<IMonkeyOperations> monkeyOperationsList =
                List.of(new Monkey0(), new Monkey1(), new Monkey2(), new Monkey3(), new Monkey4(), new Monkey5(), new Monkey6(), new Monkey7());
        int monkeyNumber = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).startsWith("Monkey")) {
                String itemLine = input.get(i + 1);
                String[] items = itemLine.split(": ")[1].split(", ");
                List<BigInteger> itemList = new ArrayList<>();
                for (String item : items) {
                    itemList.add(BigInteger.valueOf(Long.parseLong(item)));
                }
                monkeyList.add(new Monkey(itemList, monkeyOperationsList.get(monkeyNumber)));
                monkeyNumber++;
            }
        }

    }

    @Override
    public String solvePart1() {
        return doMonkeyCalculations(20, true);
//        int counter = 1;
//        while (counter <= 20) {
//            for (Monkey currentMonkey : monkeyList) {
//                List<BigInteger> monkeyItems = currentMonkey.getItems();
//                for (BigInteger currentItem : monkeyItems) {
//                    BigInteger newValue = currentMonkey.doOperation(currentItem).divide(BigInteger.valueOf(3L));
////                    BigInteger newValue = currentMonkey.doOperation(currentItem);
//                    currentMonkey.inspect();
////                    modulo trick 5 * 11 * 2 * 13 * 7 * 3 * 17 * 19
//                    BigInteger mod = newValue.mod(BigInteger.valueOf(9699690L));
//                    BigInteger nextMonkey = currentMonkey.doTest(mod);
//                    monkeyList.get(nextMonkey.intValue()).addNewItem(mod);
//                }
//                currentMonkey.setItems(new ArrayList<>());
//            }
//            counter++;
//        }
//
//        BigInteger mostActiveMonkey = BigInteger.valueOf(Integer.MIN_VALUE);
//        BigInteger secondMostActiveMonkey = BigInteger.valueOf(Integer.MIN_VALUE);
//        for (Monkey monkey : monkeyList) {
//            int value = monkey.getInspectionCounter();
//            if (value > mostActiveMonkey.intValue()) {
//                secondMostActiveMonkey = mostActiveMonkey;
//                mostActiveMonkey = BigInteger.valueOf(value);
//            } else if (value > secondMostActiveMonkey.intValue()) {
//                secondMostActiveMonkey = BigInteger.valueOf(value);
//            }
//        }
//
//        return String.valueOf(mostActiveMonkey.multiply(secondMostActiveMonkey));
    }

    @Override
    public String solvePart2() {
        return doMonkeyCalculations(10000, false);
    }

    public String doMonkeyCalculations(int rounds, boolean isPartOne) {
        int counter = 1;
        long divisor = 1;
        for (Monkey monkey : monkeyList) {
            divisor *= monkey.getDivisor();
        }
        while (counter <= rounds) {
            for (Monkey currentMonkey : monkeyList) {
                List<BigInteger> monkeyItems = currentMonkey.getItems();
                for (BigInteger currentItem : monkeyItems) {
                    BigInteger newValue = currentMonkey.doOperation(currentItem);
                    if (isPartOne) {
                        newValue = newValue.divide(BigInteger.valueOf(3L));
                    }
                    currentMonkey.inspect();
                    //modulo trick 5 * 11 * 2 * 13 * 7 * 3 * 17 * 19
                    BigInteger mod = newValue.mod(BigInteger.valueOf(divisor));
                    BigInteger nextMonkey = currentMonkey.doTest(mod);
                    monkeyList.get(nextMonkey.intValue()).addNewItem(mod);
                }
                currentMonkey.setItems(new ArrayList<>());
            }
            counter++;
        }

        BigInteger mostActiveMonkey = BigInteger.valueOf(Integer.MIN_VALUE);
        BigInteger secondMostActiveMonkey = BigInteger.valueOf(Integer.MIN_VALUE);
        for (Monkey monkey : monkeyList) {
            int value = monkey.getInspectionCounter();
            if (value > mostActiveMonkey.intValue()) {
                secondMostActiveMonkey = mostActiveMonkey;
                mostActiveMonkey = BigInteger.valueOf(value);
            } else if (value > secondMostActiveMonkey.intValue()) {
                secondMostActiveMonkey = BigInteger.valueOf(value);
            }
        }
        return String.valueOf(mostActiveMonkey.multiply(secondMostActiveMonkey));
    }
}
