/**
 * Created by perilon on 9/10/15.
 */

import java.io.*;
import java.util.*;

public class Solution04 {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter a string: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputString = input.readLine();

//        In following the example of "Tact Coa", which is shown to produce "true", it is
//        necessary to remove spaces and ignore differences of case.

        String noSpacesString = inputString.replaceAll("\\s","");
        String allLowerNoSpacesString = noSpacesString.toLowerCase();

        System.out.println("It is " + Boolean.toString(isAPalindromePermutation(allLowerNoSpacesString)) +
                " that the string is a permutation of a palindrome.");
    }

    public static boolean isAPalindromePermutation(String s) {

//        A string is a permutation of a palindrome if and only if it contains zero or more
//        characters whose number of occurrences is odd.  A HashMap is used to count occurrences.

        boolean answer = true;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, 1);
            }
            else {
                int curVal = map.get(c);
                map.put(c, curVal + 1);
            }
        }

        int numOdd = 0;

        for (int value : map.values()) {
            if (value % 2 == 1) {
                numOdd++;
            }
        }

        if (numOdd > 1) {
            answer = false;
            return answer;
        }
        else {
            return answer;
        }
    }
}
