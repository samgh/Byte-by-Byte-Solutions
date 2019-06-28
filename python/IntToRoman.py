
"""
Title: Integer to Roman Numerals

Write a function to convert an integer into its roman numeral representation

Execution: python IntToRoman.py

For more details, check out http://www.byte-by-byte.com/inttoroman/

"""
import unittest


numerals = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
values = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]

def int_to_roman(value):
    if value > 3999 or value < 1:
        raise ValueError(f"Value {value} is above 3999 or below 1.")
    i = 0
    numeral = []
    while value > 0:
        if value - values[i] >= 0:
            numeral.append(numerals[i])
            value -= values[i]
        else:
            i += 1
    return ''.join(numeral)


class TestBigIntMod(unittest.TestCase):
    def test_I(self):
        self.assertEqual(int_to_roman(1), "I")
        print("1 converts to I")

    def test_IV(self):
        self.assertEqual(int_to_roman(4), "IV")
        print("4 converts to IV")

    def test_VI(self):
        self.assertEqual(int_to_roman(6), "VI")
        print("6 converts to VI")

    def test_XI(self):
        self.assertEqual(int_to_roman(11), "XI")
        print("11 converts to XI")

    def test_XLIX(self):
        self.assertEqual(int_to_roman(49), "XLIX")
        print("49 convers to XLIX")

    def test_MMXX(self):
        self.assertEqual(int_to_roman(2020), "MMXX")
        print("2020 converts to MMXX")


if __name__ == '__main__':
    unittest.main()

