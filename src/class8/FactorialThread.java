package class8;

import java.math.BigInteger;

public class FactorialThread extends Thread {
    private long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean finished = Boolean.FALSE;

    FactorialThread(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        this.result = factorial(inputNumber);
        this.finished = Boolean.TRUE;
    }

    private BigInteger factorial(long inputNumber) {
        BigInteger tempResult = BigInteger.ONE;
        for (long i = inputNumber; i > 0; i--) {
            tempResult = tempResult.multiply(BigInteger.valueOf(i));
        }
        return tempResult;
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return finished;
    }
}
