package com.cleancode.knuth;

public class NumberPrinter {
    private final int linesPerPage;
    private final int columns;

    public NumberPrinter(int linesPerPage, int columns) {
        this.linesPerPage = linesPerPage;
        this.columns = columns;
    }

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= numberOfNumbers) {
            System.out.printf("The First %d Numbers === Page %d%n%n", numberOfNumbers, pageNumber);

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
