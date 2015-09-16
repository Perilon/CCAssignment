import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by perilon on 9/15/15.
 */

public class Solution08 {

    public static void main(String[] args) throws IOException {

        int[][] testMatrix = {{1, 2, 0, 4, 0, 1}, {3, 4, 5, 5, 5, 8}, {1, 2, 1, 1, 7, 0}, {1, 2, 3, 3, 3, 9}};

        System.out.println("Here's a prespecified test matrix for this problem: ");
        printMatrix(testMatrix);
        System.out.println("\nNow here's the same matrix after performing this problem's operation: ");
        Zeroize(testMatrix);
        printMatrix(testMatrix);

//        Generate a random matrix with number of rows and columns between 1 and 9, inclusive

        int numRowsRandom = ThreadLocalRandom.current().nextInt(1, 10);
        int numColumnsRandom = ThreadLocalRandom.current().nextInt(1, 10);

        int[][] randomMatrix = initializeRandomMatrix(numRowsRandom, numColumnsRandom);

        System.out.println("\nHere's a randomly generated matrix: ");
        printMatrix(randomMatrix);
        System.out.println("\nAnd now here's the same matrix after performing this problem's operation: ");
        Zeroize(randomMatrix);
        printMatrix(randomMatrix);

    }

//    Generates a matrix with specified numbers of rows and columns, with values between 0 and 9, inclusive

    public static int[][] initializeRandomMatrix(int numRows, int numColumns) {

        int[][] randMatrix = new int[numRows][numColumns];

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                randMatrix[r][c] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }

        return randMatrix;
    }

//    Displays a matrix in a basic fashion

    public static void printMatrix(int[][] intMNArray) {

        for (int m = 0; m < intMNArray.length; m++) {
            for (int n = 0; n < intMNArray[m].length; n++) {
                if (n == intMNArray[m].length - 1) {
                    System.out.print(intMNArray[m][n] + "\n");
                }
                else {
                    System.out.print(intMNArray[m][n] + " ");
                }
            }
        }
    }

//    Keeps a set each of row numbers and column numbers in which all values should be set to zero.
//    Iterates through the matrix setting values in those specified rows and columns to zero.

    public static void Zeroize(int[][] intMNArray) {

        Set<Integer> rowsToZeroize = new HashSet<Integer>();
        Set<Integer> columnsToZeroize = new HashSet<Integer>();

        for (int m = 0; m < intMNArray.length; m++) {
            for (int n = 0; n < intMNArray[m].length; n++) {
                if (intMNArray[m][n] == 0) {
                    rowsToZeroize.add(m);
                    columnsToZeroize.add(n);
                }
            }
        }

        for (int m = 0; m < intMNArray.length; m++) {
            for (int n = 0; n < intMNArray[m].length; n++) {
                if (rowsToZeroize.contains(m)) {
                    intMNArray[m][n] = 0;
                }
                if (columnsToZeroize.contains(n) && intMNArray[m][n] != 0) {
                    intMNArray[m][n] = 0;
                }
            }
        }
    }

}
