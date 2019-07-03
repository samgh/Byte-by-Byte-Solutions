"""
Title: Square submatrix

Given a 2D boolean array, find the largest square subarray of true values.
The return value should be the side length of the largest square subarray
subarray.

Execution: python SquareSubmatrix.py

For more details, check out http://www.byte-by-byte.com/squaresubmatrix/
"""

import unittest


def naive_square_matrix(mat: list):
    """
    Brute force solution. From each cell see what is the biggest square
    submatrix for which it is the upper left-hand corner.
    """
    max_val = 0
    # Compute recursively for each cell what it is the upper left corner of.
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if mat[i][j]:
                max_val = max(max_val, naive_square_matrix_recur(mat, i, j))
    return max_val


def naive_square_matrix_recur(mat: list, i: int, j: int):
    """
    Recursive helper function.
    """
    # If we get to the bottom or right of the matrix, we can't go any
    # further.
    if i == len(mat) or j == len(mat[0]):
        return 0

    # If the cell is False then it is not part of a valid submatrix.
    if not(mat[i][j]):
        return 0

    # Find the size of the right, bottom, and bottom right submatrices and
    # add 1 to the minimum of those 3 to get the result.
    return 1 + min(min(naive_square_matrix_recur(mat, i+1, j),
                       naive_square_matrix_recur(mat, i, j+1)),
                   naive_square_matrix_recur(mat, i+1, j+1))


def top_down_square_matrix(mat: list):
    """
    Top down dynamic programming solution. Cache the values as we compute
    them to avoid repeating computations.
    """
    cache = [[False] * len(mat[0])] * len(mat)
    max_val = 0
    for i in range(len(mat)):
        for j in range(len(mat[0])):
            if mat[i][j]:
                max_val = max(max_val, top_down_square_matrix_recur(mat, i, j, cache))
    return max_val


def top_down_square_matrix_recur(mat: list, i: int, j: int, cache: list):
    if i == len(mat) or j == len(mat[0]):
        return 0
    if not mat[i][j]:
        return 0

    # If the value is set in the cache, return it. Otherwise, compute and
    # save to cache.
    if cache[i][j] > 0:
        return cache[i][j]
    cache[i][j] = 1 + min(min(top_down_square_matrix_recur(mat, i+1, j, cache),
                              top_down_square_matrix_recur(mat, i, j+1, cache)),
                          top_down_square_matrix_recur(mat, i+1, j+1, cache))
    return cache[i][j]


def bottom_up_square_submatrix(mat):
    """
    Bottom up solution. Start from the upper left-hand corner and compute
    progressively larger submatrices.
    """
    max_val = 0
    # Initialize cache
    cache = [[False] * len(mat[0])] * len(mat)
    # Iterate over the matrix to compute all values
    for i in range(len(cache)):
        for j in range(len(cache[0])):
            # If we are in the first row or column then the value is just
            # 1 if that cell is true and 0 otherwise. In other rows and
            # columns, need to look up and to the left.
            if i == 0 or j == 0:
                cache[i][j] = 1 if mat[i][j] else 0
            elif mat[i][j]:
                cache[i][j] = 1 + min(min(cache[i][j-1], cache[i-1][j]), cache[i-1][j-1])
            if cache[i][j] > max_val:
                max_val = cache[i][j]
    return max_val


class TestSquareSubmatrix(unittest.TestCase):

    def test_naive_square_matrix(self):
        mat = [[True]]
        self.assertEqual(naive_square_matrix(mat), 1)

        mat = [[False]]
        self.assertEqual(naive_square_matrix(mat), 0)

        mat = [[True, True, True, False], [False, True, True, True], [True, True, True, True, True]]
        self.assertEqual(naive_square_matrix(mat), 2)

        mat = [[True, True, True, True], [False, True, True, True], [True, True, True, True]]
        self.assertEqual(naive_square_matrix(mat), 3)

    def test_bottom_up_square_matrix(self):
        mat = [[True]]
        self.assertEqual(bottom_up_square_submatrix(mat), 1)

        mat = [[False]]
        self.assertEqual(bottom_up_square_submatrix(mat), 0)

        mat = [[True, True, True, False], [False, True, True, True], [True, True, True, True, True]]
        self.assertEqual(bottom_up_square_submatrix(mat), 2)

        mat = [[True, True, True, True], [False, True, True, True], [True, True, True, True]]
        self.assertEqual(bottom_up_square_submatrix(mat), 3)


if __name__ == '__main__':
    unittest.main()

