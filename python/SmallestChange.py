"""
Title: Smallest change

Given an input amount of change x, write a function to determine the 
minimum number of coins required to make that amount of change.

Execution: python SmallestChange.py

For more details, check out http://www.byte-by-byte.com/smallestchange/
"""
import unittest


def change(x: int, coins: list):
    if x == 0:
        return 0
    min_val = x
    for coin in coins:
        if x - coin >= 0:
            c = change(x-coin, coins)
            if min_val > c + 1:
                min_val = c + 1
    return min_val


def change_dynamic(x: int, coins: list):
    cache = [0] * x
    for i in range(1, x):
        cache[i] = -1
    return change_dynamic_recur(x, coins, cache)


def change_dynamic_recur(x: int, coins: list, cache: list):
    if x == 0:
        return 0
    min_val = x
    for coin in coins:
        if x - coin >= 0:
            if cache[x - coin] >= 0:
                c = cache[x - coin]
            else:
                c = change_dynamic_recur(x - coin, coins, cache)
                cache[x-coin] = c
            if min_val > c + 1:
                min_val = c + 1
    return min_val
 

class TestChange(unittest.TestCase):

    # Tests for change function (no dynamic programming):
    def test_change_1(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change(1, coins), 1)
        print("Smallest from 1 is 1")

    def test_change_3(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change(3, coins), 3)
        print("Smallest from 3 is 3")

    def test_change_7(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change(7, coins), 3)
        print("Smallest from 7 is 3")

    def test_change_32(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change(32, coins), 4)
        print("Smallest from 32 is 4")

    # Tests for change_dynamic (dynamic programming):
    def test_change_dynamic_1(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change_dynamic(1, coins), 1)
        print("Smallest from 1 is 1")

    def test_change_dynamic_3(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change_dynamic(3, coins), 3)
        print("Smallest from 3 is 3")

    def test_change_dynamic_7(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change_dynamic(7, coins), 3)
        print("Smallest from 7 is 3")

    def test_change_dynamic_32(self):
        coins = [1, 5, 10, 25]
        self.assertEqual(change_dynamic(32, coins), 4)
        print("Smallest from 32 is 4")

if __name__ == '__main__':
    unittest.main()
