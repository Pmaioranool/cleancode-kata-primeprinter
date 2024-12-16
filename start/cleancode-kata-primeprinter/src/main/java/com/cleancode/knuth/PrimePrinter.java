package com.cleancode.knuth;

public class PrimePrinter {
    public static final int NUMBER_OF_PRIMES = 1000;

    public static void printNumbers(int[] numbers, int numberOfNumbers) {
        NumberPrinter printer = new NumberPrinter(50, 4);
        printer.printNumbers(numbers, numberOfNumbers);
    }
}
