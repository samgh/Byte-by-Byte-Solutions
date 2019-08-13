"""
Title: Consecutive Array

Given an unsorted array of numbers, find the length of the longest sequence
of consecutive numbers in the array

Execution: python ConsecutiveArray.py

For more details, check out http://www.byte-by-byte.com/consecutivearray/
"""
import unittest


def consecutive_array(arr: list):
    s = set()
    result = 0

    for element in arr:
        s.add(element)

    for i in range(len(arr)):
        if arr[i] - 1 not in s:
            j = arr[i]
            while j in s:
                j += 1
            result = max(result, j - arr[i])
    return result


class TestConsecutiveArray(unittest.TestCase):

    def test_single_sequence_sorted(self):
        self.assertEqual(consecutive_array([1, 2, 3, 4, 5]), 5)
        print("Single sequence, sorted order.")

    def test_single_sequence_unsorted(self):
        self.assertEqual(consecutive_array([5, 4, 3, 2, 1]), 5)
        print("Single sequence, unsorted order.")

    def test_multiple_sequences_sorted(self):
        self.assertEqual(consecutive_array([1, 2, 4, 5, 6]), 3)
        print("Multiple sequences, sorted order.")

    def test_multiple_sequences_unsorted(self):
        self.assertEqual(consecutive_array([2, 4, 1, 6, 5]), 3)
        print("Multiple sequences, unsorted order.")


if __name__ == '__main__':
    unittest.main()


