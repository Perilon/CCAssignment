import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by perilon on 9/15/15.
 */
public class Solution07 {

    public static void main(String[] args) throws IOException {

        int[][] testMatrix = {{1, 2, 0, 4, 0, 1}, {3, 4, 5, 5, 5, 8}, {1, 2, 1, 1, 7, 0}, {1, 2, 3, 3, 3, 9},
                {4, 7, 4, 7, 3, 6}, {9, 2, 0, 2, 0, 2}};

        System.out.println("Here's a prespecified test matrix for this problem: ");
        printMatrix(testMatrix);
        System.out.println("\nNow here's the same matrix after performing this problem's operation: ");
        rotate(testMatrix, 6);
        printMatrix(testMatrix);

//        Generate a random matrix with number of rows and columns between 1 and 9, inclusive

        int numRowsAndColumns = ThreadLocalRandom.current().nextInt(1, 10);

        int[][] randomMatrix = initializeRandomMatrix(numRowsAndColumns);

        System.out.println("\nHere's a randomly generated matrix: ");
        printMatrix(randomMatrix);
        System.out.println("\nAnd now here's the same matrix after performing this problem's operation: ");
        rotate(randomMatrix, numRowsAndColumns);
        printMatrix(randomMatrix);
    }

    //    Generates a matrix with N rows and N columns, with values between 0 and 9, inclusive

    public static int[][] initializeRandomMatrix(int N) {

        int[][] randMatrix = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
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

    public static int[][] rotate(int[][] matrix, int N) {

//        I realized this part is unnecessary because if N is odd, the one cell in the middle doesn't need
//        to be operated on by this function; it will stay in place and not change value
//
//        int numLayers;
//        if (N % 2 == 0) {
//            numLayers = N / 2;
//        }
//        else {
//            numLayers = (N / 2) + 1;
//        }

        int numLayers = (N / 2);

//        Starting from the outside concentric square of elements and working inward through concentric
//        squares (layers), shift the elements along each side iteratively to the side clockwise to that side.
//        The indices of the elements must be managed with respect to how many elements are in a row/column
//        and where those elements begin and end relative to the full length of the row/column, as a function
//        of which concentric layer the algorithm is in.

        for (int L = 0; L < numLayers; ++L) {

            int initElIndex = L;
            int lastElIndex = N - 1 - L;

            for (int i = initElIndex; i < lastElIndex; ++i) {

                int flipped = i - initElIndex;

                int topPart = matrix[initElIndex][i];

//                left side to top side
                matrix[initElIndex][i] = matrix[lastElIndex - flipped][initElIndex];

//                bottom side to left side
                matrix[lastElIndex - flipped][initElIndex] = matrix[lastElIndex][lastElIndex - flipped];

//                right side to bottom side
                matrix[lastElIndex][lastElIndex - flipped] = matrix[i][lastElIndex];

//                top side to right side
                matrix[i][lastElIndex] = topPart;
            }
        }
        return matrix;
    }
}
