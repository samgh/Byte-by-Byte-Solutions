/*
 *   Title: Fibonacci
 *
 *   Given an integer n, write a function to compute the nth Fibonacci number.
 * 
 *   Execution: javac Fibonacci.java && java Fibonacci
 * 
 *   For more details, check out http://www.byte-by-byte.com/fibonacci/
 */

public class Fibonacci {
    public static long fibonacci(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        long [] cache = new long[x + 1];
        for (int i = 1; i < cache.length; i++) {
            cache[i] = -1;
        }
        cache[1] = 1;

        return fibonacci(x, cache);
    }
    public static long fibonacci(int x, long[] cache){ 
        if (cache[x] > -1) {
            return cache[x];
        }
        cache[x] = fibonacci(x-1, cache) + fibonacci(x-2, cache);
        return cache[x];
    }

    
    // Sample test cases
    public static void main(String[] args) {
        assert fibonacci(1) == 1;
        assert fibonacci(5) == 5;
        assert fibonacci(10) == 55;

        System.out.println("Passed all test cases");
    }
}
