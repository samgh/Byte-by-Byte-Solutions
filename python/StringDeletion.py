"""
  Title: String deletion

  Given a string and a dictionary HashSet, write a function to determine the 
  minimum number of characters to delete to make a word.

  Execution: python StringDeletion.py

  For more details, check out http://www.byte-by-byte.com/stringdeletion
"""
from collections import deque
import unittest


def delete(query: str, dictionary: list):
    queue = deque()
    queue_elements = set()

    queue.append(query)
    queue_elements.add(query)

    while queue:
        s = queue.popleft()
        queue_elements.remove(s)
        if s in dictionary:
            return len(query) - len(s)
        for i in range(len(s)):
            sub = s[0:i] + s[i+1:len(s)]
            if len(sub) > 0 and sub not in queue_elements:
                queue.append(sub)
                queue_elements.add(sub)
    return -1


class TestStringDeletion(unittest.TestCase):
    def test_I(self):
        self.assertEqual(delete("abc", ["a", "aa", "aaa"]), 2)
        print("Successfully determines 2 strings.")


if __name__ == '__main__':
    unittest.main()



