
package com.cleancode.knuth;

public class PrimePrinter {
    public static void main(String[] args) {
        new PrimePrinterHelper().generatePrimes(1000);
    }

    public static final int NUMBER_OF_PRIMES = 1000;

    public static void printNumbers(int[] numbers, int numberOfNumbers) {
        int linesPerPage = 50;
        int columns = 4;
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= numberOfNumbers) {
            System.out.printf("The First %d Prime Numbers === Page %d%n%n", numberOfNumbers, pageNumber);

            for (int rowOffset = pageOffset; rowOffset < pageOffset + linesPerPage
                    && rowOffset <= numberOfNumbers; rowOffset++) {
                for (int column = 0; column < columns; column++) {
                    int index = rowOffset + column * linesPerPage;
                    if (index <= numberOfNumbers) {
                        System.out.printf("%10d", numbers[index]);
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
