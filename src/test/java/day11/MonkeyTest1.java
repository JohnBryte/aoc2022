package day11;

import java.math.BigInteger;

public class MonkeyTest1 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.add(BigInteger.valueOf(6L));
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(19L)).equals(BigInteger.ZERO)) {
            return BigInteger.TWO;
        }
        return BigInteger.ZERO;
    }

    @Override
    public int getDivisor() {
        return 19;
    }
}
