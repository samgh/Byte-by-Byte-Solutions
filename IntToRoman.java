/*
 * Title: Integer to Roman Numerals
 * Author: Sam Gavis-Hughson
 * Date: 2/1/2017
 * 
 * Write a function to convert an integer into its roman numeral representation
 * 
 * Execution: javac IntToRoman.java && java IntToRoman
 * 
 * For more details, check out http://www.byte-by-byte.com/inttoroman/
 */

public class IntToRoman {
    // Parallel arrays of numerals in descending order and their values. We 
    // include any pairs of numerals where a smaller numeral is subtracted from
    // a larger numeral
    private static final String[] numerals = 
        new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", 
        "V", "IV", "I"};
    private static final int[] values =
        new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    
    public static String integerToRoman(int value) {
        // We are only considering the range for standard roman numerals
        if (value > 3999 || value < 1) throw new IllegalArgumentException();
        
        StringBuilder numeral = new StringBuilder();
        int i = 0;
        // Greedily append the largest numeral possible until the value is 0
        while (value > 0) {
            if (value - values[i] >= 0) {
                numeral.append(numerals[i]);
                value -= values[i];
            } else {
                i++;
            }
        }
        
        return numeral.toString();
    }
    
    // Sample test cases
    public static void main(String[] args) {
        assert integerToRoman(1).equals("I");
        assert integerToRoman(4).equals("IV");
        assert integerToRoman(6).equals("VI");
        assert integerToRoman(11).equals("XI");
        assert integerToRoman(49).equals("XLIX");
        assert integerToRoman(2020).equals("MMXX");
        
        System.out.println("Passed all test cases");
    }
}