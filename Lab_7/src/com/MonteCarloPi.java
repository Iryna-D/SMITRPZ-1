package com;

public class MonteCarloPi {
    long startTime, finishTime;

    public double getPi(int threadsCount) throws InterruptedException {
        startTime = System.currentTimeMillis();
        int passedTotal = 0;
        int iterationsTotal = 10000000;
        int iterationsPerProcess = iterationsTotal / threadsCount;
        CustomThread[] customThreads = new CustomThread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            customThreads[i] = new CustomThread(iterationsPerProcess);
            customThreads[i].start();
        }

        for (CustomThread customThread : customThreads) {
            customThread.join();
            passedTotal += customThread.passed;
        }

        double pi = ((double) passedTotal / iterationsTotal) * 4.0;
        finishTime = System.currentTimeMillis() - startTime;
        System.out.println("PI is " + pi + "\n" + "THREADS " + threadsCount + "\n" + "ITERATIONS " + iterationsTotal + "\n" + "TIME " + finishTime + "ms" + "\n");
        return pi;
    }
}
