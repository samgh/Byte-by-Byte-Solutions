"""
Title: Nth-to-last Linked List Element

Given a linked list, find the nth-to-last value in the list.

Execution: python NthToLast.py
 
For more details, check out http://www.byte-by-byte.com/nthtolastelement/
"""
import unittest


class Node:
    """
    Node class for Linked List.
    """
    def __init__(self, value=None):
        self.value = value
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)

        if self.head is None:
            self.head = new_node
            return

        last_node = self.head
        while last_node.next:
            last_node = last_node.next
        last_node.next = new_node

    def nth_to_last(self, n):
        curr = self.head
        follower = self.head

        # Iterate curr forward by n. If you reach the end of the list then it is
        # shorter than n, so you can't possibly have an nth-to-last node.
        for i in range(n):
            if curr is None:
                return None
            curr = curr.next

        # If length is exactly n, the n-th-to-last node would be null.
        if curr is None:
            return None

        # Move both nodes forward in unison until curr is at the end of the list.
        while curr.next:
            curr = curr.next
            follower = follower.next

        return follower


class TestNthToLast(unittest.TestCase):

    def test_0th_to_last(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        self.assertEqual(ll.nth_to_last(0).value, 5)
        print("0th to last for 1->2->3->4->5")

    def test_1st_to_last(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        self.assertEqual(ll.nth_to_last(1).value, 4)
        print("1st to last for 1->2->3->4->5")

    def test_2nd_to_last(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        self.assertEqual(ll.nth_to_last(2).value, 3)
        print("2nd to last for 1->2->3->4->5")

    def test_3rd_to_last(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        self.assertEqual(ll.nth_to_last(3).value, 2)
        print("2nd to last for 1->2->3->4->5")

    def test_4th_to_last(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        self.assertEqual(ll.nth_to_last(4).value, 1)
        print("4th to last for 1->2->3->4->5")

    def test_5th_to_last(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        self.assertEqual(ll.nth_to_last(5), None)
        print("5th to last for 1->2->3->4->5")


if __name__ == '__main__':
    unittest.main()

