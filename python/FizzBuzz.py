"""
Title: FizzBuzz

Output numbers from 1 to x. If the number is divisible by 3, replace it with 
“Fizz”. If it is divisible by 5, replace it with “Buzz”. If it is divisible 
by 3 and 5 replace it with “FizzBuzz”.

Execution: python FizzBuzz.py

For more details, check out http://www.byte-by-byte.com/fizzbuzz
"""
import unittest


def fizz_buzz(i: int):
    if i % 3 == 0 and i % 5 == 0:
        return "FizzBuzz"
    elif i % 3 == 0:
        return "Fizz"
    elif i % 5 == 0:
        return "Buzz"
    else:
        return i


class TestFizzBuzz(unittest.TestCase):
    def test_1(self):
        self.assertEqual(fizz_buzz(1), 1)
        print("1 produces 1")

    def test_2(self):
        self.assertEqual(fizz_buzz(2), 2)
        print("2 produces 2")

    def test_fizz_3(self):
        self.assertEqual(fizz_buzz(3), "Fizz")
        print("3 produces Fizz")

    def test_buzz_5(self):
        self.assertEqual(fizz_buzz(5), "Buzz")
        print("5 produces Buzz")

    def test_fizz_9(self):
        self.assertEqual(fizz_buzz(9), "Fizz")
        print("9 produces Fizz")

    def test_fizzbuzz_15(self):
        self.assertEqual(fizz_buzz(15), "FizzBuzz")
        print("15 produces FizzBuzz")


if __name__ == '__main__':
    unittest.main()

