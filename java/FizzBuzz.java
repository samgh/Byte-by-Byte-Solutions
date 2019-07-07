/*
*   Title: FizzBuzz
*
*   Output numbers from 1 to x. If the number is divisible by 3, replace it with 
*   “Fizz”. If it is divisible by 5, replace it with “Buzz”. If it is divisible 
*   by 3 and 5 replace it with “FizzBuzz”.

*   Execution: javac FizzBuzz.java && java FizzBuzz

*   For more details, check out http://www.byte-by-byte.com/fizzbuzz
*/

public class FizzBuzz {
    public static String fizzBuzz(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(i);
        }
    }

    // Sample test cases
    public static void main(String[] args) {
        assert fizzBuzz(1) == "1":
            "1 produces 1.";
        assert fizzBuzz(2) == "2":
            "2 produces 2.";
        assert fizzBuzz(3) == "Fizz":
            "3 produces Fizz.";
        assert fizzBuzz(5) == "Buzz":
            "5 produces Buzz";
        assert fizzBuzz(9) == "Fizz":
            "9 produces Fizz";
        assert fizzBuzz(15) == "FizzBuzz":
            "15 produces FizzBuzz";

        System.out.println("Passed all test cases");
    }
}
