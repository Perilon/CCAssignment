import java.io.*;

/**
 * Created by perilon on 9/15/15.
 */
public class Solution09 {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter a string: ");
        BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
        String str1 = input1.readLine();
        System.out.print("Enter another string: ");
        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        String str2 = input2.readLine();


        boolean answer = isARotation(str1, str2);

        System.out.println("It is " + Boolean.toString(answer) + " that " + str1 + " is a rotation of "
        + str2 + ".");

    }

//    If s2 is a rotation of s1, then s2 will appear somewhere in s1 + s2, because that string will contain
//    both the beginning part and the concluding part of s2 in the same order as s2, no matter where
//    that split occurs.  They need to be of the same length, clearly, also.

    public static boolean isARotation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        String s1Doubled = s1 + s1;

        return s1Doubled.contains(s2);

    }



}
