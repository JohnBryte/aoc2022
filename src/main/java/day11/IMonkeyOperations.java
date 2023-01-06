package day11;

import java.math.BigInteger;

public interface IMonkeyOperations {
    BigInteger doOperation(BigInteger oldItem);
    BigInteger doTest(BigInteger itemToTest);
    int getDivisor();
}
