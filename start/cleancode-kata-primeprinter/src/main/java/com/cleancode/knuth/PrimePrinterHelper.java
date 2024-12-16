package com.cleancode.knuth;

public class PrimePrinterHelper {

    public static int[] generatePrimes(int numberOfNumbers) {
        int[] primes = new int[numberOfNumbers + 1];
        int[] multiples = new int[30 + 1];

        primes[1] = 2;
        int candidate = 1;
        int primeIndex = 1;
        int ord = 2;
        int square = 9;

        while (primeIndex < numberOfNumbers) {
            boolean isPrime;
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                isPrime = true;
                for (int n = 2; n < ord && isPrime; n++) {
                    while (multiples[n] < candidate) {
                        multiples[n] += primes[n] + primes[n];
                    }
                    if (multiples[n] == candidate) {
                        isPrime = false;
                    }
                }
            } while (!isPrime);

            primeIndex++;
            primes[primeIndex] = candidate;
        }

        return primes;
    }
}
