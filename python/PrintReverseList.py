"""
Title: Remove duplicates from linked list.

Given a linked list, write a function that prints the nodes of 
the list in reverse order.

Execution: python DedupLinkedList.py
 
For more details, check out http://www.byte-by-byte.com/printreverselist/
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

    def print_reversed_list(self, node):
        if node is None:
            return
        self.print_reversed_list(node.next)
        print(node.value)


class TestNthToLast(unittest.TestCase):

    def test_1(self):
        print("Before list: 1->2->3->4")
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)

        ll.print_reversed_list(ll.head)

    def test_2(self):
        print("Before list: 4->3->2->1")
        ll = LinkedList()
        ll.append(4)
        ll.append(3)
        ll.append(2)
        ll.append(1)

        ll.print_reversed_list(ll.head)

    def test_3(self):
        print("Before list: 10->9->8")
        ll = LinkedList()
        ll.append(10)
        ll.append(9)
        ll.append(8)

        ll.print_reversed_list(ll.head)

if __name__ == '__main__':
    unittest.main()

