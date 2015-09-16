/**
 * Created by perilon on 9/10/15.
 */

import java.io.*;
import java.util.*;

public class Solution02 {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter a string: ");
        BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
        String str1 = input1.readLine();
        System.out.print("Enter another string: ");
        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        String str2 = input2.readLine();

        System.out.println("It is " + Boolean.toString(isAPermutation(str1, str2)) + " that " +
                "each string is a permutation of the other.");
    }

    public static boolean isAPermutation(String s1, String s2) {

//        For each string, create a dictionary (TreeMap) with a key for each unique character
//        in the string and values being the number of occurrences of each character.  Check for equality
//        between the two TreeMaps.

        Map<Character, Integer> map1 = new TreeMap<Character, Integer>();
        Map<Character, Integer> map2 = new TreeMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map1.get(c) == null) {
                map1.put(c, 1);
            }
            else {
                int curVal = map1.get(c);
                map1.put(c, curVal + 1);
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map2.get(c) == null) {
                map2.put(c, 1);
            }
            else {
                int curVal = map2.get(c);
                map2.put(c, curVal + 1);
            }
        }

        boolean answer = map1.equals(map2);

        return answer;
    }

}