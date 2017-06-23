/*
 * Title: Matrix Product
 * Author: Sam Gavis-Hughson
 * Date: 8/28/2016
 * 
 * Given a matrix, find the path from top left to bottom right with the greatest
 * product by moving only down and right.
 * 
 * Execution: javac MatrixProduct.java && java MatrixProduct
 * 
 * For more details, check out http://www.byte-by-byte.com/matrixproduct/
 */

public class MatrixProduct {
    // Bottom up dynamic programming solution
    public static int matrixProduct(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        // Create cache of min and max product to a given cell
        int[][] maxCache = new int[matrix.length][matrix[0].length];
        int[][] minCache = new int[matrix.length][matrix[0].length];
        
        // Fill caches. We start at the top  left and iteratively find the greatest
        // at smallest path to each subsequent cell by considering the greatest and
        // smallest path to the cells above and to the left of the current cell
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int maxVal = Integer.MIN_VALUE;
                int minVal = Integer.MAX_VALUE;
                
                // If you're in the top left corner, just copy to cache
                if (i == 0 && j == 0) {
                    maxVal = matrix[i][j];
                    minVal = matrix[i][j];
                }
                
                // If we're not at the top, consider the value above
                if (i > 0) {
                    int tempMax = Math.max(matrix[i][j] * maxCache[i-1][j], matrix[i][j] * minCache[i-1][j]);
                    maxVal = Math.max(tempMax, maxVal);
                    int tempMin = Math.min(matrix[i][j] * maxCache[i-1][j], matrix[i][j] * minCache[i-1][j]);
                    minVal = Math.min(tempMin, minVal);
                }
                
                // If we're not on the left, consider the value to the left
                if (j > 0) {
                    int tempMax = Math.max(matrix[i][j] * maxCache[i][j-1], matrix[i][j] * minCache[i][j-1]);
                    maxVal = Math.max(tempMax, maxVal);
                    int tempMin = Math.min(matrix[i][j] * maxCache[i][j-1], matrix[i][j] * minCache[i][j-1]);
                    minVal = Math.min(tempMin, minVal);
                }
                maxCache[i][j] = maxVal;
                minCache[i][j] = minVal;
            }
        }
        
        // Return the max value at the bottom right
        return maxCache[maxCache.length - 1][maxCache[0].length - 1];
    }
    
    // Sample test cases
    public static void main(String[] args) {
        assert matrixProduct(new int[][]{{1,2,3}, {4, 5, 6}, {7, 8, 9}}) == 2016;
        assert matrixProduct(new int[][]{{-1,2,3}, {4, 5, 6}, {7, 8, 9}}) == -324;
        assert matrixProduct(new int[][]{{-1,2,3}, {4, 5, -6}, {7, 8, 9}}) == 1080;
        
        System.out.println("Passed all tests");
    }
}