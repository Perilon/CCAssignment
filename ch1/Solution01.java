/**
 * Created by perilon on 9/10/15.
 */

import java.io.*;

public class Solution01 {

    public static void main(String[] args) throws IOException {
        String inputString;
        System.out.print("Enter a string: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        inputString = input.readLine();

        boolean allUnique = true;
        int i = 0;
        String temp = "";

//        For each character in the string, add the character to string "temp" and iterate through (all but
//        the newest character of) temp to see if the character already exists in it.

        while (i < inputString.length() && allUnique == true) {

            char c = inputString.charAt(i);
            temp += c;

            for (int n = 0; n < temp.length()-1; n++) {

                if (temp.charAt(n) == c) {

                    allUnique = false;
                }
            }
            i++;
        }
        System.out.println("It is " + Boolean.toString(allUnique) + " that the string has all unique characters.");
    }
}