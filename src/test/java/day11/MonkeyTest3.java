package day11;

import java.math.BigInteger;

public class MonkeyTest3 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.add(BigInteger.valueOf(3L));
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(17L)).equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        return BigInteger.ONE;
    }

    @Override
    public int getDivisor() {
        return 17;
    }
}
