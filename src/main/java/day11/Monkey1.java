package day11;

import java.math.BigInteger;

public class Monkey1 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.add(BigInteger.valueOf(8L));
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(11L)).equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(4L);
        }
        return BigInteger.valueOf(7L);
    }

    @Override
    public int getDivisor() {
        return 11;
    }
}
