package day11;

import java.math.BigInteger;

public class Monkey5 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.add(BigInteger.valueOf(5L));
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(3L)).equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(4L);
        }
        return BigInteger.ONE;
    }

    @Override
    public int getDivisor() {
        return 3;
    }
}
