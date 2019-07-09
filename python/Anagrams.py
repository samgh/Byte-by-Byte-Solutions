"""
Title: Is anagram

Given two strings, write a function to determine whether they are anagrams.

Execution: python Anagrams.py

For more details, check out http://www.byte-by-byte.com/anagrams/
"""
from collections import defaultdict
import unittest


def is_anagram(s1: str, s2: str):
    if len(s1) != len(s2):
        return False

    s1 = s1.lower()
    s2 = s2.lower()

    letters = defaultdict(int)

    for c in s1:
        letters[c] += 1

    for c in s2:
        letters[c] -= 1

    for i in letters.values():
        if i != 0:
            return False
    return True


class TestAnagram(unittest.TestCase):
    def test_1(self):
        self.assertEqual(is_anagram("", ""), True)
        print("Empty string s1='' and string s2='' are anagrams")

    def test_2(self):
        self.assertEqual(is_anagram("A", "B"), False)
        print("Empty string s1='A' and string s2='B' are not anagrams")

    def test_3(self):
        self.assertEqual(is_anagram("ab", "ba"), True)
        print("Empty string s1='ab' and string s2='ba' are anagrams")

    def test_4(self):
        self.assertEqual(is_anagram("AB", "ab"), True)
        print("Empty string s1='AB' and string s2='ab' are anagrams")


if __name__ == '__main__':
    unittest.main()

