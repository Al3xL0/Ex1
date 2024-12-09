import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    // lists of the legit digits and bases.
    private static ArrayList<Character> legit_digits = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D','E','F', 'G'));
    private static ArrayList<Character> legit_bases = new ArrayList<>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D','E','F', 'G'));


    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        // add your code here
        if(!isNumber(num)) {
            return ans;
        }
        String number = num.substring(0, num.indexOf('b'));
        char base = num.charAt(num.length()-1);
        // because the range of bases is 2-16.
        int base_in_int = legit_bases.indexOf(base) + 2;
        ans = Integer.parseInt(number, base_in_int);
        ////////////////////
        return ans;
    }
    private static boolean isAllDigitsValid(String a , boolean isBaseMentioned) {
        boolean ans = true;
        int index;
        char base;
        if(isBaseMentioned) {
            index = a.indexOf('b');
            base = a.charAt(a.length()-1);
        } else {
            index = a.length()-1;
            base = 'A';
        }
        for(int i=0; i<index; i++) {
            System.out.println(a);
            char current_char = a.charAt(i);
            if(!legit_digits.contains(current_char)){
                ans=false;
                break;
            }
            if(legit_digits.indexOf(base) <= legit_digits.indexOf(current_char)){
                ans = false;
                break;
            }
        }
        if(index == 0 && a.charAt(0) == 'A' ) {
            ans=false;
        }
        return ans;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        // add your code here
        int cnt = 0;
        boolean isBaseMentioned = a.contains("b");
        char base;
        // a way to check if base mentioned twice
        int times_base_mentioned = a.length() - a.replaceAll("b","").length();
        if(isBaseMentioned) {
            if(a.indexOf("b") == 0 || times_base_mentioned>1) {
                ans = false;
            } else {
                base = a.charAt(a.length()-1);
                if(!legit_bases.contains(base)) {
                    ans = false;
                } else {
                    ans = isAllDigitsValid(a, isBaseMentioned);
                }
            }

        } else {
            ans = isAllDigitsValid(a, isBaseMentioned);
        }
        ////////////////////
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        int remainder = 0;
        // add your code here
        if(base<2 || base>16) {
            return ans;
        }
        if(num == 0) {
            ans = "0b" + base;
        }
        while(num!=0) {
            remainder = num%base;
            ans = Character.toString(legit_digits.get(remainder)) + ans;
            num /= base;
        }
        if(!ans.equals("")) {
            ans = ans + "b" + legit_bases.get(base-2);
        }

        ////////////////////
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        // add your code here
        int num1 = number2Int(n1);
        int num2 = number2Int(n2);
        if (num1 != num2) {
            ans = false;
        }
        ////////////////////
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        // add your code here

        ////////////////////
        return ans;
    }
}