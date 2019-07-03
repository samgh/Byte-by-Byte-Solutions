"""
 Title: Matrix Product
 
Given a matrix, find the path from top left to bottom right with the greatest
product by moving only down and right.
 
Execution: python MatrixProduct.py

For more details, check out http://www.byte-by-byte.com/matrixproduct/

"""
import unittest

def matrix_product(mat):
    """
    Bottom-up dynamic programming solution.
    """
    if len(mat) == 0 or len(mat[0]) == 0:
        return 0

    # Create cache of min and max product to a given cell.
    max_cache = [[1] * len(mat[0])] * len(mat)
    min_cache = [[1] * len(mat[0])] * len(mat)

    # Fill caches. We start at the top left and iteratively find the greatest
    # at smallest path to each subsequent cell by considering the greatest and
    # smallest path to the cells above and to the left of the current cell.
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            max_val = float("inf")
            min_val = float("-inf")

            # If you're in the top left corner, just copy to cache
            if i == 0 and j == 0:
                max_val = mat[i][j]
                min_val = mat[i][j]

            # If we're not at the top, consider the value above.
            if i > 0:
                temp_max = max(mat[i][j] * max_cache[i-1][j], mat[i][j] * min_cache[i-1][j])
                max_val = max(temp_max, max_val)
                temp_min = min(mat[i][j] * max_cache[i-1][j], mat[i][j] * min_cache[i-1][j])
                min_val = min(temp_min, min_val)

            # If we're not on the left, consider the value to the left
            if j > 0:
                temp_max = max(mat[i][j] * max_cache[i][j-1], mat[i][j] * min_cache[i][j-1])
                max_val = max(temp_max, max_val)
                temp_min = min(mat[i][j] * max_cache[i][j-1], mat[i][j] * min_cache[i][j-1])
                min_val = min(temp_min, min_val)

            max_cache[i][j] = max_val
            min_cache[i][j] = min_val
    return max_cache[len(max_cache) - 1][len(max_cache[0]) - 1]
        

mat = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
x = matrix_product(mat)
print(x)
