"""
Title: Fibonacci number.

Given an integer n, write a function to compute the nth Fibonacci number.

Execution: python Fibonacci.py

For more details, check out http://www.byte-by-byte.com/fibonacci

"""
import unittest


def fibonacci(x: int):
    if x < 0:
        return -1
    if x == 0:
        return 0
    cache = [0] * (x + 1)
    for i in range(1, len(cache)):
        cache[i] = -1
    cache[1] = 1
    return fibonacci_recur(x, cache)


def fibonacci_recur(x: int, cache: list):
    if cache[x] > -1:
        return cache[x]
    cache[x] = fibonacci_recur(x-1, cache) + fibonacci_recur(x-2, cache)
    return cache[x]


class TestFibonacci(unittest.TestCase):
    def test_1(self):
        self.assertEqual(fibonacci(1), 1)
        print("fib(1) = 1")

    def test_5(self):
        self.assertEqual(fibonacci(5), 5)
        print("fib(5) = 5")

    def test_10(self):
        self.assertEqual(fibonacci(10), 55)
        print("fib(10) = 55")


if __name__ == '__main__':
    unittest.main()
