"""
Title: Reverse Stack

Given a stack, reverse the items without creating any additional data structures.

Execution: python ReverseStack.py

For more details, check out http://www.byte-by-byte.com/reversestack/
"""
import unittest


def reverse(stack):
    if stack == []:
        return stack
    tmp = stack.pop()
    reverse(stack)
    insert_at_bottom(stack, tmp)
    return stack


def insert_at_bottom(stack, x):
    if stack == []:
        stack.append(x)
        return
    tmp = stack.pop()
    insert_at_bottom(stack, x)
    stack.append(tmp)


class TestReverseStack(unittest.TestCase):
    def test_1(self):
        stack = [1, 2, 3]
        self.assertEqual(reverse(stack), [3, 2, 1])
        print("reverse(1->2->3) = 3->2->1")

    def test_2(self):
        stack = [5, 6, 10, 11, 60, 50]
        self.assertEqual(reverse(stack), [50, 60, 11, 10, 6, 5])
        print("reverse(5->6->10->11->60->50) = 50->60->11->10->6->5")

    def test_3(self):
        stack = [3, 2, 1]
        self.assertEqual(reverse(stack), [1, 2, 3])
        print("reverse(3->2->1) = 1->2->3")


if __name__ == '__main__':
    unittest.main()
