/*
 *   Title: String compression
 *
 *   Given a string, write a function to compress it by shortening every 
 *   sequence of the same character to that character followed by the number 
 *   of repetitions. If the compressed string is longer than the original, 
 *   you should return the original string.
 *
 *   Execution: javac StringCompression.java && java StringCompression
 * 
 *   For more details, check out http://www.byte-by-byte.com/stringcompression/
 */

public class StringCompression {
    public static String compress(String s){ 
        String out = "";
        int sum = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                sum++;
            } else {
                out = out + s.charAt(i) + sum;
                sum = 1;
            }
        }
        out = out + s.charAt(s.length() - 1) + sum;
        return out.length() < s.length() ? out : s;
    }

    
    // Sample test cases
    public static void main(String[] args) {
        assert compress("a") == "a";
        assert compress("aaa") == "a3";
        assert compress("aaabbb") == "a3b3";
        assert compress("aaabccc") == "a3b1c3";

        System.out.println("Passed all test cases");
    }
}
