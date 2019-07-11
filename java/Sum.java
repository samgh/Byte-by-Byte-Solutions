/*
*   Title: Sum
*
*   Given two integers, write a function to sum the numbers without using any arithmetic operators.
*
*   Execution: javac Sum.java && java Sum

*   For more details, check out http://www.byte-by-byte.com/sum
*/

public class Sum {
    public static int sum(int a, int b) {
        if (b == 0){
            return a;
        }
        int partialSum = a ^ b;
        int carry = (a & b) << 1;
        return sum(partialSum, carry);
    }

    // Sample test cases
    public static void main(String[] args) {
        assert sum(1, 1) == 2:
            "1 + 1 = 2";

        assert sum(5, 10) == 15:
            "10 + 5 = 15";

        assert sum(100, 200) == 300:
            "100 + 200 = 300";

        assert sum(3, 2) == 5:
            "3 + 2 = 5";

        System.out.println("Passed all test cases");
    }
}
