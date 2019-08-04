"""
Title: Line intersection

Given two lines on a Cartesian plane, write a function to determine 
whether or not the lines intersect.

Execution: python LineIntersection.py

For more details, check out http://www.byte-by-byte.com/lineintersection/

"""
import unittest

class Line:
    def __init__(self, slope, y_intercept):
        self.epsilon = 0.00001
        self.slope = slope
        self.y_intercept = y_intercept

        self.line = (self.slope, self.y_intercept)

    def intersect(self, line):
        if self.is_equal(line):
            return True
        if abs(self.slope - line.slope) > self.epsilon:
            return True
        return False

    def is_equal(self, line):
        return abs(self.slope - line.slope) < self.epsilon and \
                abs(self.y_intercept - line.y_intercept) < self.epsilon


class TestFibonacci(unittest.TestCase):
    def test_1(self):
        line_1 = Line(2, 5)
        line_2 = Line(3, 10)
        self.assertEqual(line_1.intersect(line_2), True)
        print("Test 1 succeeded.")


if __name__ == '__main__':
    unittest.main()
