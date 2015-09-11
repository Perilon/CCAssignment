/**
 * Created by perilon on 9/11/15.
 */

import java.io.*;

public class Solution06 {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter a string: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputString = input.readLine();

        String compressedString = compressString(inputString);

        if (inputString.length() < compressedString.length()) {
            System.out.print("Output: " + inputString);
        }
        else if (inputString.length() > compressedString.length()) {
            System.out.print("Output: " + compressedString);
        }
        else {
            System.out.println("Output: The two strings are of equal length; the compressed " +
                    "string is " + compressedString);
        }
    }

    public static String compressString(String s) {

        String compressedString = "";

//        For each character in the string, iterate through the remaining characters until coming to
//        one that is not the same as the starting character, adding to a counter that keeps track of
//        repetitions of characters.  Add the starting character and the counter to the compressed
//        string.  Jump ahead an appropriate number of places in the outer loop when there have been
//        repeated characters.

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int counter = 1; // There is always at least one of a specific character in a row.
            for (int j = i + 1; j < s.length(); j++) {

                if (s.charAt(j) == c) {
                    counter++;
                }
                else {
                    break;
                }
            }

            compressedString += c;
            compressedString += (counter);

            if (counter > 1) { // If the character is repeated, jump ahead in the original string.
                i += (counter - 1);
            }
        }

        return compressedString;
    }
}
