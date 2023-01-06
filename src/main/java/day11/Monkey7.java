package day11;

import java.math.BigInteger;

public class Monkey7 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.add(BigInteger.ONE);
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(19L)).equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(6L);
        }
        return BigInteger.ZERO;
    }

    @Override
    public int getDivisor() {
        return 19;
    }
}
