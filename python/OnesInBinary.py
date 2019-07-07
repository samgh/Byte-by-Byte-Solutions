"""
Title: Number of ones in binary representation.

Given an integer, write a function to compute the number of ones in 
the binary representation of the number.

Execution: python OnesInBinary.py

For more details, check out http://www.byte-by-byte.com/onesinbinary

"""
import unittest


def ones_binary(x: int):
    sum = 0
    while x > 0:
        sum += x & 1
        x >>= 1
    return sum


class TestOnesBinary(unittest.TestCase):
    def test_5(self):
        self.assertEqual(ones_binary(5), 2)
        print("Binary representation of 5 has 2 ones.")

    def test_12(self):
        self.assertEqual(ones_binary(12), 2)
        print("Binary representation of 12has 2 ones.")

    def test_255(self):
        self.assertEqual(ones_binary(255), 8)
        print("Binary representation of 255 has 8 ones.")

    def test_256(self):
        self.assertEqual(ones_binary(256), 1)
        print("Binary representation of 256 has 1 ones.")


if __name__ == '__main__':
    unittest.main()

