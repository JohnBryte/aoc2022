package day11;

import java.math.BigInteger;

public class Monkey3 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.add(BigInteger.valueOf(4L));
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(13L)).equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(5L);
    }

    @Override
    public int getDivisor() {
        return 13;
    }
}
