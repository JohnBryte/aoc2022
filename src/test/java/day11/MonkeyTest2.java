package day11;

import java.math.BigInteger;

public class MonkeyTest2 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.multiply(oldItem);
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(13L)).equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(3L);
    }

    @Override
    public int getDivisor() {
        return 13;
    }
}
