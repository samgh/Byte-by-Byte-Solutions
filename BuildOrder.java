/*
 * Title: Build Order
 * Author: Sam Gavis-Hughson
 * Date: 10/16/2016
 * 
 * Given a list of packages and their dependencies, determine a valid build
 * order.
 * 
 * Execution: javac BuildOrder.java && java BuildOrder
 * 
 * For more details, check out http://www.byte-by-byte.com/buildorder/
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BuildOrder {
    
    // Perform topological sort
    // Input is a list of dependencies where the index is the process number
    // and the value is the numbers the processes it depends on
    public static List<Integer> buildOrder(int[][] processes) {
        Set<Integer> temporaryMarks = new HashSet<Integer>();
        Set<Integer> permanentMarks = new HashSet<Integer>();
        List<Integer> result = new LinkedList<Integer>();
        
        // Recursively search from any unmarked node
        for (int i = 0; i < processes.length; i++) {
            if (!permanentMarks.contains(i)) {
                visit(i, processes, temporaryMarks, permanentMarks, result);
            }
        }
        
        return result;
    }
    
    // Search through all unmarked nodes accessible from process
    public static void visit(int process,
                             int[][] processes, 
                             Set<Integer> temporaryMarks, 
                             Set<Integer> permanentMarks, 
                             List<Integer> result) {
        // Throw an error if we find a cycle
        if (temporaryMarks.contains(process)) 
            throw new RuntimeException("Graph is not acyclic");
        
        // If we haven't visited the node, recursively search from there
        if (!permanentMarks.contains(process)) {
            temporaryMarks.add(process);
            
            // Perform recursive search from children
            for (int i : processes[process]) {
                visit(i, processes, temporaryMarks, permanentMarks, result);
            }
            
            // Add permanent mark, remove temporary mark, and add to results list
            permanentMarks.add(process);
            temporaryMarks.remove(process);
            result.add(process);
        }
    }
    
    // Sample test cases
    public static void main(String[] args) {
        assert compareResults(buildOrder(new int[][]{{}, {0}, {1}, {2}, {3}}), 
                              new int[]{0, 1, 2, 3, 4}):
            "Simple sorted order";
        assert compareResults(buildOrder(new int[][]{{}, {0}, {0}, {1, 2}, {1, 2, 3}}),
                              new int[]{0, 1, 2, 3, 4}):
            "Complex sorted order";
        assert compareResults(buildOrder(new int[][]{{3}, {0}, {4}, {}, {1}}),
                              new int[]{3, 0, 1, 4, 2}):
            "Simple unsorted order";
        assert compareResults(buildOrder(new int[][]{{3}, {0, 3}, {0, 1, 3}, {}, {1, 2, 3}}),
                              new int[]{3, 0, 1, 2, 4}):
            "Complex unsorted order";
        try {
            buildOrder(new int[][]{{1}, {0}});
            assert false:
                "Throw error on cycle";
        } catch (Exception e) {
        }
        System.out.println("Passed all test cases");
    }
    
    // Helper method for tests. Checks if lists have equal values
    private static boolean compareResults(List<Integer> a, int[] b) {
        if (a.size() != b.length) return false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b[i]) return false;
        }
        
        return true;
    }
}