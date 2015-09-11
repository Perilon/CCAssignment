/**
 * Created by perilon on 9/11/15.
 */

import java.io.*;

class Whoops extends Exception {
    public Whoops(String message) {
        super(message);
    }
}

//This solution assumes that no more than one space separates pairs of words in the "true" input.

public class Solution03 {

    public static void main(String[] args) throws IOException, Whoops {

        System.out.print("Input a string with the appropriate number of spaces at the end: ");
        BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
        String inputString = input1.readLine();
        System.out.print("Input the \"true\" length of the string: ");
        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        String temp = input2.readLine();
        int inputInt = Integer.parseInt(temp);

//        The input string is converted to a character array for the URLify method and back to a string
//        for printing the answer.  The URLify method itself does the operation in place, as specified.

        char[] inputCharArray = inputString.toCharArray();

//        Check that the number given as the "true" length is not inaccurate.

        validateInputInt(inputCharArray, inputInt);

        char[] charArrayAnswer = URLify(inputCharArray, inputInt);
        String stringAnswer = new String(charArrayAnswer);

        System.out.println("The URLified output is: " + stringAnswer);
    }

    public static char[] URLify(char[] charArray, int trueLength) throws Whoops {

        int endOfCharsIndex = trueLength - 1;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ' ) {
                for (int j = endOfCharsIndex; j > i; j--) {
                    if ((j + 2) >= charArray.length) {

//                        Make sure there's enough extra space at the end to accommodate adding the "%20" markers
//                        and shifting the remaining characters over.

                        throw new Whoops("There are not enough spaces after the end of the \"true\" input \n" +
                                "to accommodate adding the \"%20\" marker(s).  Try again.");
                    }

                    charArray[j + 2] = charArray[j];
                }

                charArray[i] = '%';
                charArray[i + 1] = '2';
                charArray[i + 2] = '0';

//                The end of the "true" input is now shifted right by 2.

                endOfCharsIndex += 2;
            }
        }

        return charArray;
    }

    public static void validateInputInt(char[] charArray, int trueLength) throws Whoops {

//        Self-explanatory?.

        int endSpacesCounter = 0;

        for (int k = charArray.length - 1; k >= 0; k--) {
            if (charArray[k] == ' ') {
                endSpacesCounter++;
            } else {
                break;
            }
        }

        int endOfCharsIndexCalc = charArray.length - endSpacesCounter - 1;
        int endOfCharsIndex = trueLength - 1;

        if (endOfCharsIndex != endOfCharsIndexCalc) {
            throw new Whoops("The value that was input as the \"true\" length does not match the total \n" +
                    "length of the input minus any consecutive spaces at the end of the input.  Try again.");
        }
    }
}
