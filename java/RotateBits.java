/*
 *   Title: Rotate bits
 *
 *   Given a number, write a function to rotate the bits (ie circular shift).
 * 
 *   Execution: javac RotateBits.java && java RotateBits
 * 
 *   For more details, check out http://www.byte-by-byte.com/rotatebits/
 */



public class RotateBits {
    private static final int BITS_IN_INTEGER = 32;
    public static int rotate(int x, int N) {
        N = N % BITS_IN_INTEGER;
        return (x >> N | x << (BITS_IN_INTEGER - N));
    }
    
    public static void main(String[] args) {
        assert rotate(0xFFFF0000, 8) == 0x00FFFF00;
        assert rotate(0x13579BDF, 12) == 0xBDF13579;
        assert rotate(0b10110011100011110000111110000000, 17) == 0b00011111000000010110011100011110;

        System.out.println("Passed all test cases");
    }
}
