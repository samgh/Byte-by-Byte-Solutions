# /usr/bin/python2.7

# Converting Sam's Java code to Python

import unittest


class Node (object):
    def __init__(self, value=0):
        self.value = value
        self.next = None


# Algorithm using extra space. Mark visited nodes and check that you
# only visit each node once.
def hasCycle(node):
    visited = set()
    current = node

    while current is not None:
        if current in visited:
            return True
        else:
            visited.add(current)
        current = current.next

    return False


# Floyd's algorithm. Increment one pointer by one and the other by two.
# If they are ever pointing to the same node, there is a cycle.
# Explanation is at:
# https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
def hasCycleFloyd(node):

    if node is None:
        return False
    slow = node
    fast = node.next

    while fast is not None and fast.next is not None:
        if (fast == slow):
            return True

        fast = fast.next.next
        slow = slow.next

    return False


class TestCycle(unittest.TestCase):

    def test_hasCycle(self):
        self.assertEqual(hasCycle(None), False)
        print "Marking visited: Null input"
        n = Node()
        self.assertEqual(hasCycle(n), False)
        print "Marking visited: Single node"
        n.next = n
        self.assertEqual(hasCycle(n), True)
        print "Marking visited: Single node cycle"
        n.next = Node()
        self.assertEqual(hasCycle(n), False)
        print "Marking visited: Multinode list"
        n.next.next = n
        self.assertEqual(hasCycle(n), True)
        print "Marking visited: Even length cycle"
        n.next.next = Node()
        n.next.next.next = Node()
        n.next.next.next.next = n.next
        self.assertEqual(hasCycle(n), True)
        print "Marking visited: Odd length cycle"

    def test_hasCycleFlyod(self):
        self.assertEqual(hasCycleFloyd(None), False)
        print "\nMarking visited: Null input"
        n = Node()
        self.assertEqual(hasCycleFloyd(n), False)
        print "Marking visited: Single node"
        n.next = n
        self.assertEqual(hasCycleFloyd(n), True)
        print "Marking visited: Single node cycle"
        n.next = Node()
        self.assertEqual(hasCycleFloyd(n), False)
        print "Marking visited: Multinode list"
        n.next.next = n
        self.assertEqual(hasCycleFloyd(n), True)
        print "Marking visited: Even length cycle"
        n.next.next = Node()
        n.next.next.next = Node()
        n.next.next.next.next = n.next
        self.assertEqual(hasCycleFloyd(n), True)
        print "Marking visited: Odd length cycle"

        print "Passed all test cases"


if __name__ == '__main__':
    unittest.main()
