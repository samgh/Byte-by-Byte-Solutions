"""
Title: Gray code

Given two integers, write a function to determine whether or not their 
binary representations differ by a single bit. 

Execution: python GrayCode.py

For more details, check out http://www.byte-by-byte.com/graycode/

"""
import unittest


def gray_1(a: int, b: int):
    x = a ^ b
    while x > 0:
        if x % 2 == 1 and x >> 1 > 0:
            return False
        x = x >> 1
    return True


def gray_2(a: int, b: int):
    x = a ^ b
    return (x & (x-1)) == 0


class TestGrayCode(unittest.TestCase):
    def test_gray_1_1(self):
        self.assertEqual(gray_1(0, 1), True)
        print("gray_1(0, 1) == True")

    def test_gray_1_2(self):
        self.assertEqual(gray_1(1, 2), False)
        print("gray_1(1, 2) == False")

    def test_gray_2_1(self):
        self.assertEqual(gray_2(0, 1), True)
        print("gray_2(0, 1) == True")

    def test_gray_2_2(self):
        self.assertEqual(gray_2(1, 2), False)
        print("gray_2(1, 2) == False")

if __name__ == '__main__':
    unittest.main()
