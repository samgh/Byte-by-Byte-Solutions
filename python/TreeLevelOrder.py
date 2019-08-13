"""
Title: Tree Level Order.

Given a tree, write a function that prints out the nodes of the tree in level
order.

Execution: python TreeLevelOrder.py

For more details, check out http://www.byte-by-byte.com/treelevelorder

"""
import unittest


class Queue:
    def __init__(self):
        self.items = []

    def enqueue(self, item):
        self.items.insert(0, item)

    def dequeue(self):
        if not self.is_empty():
            return self.items.pop()

    def is_empty(self):
        return len(self.items) == 0

    def peek(self):
        if not self.is_empty():
            return self.items[-1].value

    def __len__(self):
        return self.size()

    def size(self):
        return len(self.items)


class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def traverse(start):
    if start is None:
        return

    queue = Queue()
    queue.enqueue(start)

    traversal = []
    while len(queue) > 0:
        traversal.append(queue.peek())
        node = queue.dequeue()

        if node.left:
            queue.enqueue(node.left)
        if node.right:
            queue.enqueue(node.right)

    return traversal


class TestTreeLevelOrder(unittest.TestCase):
    def test_1(self):
        n = Node(1)
        n.left = Node(2)
        n.right = Node(3)
        n.left.left = Node(4)
        n.left.right = Node(5)
        n.right.left = Node(6)
        n.right.right = Node(7)
        self.assertEqual(traverse(n), [1, 2, 3, 4, 5, 6, 7])


if __name__ == '__main__':
    unittest.main()
