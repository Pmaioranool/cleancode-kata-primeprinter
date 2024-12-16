package com.cleancode.knuth;

public class PrimePrinterHelper {

    private static final int NUMBER_OF_PRIMES = 1000;

    private static int[] generatePrimes(int numberOfPrimes) {
        int[] primes = new int[numberOfPrimes + 1];
        int[] multiples = new int[30 + 1];

        primes[1] = 2;
        int candidate = 1;
        int primeIndex = 1;
        int ord = 2;
        int square = 9;

        while (primeIndex < numberOfPrimes) {
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

    // Extracted number printing logic
    private static void printPrimes(int[] primes, int numberOfPrimes) {
        int linesPerPage = 50;
        int columns = 4;
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= numberOfPrimes) {
            System.out.printf("The First %d Prime Numbers === Page %d%n%n", numberOfPrimes, pageNumber);

            for (int rowOffset = pageOffset; rowOffset < pageOffset + linesPerPage
                    && rowOffset <= numberOfPrimes; rowOffset++) {
                for (int column = 0; column < columns; column++) {
                    int index = rowOffset + column * linesPerPage;
                    if (index <= numberOfPrimes) {
                        System.out.printf("%10d", primes[index]);
                    }
                }
                System.out.println();
            }

            System.out.println("\n\f");
            pageNumber++;
            pageOffset += linesPerPage * columns;
        }
    }
}
