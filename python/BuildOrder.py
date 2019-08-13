"""
Title: Build Order

Given a list of packages and their dependencies, determine a valid build
order.

Execution: python BuildOrder.py

For more details, check out http://www.byte-by-byte.com/buildorder/
"""
import unittest


def build_order(processes: list):
    """
    Perform topological sort. Input is a list of dependencies where the index is the process number
    and the value is the numbers the processes it depends on.
    """
    temporary_marks  = set()
    permanent_marks = set()
    result = []

    # Recursively search from any unmarked node.
    for i in range(len(processes)):
        if i not in permanent_marks:
            visit(i, processes, temporary_marks, permanent_marks, result)
    return result


def visit(process, processes, temporary_marks, permanent_marks, result):
    """
    Search through all unmarked nodes accessible from process.
    """

    # If we haven't visited the node, recursively search from there.
    if process not in permanent_marks:
        temporary_marks.add(process)

        # Perform recursive search from children.
        for i in processes[process]:
            visit(i, processes, temporary_marks, permanent_marks, result)

        # Add permanent mark, remove temporary mark, and add to results list.
        permanent_marks.add(process)
        temporary_marks.add(process)

        result.append(process)


class TestBuildOrder(unittest.TestCase):
    def test_simple_sorted_order(self):
        self.assertEqual(build_order([[], [0], [1], [2], [3]]), [0, 1, 2, 3, 4])
        print("Simple sorted order.")

    def test_complex_sorted_order(self):
        self.assertEqual(build_order([[], [0], [0], [1, 2], [1, 2, 3]]), [0, 1, 2, 3, 4])
        print("Complex sorted order.")

    def test_simple_unsorted_order(self):
        self.assertEqual(build_order([[3], [0], [4], [], [1]]), [3, 0, 1, 4, 2])
        print("Simple unsorted order.")

    def test_complex_unsorted_order(self):
        self.assertEqual(build_order([[3], [0, 3], [0, 1, 3], [], [1, 2, 3]]), [3, 0, 1, 2, 4])
        print("Complex unsorted order.")


if __name__ == '__main__':
    unittest.main()


