package day11;

import java.math.BigInteger;
import java.util.List;

public class Monkey {
    List<BigInteger> items;
    IMonkeyOperations monkeyOperations;
    int inspectionCounter = 0;

    public Monkey(List<BigInteger> items, IMonkeyOperations monkeyOperations) {
        this.items = items;
        this.monkeyOperations = monkeyOperations;
    }

    public List<BigInteger> getItems() {
        return items;
    }

    public void setItems(List<BigInteger> items) {
        this.items = items;
    }

    public IMonkeyOperations getMonkeyOperations() {
        return monkeyOperations;
    }

    public void setMonkeyOperations(IMonkeyOperations monkeyOperations) {
        this.monkeyOperations = monkeyOperations;
    }

    public int getInspectionCounter() {
        return inspectionCounter;
    }

    public void setInspectionCounter(int inspectionCounter) {
        this.inspectionCounter = inspectionCounter;
    }

    public void inspect() {
        inspectionCounter++;
    }

    public BigInteger doOperation(BigInteger item) {
        return monkeyOperations.doOperation(item);
    }

    public BigInteger doTest(BigInteger item) {
        return monkeyOperations.doTest(item);
    }

    public int getDivisor() {
        return monkeyOperations.getDivisor();
    }

    public void addNewItem(BigInteger newItem) {
        items.add(newItem);
    }
}
