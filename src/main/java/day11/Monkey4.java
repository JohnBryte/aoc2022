package day11;

import java.math.BigInteger;

public class Monkey4 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.multiply(BigInteger.valueOf(19L));
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(7L)).equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(7L);
        }
        return BigInteger.valueOf(6L);
    }

    @Override
    public int getDivisor() {
        return 7;
    }
}
