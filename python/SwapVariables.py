"""
Title: Swap Variables

Given two integers, write a function that swaps them without using any 
temporary variables.

Execution: python SwapVariables.py

For more details, check out http://www.byte-by-byte.com/swapvariables

"""
import unittest


def swap_1(x: int, y: int):
    x = x + y
    y = x - y
    x = x - y
    return x, y


def swap_2(x: int, y: int):
    x = x ^ y
    y = x ^ y
    x = x ^ y
    return x, y


class TestSwap(unittest.TestCase):
    def test_swap_1_1_2(self):
        self.assertEqual(swap_1(1, 2), (2, 1))
        print("Swapped (1, 2) with (2, 1)")

    def test_swap_1_5_5(self):
        self.assertEqual(swap_1(5, 5), (5, 5))
        print("Swapped (5, 5) with (5, 5)")

    def test_swap_1_neg1_40(self):
        self.assertEqual(swap_1(-1, 40), (40, -1))
        print("Swapped (-1, 40) with (40, -1)")

    def test_swap_2_1_2(self):
        self.assertEqual(swap_2(1, 2), (2, 1))
        print("Swapped (1, 2) with (2, 1)")

    def test_swap_2_5_5(self):
        self.assertEqual(swap_2(5, 5), (5, 5))
        print("Swapped (5, 5) with (5, 5)")

    def test_swap_2_neg1_40(self):
        self.assertEqual(swap_2(-1, 40), (40, -1))
        print("Swapped (-1, 40) with (40, -1)")


if __name__ == '__main__':
    unittest.main()
