package day11;

import java.math.BigInteger;

public class Monkey2 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.add(BigInteger.TWO);
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(5L);
        }
        return BigInteger.valueOf(3L);
    }

    @Override
    public int getDivisor() {
        return 2;
    }
}
