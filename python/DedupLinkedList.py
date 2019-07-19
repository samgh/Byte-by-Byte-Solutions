"""
Title: Remove duplicates from linked list.

Given an unsorted linked list, write a function to remove all the duplicates.

Execution: python DedupLinkedList.py
 
For more details, check out http://www.byte-by-byte.com/deduplinkedlist
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

    def remove_dups(self):
        nodes = set()

        prev = None
        node = self.head

        while node:
            if node.value in nodes:
                prev.next = node.next
            else:
                nodes.add(node.value)
                prev = node
            node = node.next
        prev.next = None


class TestNthToLast(unittest.TestCase):

    def test_no_dups(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        ll.remove_dups()
        after_list = []
        node = ll.head
        while node:
            after_list.append(node.value)
            node = node.next
        
        self.assertEqual(after_list, [1, 2, 3, 4, 5])
        print("1->2->3->4->5 after removal results in 1->2->3->4->5")

    def test_dups(self):
        ll = LinkedList()
        ll.append(1)
        ll.append(2)
        ll.append(2)
        ll.append(3)
        ll.append(4)
        ll.append(5)

        ll.remove_dups()
        after_list = []
        node = ll.head
        while node:
            after_list.append(node.value)
            node = node.next
        
        self.assertEqual(after_list, [1, 2, 3, 4, 5])
        print("1->2->2->3->4->5 after removal results in 1->2->3->4->5")


if __name__ == '__main__':
    unittest.main()

