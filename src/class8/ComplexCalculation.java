package class8;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result = BigInteger.ZERO;
        /*
         * Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
         * Where each calculation in (..) is calculated on a different thread
         */
        PowerCalculatingThread thread1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread thread2 = new PowerCalculatingThread(base2, power2);
        try {
            startThread(thread1);
            startThread(thread2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = thread1.getResult().add(thread2.getResult());
        return result;
    }

    private static void startThread(Thread thread) {
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = pow(base, power);
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger tempResult = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                tempResult = tempResult.multiply(base);
            }
            return tempResult;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
