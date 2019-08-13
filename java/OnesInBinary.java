/*
*   Title: Number of ones in binary representation.
*
*   Given an integer, write a function to compute the number of ones 
*   in the binary representation of the number.
*
*   Execution: javac OnesInBinary.java && java OnesInBinary

*   For more details, check out http://www.byte-by-byte.com/fizzbuzz
*/

public class OnesInBinary {
    public static int onesInBinary(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x & 1;
            x >>= 1;
        }
        return sum;
    }

    // Sample test cases
    public static void main(String[] args) {
        assert onesInBinary(5) == 2:
            "Binary representation of 5 has 2 ones.";
        assert onesInBinary(12) == 2:
            "Binary representation of 12 has 2 ones.";
        assert onesInBinary(255) == 8:
            "Binary representation of 255 has 8 ones.";
        assert onesInBinary(256) == 1:
            "Binary representation of 256 has 1 ones.";

        System.out.println("Passed all test cases");
    }
}
