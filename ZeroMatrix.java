/*
 * Title: Zero Matrix
 * Author: Sam Gavis-Hughson
 * Date: 9/5/2016
 * 
 * Given a boolean matrix, update it so that if any cell is true, all the rows 
 * in that cell are true.
 * 
 * eg. 
 * [true,  false, false]      [true,  true,  true ]
 * [false, false, false]  ->  [true,  false, false]
 * [false, false, false]      [true,  false, false]
 * 
 * Execution: javac ZeroMatrix.java && java ZeroMatrix
 * 
 * For more details, check out http://www.byte-by-byte.com/zeromatrix/
 */
import java.util.Arrays;

public class ZeroMatrix {
    public static void zeroMatrix(boolean[][] matrix) {
        
        // Verify the input array is nonzero
        if (matrix.length == 0 || matrix[0].length == 0) return;
        
        // Determine whether the first row or first column is true
        boolean rowZero = false, colZero = false;
        for (boolean i : matrix[0]) {
            rowZero |= i;
        }
        for (boolean[] i : matrix) {
            colZero |= i[0];
        }
            
        // For each cell not in the first row/column, if it is true, set the 
        // cell in the first row/same column and first column/same row to be 
        // true
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    matrix[i][0] = true;
                    matrix[0][j] = true;
                }
            }
        }
        
        // Go through the first column and set each row to true where cell in
        // the first column is true
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0]) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = true;
                }
            }
        }
        
        // Repeat for the rows
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j]) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = true;
                }
            }
        }
        
        // Set first row/column to true if necessary
        if (rowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = true;
            }
        }
        
        if (colZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = true;
            }
        }
    }
    
    // Sample test cases
    public static void main(String[] args) {
        boolean[][] a = new boolean[][]{
            {true, false, false}, 
            {false, false, false}, 
            {false, false, false}
        };
        zeroMatrix(a);
        assert compare2dArrays(a, new boolean[][]{
            {true, true, true},
            {true, false, false},
            {true, false, false}
        }) : "First row and first column";
        
        a = new boolean[][]{
            {false, false, false}, 
            {false, false, false}, 
            {false, false, false}
        };
        zeroMatrix(a);
        assert compare2dArrays(a, new boolean[][]{
            {false, false, false}, 
            {false, false, false}, 
            {false, false, false}
        }) : "All false";
        
        a = new boolean[][]{
            {true, true, true}, 
            {true, true, true}, 
            {true, true, true}, 
        };
        zeroMatrix(a);
        assert compare2dArrays(a, new boolean[][]{
            {true, true, true}, 
            {true, true, true}, 
            {true, true, true}, 
        }) : "All true";
        
        a = new boolean[][]{
            {false, true, false}, 
        };
        zeroMatrix(a);
        assert compare2dArrays(a, new boolean[][]{
            {true, true, true}
        }) : "1 x 3 array";
        
        a = new boolean[][]{
            {false}, 
            {true}, 
            {false}
        };
        zeroMatrix(a);
        assert compare2dArrays(a, new boolean[][]{
            {true}, 
            {true}, 
            {true}
        }) : "3 x 1 array";
        
        a = new boolean[][]{
            {true, false, false}, 
            {false, false, false}, 
            {false, false, true}
        };
        zeroMatrix(a);
        assert compare2dArrays(a, new boolean[][]{
            {true, true, true}, 
            {true, false, true}, 
            {true, true, true}
        }) : "Multiple true";
        
        System.out.println("Passed all test cases");
    }
    
    private static boolean compare2dArrays(boolean[][] a, boolean[][] b) {
        if (a.length != b.length) return false;
        if (a[0].length != b[0].length) return false;
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        
        return true;
    }
}