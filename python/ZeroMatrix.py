"""
Title: Zero Matrix

Given a boolean matrix, update it so that if any cell is true, all the rows 
in that cell are true.

eg. 
[true,  false, false]      [true,  true,  true ]
[false, false, false]  ->  [true,  false, false]
[false, false, false]      [true,  false, false]
 
Execution: python ZeroMatrix.py
 
For more details, check out http://www.byte-by-byte.com/zeromatrix/
"""
import unittest


def zero_matrix(mat):
    row_flag = False
    col_flag = False

    for i in range(len(mat)):
        for j in range(len(mat)):
            if i == 0 and mat[i][j]:
                row_flag = True
            if j == 0 and mat[i][j]:
                col_flag = True
            if mat[i][j]:
                mat[0][j] = True
                mat[i][0] = True
    for i in range(1, len(mat)):
        for j in range(1, len(mat)):
            if mat[0][j] or mat[i][0]:
                mat[i][j] = True
    if row_flag:
        for i in range(len(mat)):
            mat[0][i] = True
    if col_flag:
        for i in range(len(mat)):
            mat[i][0] = True
    return mat


class TestBigIntMod(unittest.TestCase):
    def test_first_row_first_col(self):
        A = [[True, False, False],
             [False, False, False], 
             [False, False, False]]

        B = [[True, True, True],
             [True, False, False],
             [True, False, False]]

        self.assertEqual(zero_matrix(A), B)
        print("First row and first column")

    def test_all_false(self):
        A = [[False, False, False],
             [False, False, False], 
             [False, False, False]]

        B = [[False, False, False],
             [False, False, False],
             [False, False, False]]

        self.assertEqual(zero_matrix(A), B)
        print("All false.")

    def test_all_true(self):
        A = [[True, True, True],
             [True, True, True],
             [True, True, True]]

        B = [[True, True, True],
             [True, True, True],
             [True, True, True]]

        self.assertEqual(zero_matrix(A), B)
        print("All true.")

    def test_multiple_true(self):
        A = [[True, False, False],
             [False, False, False],
             [False, False, True]]

        B = [[True, True, True],
             [True, False, True],
             [True, True, True]]

        self.assertEqual(zero_matrix(A), B)
        print("Multiple true.")


if __name__ == '__main__':
    unittest.main()

