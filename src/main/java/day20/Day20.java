package day20;

import utils.Day;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day20 extends Day {

    private boolean isDebug = false;
    public Day20(List<String> input, boolean isDebug) {
        super(input);
        this.isDebug = isDebug;
    }

    @Override
    public String solvePart1() {
        return getOtherSolution(1, 1);
        //return getResult(1, 1);
    }

    @Override
    public String solvePart2() {
        return getOtherSolution(10, 811589153);
    }

    private String getOtherSolution(int rounds, long encryptionKey) {
        NumberWrapper[] array = new NumberWrapper[input.size()];
        for (int i = 0; i < input.size(); i++) {
            array[i] = new NumberWrapper(Integer.parseInt(input.get(i)) * encryptionKey, i);
        }
        if (isDebug) {
            printArray(array);
        }
        for (int round = 0; round < rounds; round++) {
            for (int instructionIdx = 0; instructionIdx < input.size(); instructionIdx++) {
                if (isDebug) {
                    System.out.println("====== " + instructionIdx + ": " + Integer.parseInt(input.get(instructionIdx)) + " ======");
                }

                NumberWrapper[] arrayCopy = new NumberWrapper[array.length];
                int newIdx = -1;

                for (int currentIdx = 0; currentIdx < array.length; currentIdx++) {
                    if (array[currentIdx].getIdx() == instructionIdx) {
                        newIdx = calculateNewIdx(currentIdx, array[currentIdx], array.length);
                        arrayCopy[newIdx] = array[currentIdx];
                        break;
                    }
                }

                int lastIdx = 0;
                for (NumberWrapper numberWrapper : array) {
                    if (numberWrapper.getIdx() != instructionIdx) {
                        for (; lastIdx < arrayCopy.length; lastIdx++) {
                            if (arrayCopy[lastIdx] == null) {
                                arrayCopy[lastIdx] = numberWrapper;
                                break;
                            }
                        }
                    }
                }

                array = arrayCopy;

                if (isDebug) {
                    printArray(array);
                }
            }

        }
        NumberWrapper[] finalArray = array;
        int idxOfZero = IntStream.range(0, array.length).filter(idx -> finalArray[idx].getVal() == 0).findFirst().orElseThrow();
        long one = array[Math.floorMod(idxOfZero + 1000, array.length)].getVal();
        long two = array[Math.floorMod(idxOfZero + 2000, array.length)].getVal();
        long three = array[Math.floorMod(idxOfZero + 3000, array.length)].getVal();
        return String.valueOf(one + two + three);
    }

    private int calculateNewIdx(int currentIdx, NumberWrapper numberWrapper, int length) {
        return Math.floorMod(currentIdx + numberWrapper.getVal(), length - 1);
    }

    private String getResult(int rounds, long decryptionKey) {
        List<NumberWrapper> list = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            list.add(new NumberWrapper(Integer.parseInt(input.get(i)) * decryptionKey, i));
        }
        if (isDebug) {
            printArray(list);
        }

        for (int round = 0; round < rounds; round++) {
            for (int instructionIdx = 0; instructionIdx < input.size(); instructionIdx++) {
                if (isDebug) {
                    System.out.println("====== " + instructionIdx + ": " + Integer.parseInt(input.get(instructionIdx)) + " ======");
                }

                while (list.get(0).getIdx() != instructionIdx) {
                    list.add(list.remove(0));
                }
                NumberWrapper number = list.remove(0);
                int index = Math.floorMod(number.getVal(), list.size());
                for (int i = 0; i < index; i++) {
                    NumberWrapper remove = list.remove(0);
                    list.add(remove);
                }

                list.add(number);
                if (isDebug) {
                    printArray(list);
                }
            }
        }
        int idxOfZero = IntStream.range(0, list.size()).filter(val -> list.get(val).getVal() == 0).findFirst().orElseThrow();

        long one = list.get(Math.floorMod(idxOfZero + 1000, list.size())).getVal();
        long two = list.get(Math.floorMod(idxOfZero + 2000, list.size())).getVal();
        long three = list.get(Math.floorMod(idxOfZero + 3000, list.size())).getVal();
        return String.valueOf(one + two + three);
    }

    private void printArray(List<NumberWrapper> array) {
        StringBuilder print = new StringBuilder();
        int counter = array.size();
        for (NumberWrapper  numberWrapper : array) {
            if (counter == array.size() - 1) {
                if (numberWrapper == null) {
                    print.append("NULL");
                } else {
                    print.append(numberWrapper.getVal()).append("(").append(numberWrapper.getIdx()).append(")");
                }
                break;
            }
            if (numberWrapper == null) {
                print.append("NULL");
            } else {
                print.append(numberWrapper.getVal()).append("(").append(numberWrapper.getIdx()).append(")").append(", ");
            }
            counter++;
        }
        System.out.println(print);
    }

    private void printArray(NumberWrapper[] array) {
        StringBuilder print = new StringBuilder();
        int counter = array.length;
        for (NumberWrapper  numberWrapper : array) {
            if (counter == array.length - 1) {
                if (numberWrapper == null) {
                    print.append("NULL");
                } else {
                    print.append(numberWrapper.getVal()).append("(").append(numberWrapper.getIdx()).append(")");
                }
                break;
            }
            if (numberWrapper == null) {
                print.append("NULL");
            } else {
                print.append(numberWrapper.getVal()).append("(").append(numberWrapper.getIdx()).append(")").append(", ");
            }
            counter++;
        }
        System.out.println(print);
    }
}
