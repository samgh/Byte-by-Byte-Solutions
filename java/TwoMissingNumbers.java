/*
 * Title: Two Missing Numbers
 * Author: Sam Gavis-Hughson
 * Date: 8/25/2016
 * 
 * Given an unsorted array of numbers from 1 to N with two numbers missing
 * returns the two numbers that are missing.
 * 
 * Execution: javac TwoMissingNumbers.java && java TwoMissingNumbers
 * 
 * For more details, check out http://www.byte-by-byte.com/twomissingnumbers/
 */
import java.util.Arrays;

public class TwoMissingNumbers {
    
    // Determine the single number that is missing. 
    // XOR the actual array and the expected array from 1 to N together. All
    // the repeated numbers cancel out, leaving us with the desired result.
    // (1 ^ 2 ^ ... ^ N-1 ^ N) ^ (1 ^ 2 ^ ... ^ N-1) = N
    public static int oneMissing(int[] arr) {
        int totalXor = 0;
        int arrXor = 0;
        
        // XOR the numbers from 1 to N, ie. the input if no numbers were missing
        for (int i = 1; i <= arr.length + 1; i++) totalXor ^= i;
        
        // XOR the input array
        for (int i : arr) arrXor ^= i;
        
        // XOR the two values together. x^x = 0 and x^0 = x. That means that any
        // repeated number cancels out, so we are left with the single 
        // non-repeated number.
        // eg. (1 ^ 2 ^ ... ^ N-1 ^ N) ^ (1 ^ 2 ^ ... ^ N-1) = N
        return totalXor ^ arrXor;
    }
    
    // Determine the two numbers missing from an array. Returns an array of 
    // length 2
    public static int[] twoMissing(int[] arr) {
        int size = arr.length + 2;
        
        // 1 + 2 + ... + N-1 + N = N * (N + 1) / 2
        long totalSum = size * (size + 1) / 2;
        
        // Sum up the input array
        long arrSum = 0;
        for (int i : arr) arrSum += i;
        
        // totalSum - arrSum = the sum of the two results. Therefore we know 
        // that since our two results are not equal, one result is
        // > (sum of two results) / 2 and the other is 
        // < (sum of two results) / 2
        int pivot = (int) ((totalSum - arrSum) / 2);
        
        // Use the same technique as oneMissing() on each half of the array.
        int totalLeftXor = 0;
        int arrLeftXor = 0;
        int totalRightXor = 0;
        int arrRightXor = 0;
        
        for (int i = 1; i <= pivot; i++) totalLeftXor ^= i;
        for (int i = pivot + 1; i <= size; i++) totalRightXor ^= i;
        for (int i : arr) {
            if (i <= pivot) arrLeftXor ^= i;
            else arrRightXor ^= i;
        }
        
        return new int[]{totalLeftXor ^ arrLeftXor, 
            totalRightXor ^ arrRightXor};
    }
    
    // Sample test cases
    public static void main(String[] args) {
        // oneMissing tests
        assert oneMissing(new int[]{1, 2, 4, 5}) == 3 : 
            "oneMissing: Normal case";
        assert oneMissing(new int[]{3, 2, 5, 4}) == 1 : 
            "oneMissing: Missing first element";
        assert oneMissing(new int[]{4, 3, 2, 1}) == 5 : 
            "oneMissing: Missing last element";
            
        // twoMissing tests
        assert compareArrayValues(twoMissing(new int[]{1, 3, 5}),
                                  new int[]{2, 4}) :
            "twoMissing: Normal case";
        assert compareArrayValues(twoMissing(new int[]{2, 4, 5}),
                                  new int[]{1, 3}):
             "twoMissing: Missing first element";
        assert compareArrayValues(twoMissing(new int[]{3, 1, 2}),
                                  new int[]{4, 5}):
             "twoMissing: Missing last two elements";
        
        System.out.println("Passed all test cases");
    }
    
    // Helper method for tests. Checks if arrays contain the same values
    private static boolean compareArrayValues(int[] a1, int[] a2) {
        if (a1.length != a2.length) return false;
        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }
}