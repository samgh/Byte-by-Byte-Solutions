/*
 * Title: Find Duplicates
 * Author: Sam Gavis-Hughson
 * Date: 2/20/2017
 * 
 * Given an array of integers where each value 1 <= x <= len(array), write a 
 * function that finds all the duplicates in the array.
 * 
 * Execution: javac FindDuplicates.java && java FindDuplicates
 * 
 * For more details, check out http://www.byte-by-byte.com/findduplicates/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    
    // Return a list of duplicates in the array. To avoid using extra space,
    // we flag which elements we've seen before by negating the value at
    // indexed at that value in the array.
    public static List<Integer> findDuplicates(int[] arr) {
        // Use a set for results to avoid duplicates
        Set<Integer> resultSet = new HashSet<Integer>();
        
        for (int i = 0; i < arr.length; i++) {
            // Translate the value into an index (1 <= x <= len(arr))
            int index = Math.abs(arr[i]) - 1;
            
            // If the value at that index is negative, then we've already seen
            // that value so it's a duplicate. Otherwise, negate the value at
            // that index so we know we've seen it
            if (arr[index] < 0) {
                resultSet.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }
        
        // Return the array to it's original state
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }
        
        return new ArrayList(resultSet);
    }
    
    // Sample test cases
    public static void main(String[] args) {
        assert compareArrayAndListValues(findDuplicates(new int[]{1}), new int[]{}):
            "Length 1, no duplicates";
        assert compareArrayAndListValues(findDuplicates(new int[]{1, 2}), new int[]{}):
            "Length 2, no duplicates";
        assert compareArrayAndListValues(findDuplicates(new int[]{1, 1}), new int[]{1}):
            "Length 2, duplicates";
        assert compareArrayAndListValues(findDuplicates(new int[]{1, 2, 3, 4}), new int[]{}):
            "Length 4, no duplicates";
        assert compareArrayAndListValues(findDuplicates(new int[]{1, 1, 2, 3}), new int[]{1}):
            "Length 4, one duplicate";
        assert compareArrayAndListValues(findDuplicates(new int[]{1, 1, 2, 2}), new int[]{1, 2}):
            "Length 4, two duplicates";
        assert compareArrayAndListValues(findDuplicates(new int[]{1, 1, 1, 1}), new int[]{1}):
            "Length 4, repeated 4 times";
        
        System.out.println("Passed all test cases");
    }
    
    // Compare the values in an integer list with the values in an int array
    private static boolean compareArrayAndListValues(List<Integer> l, int[] a) {
        Arrays.sort(a);
        Collections.sort(l);
        
        if (l.size() != a.length) return false;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != a[i]) return false;
        }
        
        return true;
    }
}