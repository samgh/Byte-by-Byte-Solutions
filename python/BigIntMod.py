"""
Title: Big Int Mod

Given a list of bytes a, each representing one byte of a larger integer 
(ie. {0x12, 0x34, 0x56, 0x78} represents the integer 0x12345678), and an 
integer b, find a % b.
 
Execution: python BigIntMod.py
 
For more details, check out http://www.byte-by-byte.com/bigintmod/
"""
import unittest


def big_int_mod(a: list, b: int):
    if a is None:
        return 0
    m = 0
    for i in range(len(a)):
        m <<= 8
        m += (a[i] & 0xFF)
        m %= b
    return m


class TestBigIntMod(unittest.TestCase):
    def test_null_value(self):
        self.assertEqual(big_int_mod(None, 1), 0)
        print("Null value.")

    def test_empty_array(self):
        self.assertEqual(big_int_mod([], 1), 0)
        print("Empty array.")

    def test_single_element_array(self):
        self.assertEqual(big_int_mod([15], 10), 5)
        print("Single element array.")

    def test_multi_element_array(self):
        self.assertEqual(big_int_mod([0x03, 0xED], 10), 5)
        print("Multi-element array")


if __name__ == '__main__':
    unittest.main()


