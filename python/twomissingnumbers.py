# /usr/bin/python2.7

import unittest


def oneMissing(arr):
    totalXor = 0
    arrXor = 0

    # XOR the numbers from 1 to N, ie. the input if no numbers were missing
    for i in range(1, len(arr)+2):
        totalXor = totalXor ^ i

    # XOR the array
    for i in range(len(arr)):
        arrXor = arrXor ^ arr[i]

    return totalXor ^ arrXor


def twoMissing(arr):
    size = len(arr) + 2
    totalSum = size * (size + 1)//2  # we want only the integer portion
    arrSum = 0

    for i in range(len(arr)):
        arrSum += arr[i]

    pivot = (totalSum - arrSum) // 2  # we want only the integer portion

    totalLeftXor = 0
    arrLeftXor = 0
    totalRightXor = 0
    arrRightXor = 0

    for i in range(1, pivot+1):
        totalLeftXor ^= i

    for i in range(pivot+1, size+1):
        totalRightXor ^= i

    for i in range(len(arr)):
        if (arr[i] <= pivot):
            arrLeftXor ^= arr[i]
        else:
            arrRightXor ^= arr[i]

    return (totalLeftXor ^ arrLeftXor, totalRightXor ^ arrRightXor)


class TestMissingNumbers(unittest.TestCase):

    def test_oneMissing(self):
        # oneMissing tests
        self.assertEqual(oneMissing([1, 2, 4, 5]), 3)
        print "oneMissing: Normal case"
        self.assertEqual(oneMissing([3, 2, 5, 4]), 1)
        print "oneMissing: Missing first element"
        self.assertEqual(oneMissing([4, 3, 2, 1]), 5)
        print "oneMissing: Missing last element"
        print "Passed all oneMissing test cases"

    def test_twoMissing(self):
        # twomissing tests
        self.assertEqual(twoMissing([1, 3, 5]), (2, 4))
        print "\ntwoMissing: Normal case"
        self.assertEqual(twoMissing([2, 4, 5]), (1, 3))
        print "twoMissing: Missing first element"
        self.assertEqual(twoMissing([3, 1, 2]), (4, 5))
        print "twoMissing: Missing last two elements"
        print "Passed all twoMissing test cases"


if __name__ == '__main__':
    unittest.main()
