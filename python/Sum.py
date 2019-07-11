"""
Title: Sum problem

Given two integers, write a function to sum the numbers without using any arithmetic operators.

Execution: python Sum.py

For more details, check out http://www.byte-by-byte.com/sum/

"""
import unittest


def sum_func(a: int, b: int):
    if b == 0:
        return a
    partial_sum = a ^ b
    carry = (a & b) << 1
    return sum_func(partial_sum, carry)


class TestSum(unittest.TestCase):
    def test_1_1_2(self):
        self.assertEqual(sum_func(1, 1), 2)
        print("1 + 1 = 2")
    
    def test_10_5_15(self):
        self.assertEqual(sum_func(10, 5), 15)
        print("10 + 5 = 15")

    def test_100_200_300(self):
        self.assertEqual(sum_func(100, 200), 300)
        print("100 + 200 = 300")

    def test_3_2_5(self):
        self.assertEqual(sum_func(3, 2), 5)
        print("3 + 2 = 5")


if __name__ == '__main__':
    unittest.main()
