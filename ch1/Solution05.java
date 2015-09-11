/**
 * Created by perilon on 9/10/15.
 */

import java.io.*;

public class Solution05 {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter a string: ");
        BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
        String str1 = input1.readLine();
        System.out.print("Enter another string: ");
        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        String str2 = input2.readLine();

        int editDistance = levenshteinDistance(str1, str2);
        boolean answer = true;

        if (editDistance > 1) {
            answer = false;
        }

        System.out.println("It is " + Boolean.toString(answer) + " that the two strings are zero " +
                "or one edits apart.  The edit distance is " + Integer.toString(editDistance) + ".");
    }

    public static void findMinCost(String hyp, String ref, int i, int j, int[][] grid) {

//        Find the edit distance value for a cell based on previous cells' values.
//        Substitution, insertion and deletion costs are each 1.

        if (ref.charAt(i-1) == hyp.charAt(j-1)) {  // If the characters are the same, the edit distance is 0.
            grid[i][j] = grid[i-1][j-1];
        }
        else {
            int substitution = grid[i-1][j-1] + 1;
            int insertion = grid[i][j-1] + 1;
            int deletion = grid[i-1][j] + 1;
            grid[i][j] = Math.min(Math.min(substitution, insertion), deletion);
        }
    }

    public static int levenshteinDistance(String ref, String hyp) {
        int lenRef = ref.length();
        int lenHyp = hyp.length();
        int[][] grid = new int[lenRef+1][lenHyp+1];

//        Initialize the values along the sides of the array.

        for (int i = 0; i < lenRef + 1; i++) {
            for (int j = 0; j < lenHyp + 1; j++) {
                if (i == 0) {
                    grid[0][j] = j;
                }
                else {  // j == 0
                    grid[i][0] = i;
                }
            }
        }

//        Fill in the grid the dynamic programming way.

        for (int i = 1; i < lenRef + 1; i++) {
            for (int j = 1; j < lenHyp + 1; j++) {
                findMinCost(hyp, ref, i, j, grid);
            }
        }

        return grid[lenRef][lenHyp];
    }
}
