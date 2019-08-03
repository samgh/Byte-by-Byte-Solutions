"""
Title: String compression

Given a string, write a function to compress it by shortening every 
sequence of the same character to that character followed by the number 
of repetitions. If the compressed string is longer than the original, 
you should return the original string.

Execution: python StringCompression.py

For more details, check out http://www.byte-by-byte.com/stringcompression/

"""
import unittest


def string_compress(input_str):
    cstring = []

    curr = input_str[0]
    count = 0

    for char in input_str:
        if char == curr:
            count += 1
        else:
            cstring.append(curr + str(count))
            curr = char
            count = 1

    cstring.append(curr + str(count))
    cstring = ''.join(cstring)

    if len(cstring) < len(input_str):
        return cstring
    else:
        return input_str 

class TestStringCompress(unittest.TestCase):
    def test_1(self):
        self.assertEqual(string_compress("a"), "a")

    def test_2(self):
        self.assertEqual(string_compress("aaa"), "a3")

    def test_3(self):
        self.assertEqual(string_compress("aaabbb"), "a3b3")

    def test_4(self):
        self.assertEqual(string_compress("aaabccc"), "a3b1c3")

if __name__ == '__main__':
    unittest.main()
