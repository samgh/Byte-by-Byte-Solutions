/*
 *   Title: Gray Code
 *
 *   Given two integers, write a function to determine whether or not their 
 *   binary representations differ by a single bit. 
 *
 *   Execution: javac GrayCode.java && java GrayCode
 * 
 *   For more details, check out http://www.byte-by-byte.com/graycode/
 */

public class GrayCode {

    public static boolean gray_1(int a, int b) {
        int x = a ^ b;
        while (x > 0) {
            if (x % 2 == 1 && x >> 1 > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean gray_2(int a, int b) {
        int x = a ^ b;
        return (x & (x - 1)) == 0;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        assert gray_1(0, 1) == true;
        assert gray_1(1, 2) == false;

        assert gray_2(0, 1) == true;
        assert gray_2(1, 2) == false;

        System.out.println("Passed all test cases");
    }
}
