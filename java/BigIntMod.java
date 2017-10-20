/*
 * Title: Big Int Mod
 * Author: Sam Gavis-Hughson
 * Date: 11/13/2016
 * 
 * Given a list of bytes a, each representing one byte of a larger integer 
 * (ie. {0x12, 0x34, 0x56, 0x78} represents the integer 0x12345678), and an 
 * integer b, find a % b.
 * 
 * Execution: javac BigIntMod.java && java BigIntMod
 * 
 * For more details, check out http://www.byte-by-byte.com/bigintmod/
 */

public class BigIntMod {
    // Compute the mod. We use a char array as it is equivalent to an array of 
    // unsigned bytes
    public static int mod(char[] a, int b) {
        // If input is null, let's just return 0
        if (a == null) return 0;
        int m = 0;
        // Start with modding the most significant byte, then repeatedly shift
        // left. This way our value never gets larger than an int
        for (int i = 0; i < a.length; i++) {
            m <<= 8;
            m += (a[i] & 0xFF);
            m %= b;
        }
        return m;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        assert mod(null, 1) == 0:
            "Null value";
        assert mod(new char[]{}, 1) == 0:
            "Empty array";
        assert mod(new char[]{15}, 10) == 5:
            "Single element array";
        assert mod(new char[]{0x03, 0xED}, 10) == 5:
            "Multi-element array";
        
        System.out.println("Passed all test cases");
    }
}