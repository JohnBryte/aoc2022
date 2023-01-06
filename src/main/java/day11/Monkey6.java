package day11;

import java.math.BigInteger;

public class Monkey6 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.multiply(oldItem);
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(17L)).equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        return BigInteger.TWO;
    }

    @Override
    public int getDivisor() {
        return 17;
    }
}
