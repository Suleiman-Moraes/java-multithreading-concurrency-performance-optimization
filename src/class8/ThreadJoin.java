package class8;

import java.util.List;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        final List<Long> inputNumbers = List.of(100000000000000L, 3435L, 35435L, 2324L, 4656L, 23L, 245L, 5566L);
        final List<FactorialThread> threads = inputNumbers.stream().map(FactorialThread::new).toList();

        for (FactorialThread thread : threads) {
            thread.setDaemon(Boolean.TRUE);
            thread.start();
            thread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            final FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println(
                        String.format("Factorial of %s is %s", inputNumbers.get(i), factorialThread.getResult()));
            } else {
                System.out.println(String.format("The calculation for %s has not finished", inputNumbers.get(i)));
            }
        }
    }
}
