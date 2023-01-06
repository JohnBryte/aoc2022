package day11;

import java.math.BigInteger;

public class MonkeyTest0 implements IMonkeyOperations {
    @Override
    public BigInteger doOperation(BigInteger oldItem) {
        return oldItem.multiply(BigInteger.valueOf(19L));
    }

    @Override
    public BigInteger doTest(BigInteger itemToTest) {
        if (itemToTest.mod(BigInteger.valueOf(23L)).equals(BigInteger.ZERO)) {
            return BigInteger.TWO;
        }
        return BigInteger.valueOf(3L);
    }

    @Override
    public int getDivisor() {
        return 23;
    }
}
