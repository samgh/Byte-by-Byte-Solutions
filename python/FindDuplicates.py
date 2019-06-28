import unittest


def find_duplicates(arr):
    """
    Return a list of duplicates in the array. To avoid using extra space,
    we flag which elements we've seen before by negating the value at
    indexed at that value in the array.
    """

    # Use a set for results to avoid duplicates.
    result_set = set()
    for i in range(len(arr)):
        # Translate the value into an index (1 <= x <= len(arr))
        idx = abs(arr[i]) - 1

        # If the value at that index is negative, then we've already seen
        # that value so it's a duplicate. Otherwise, negate the value at
        # that index we know we've seen it.
        if arr[idx] < 0:
            result_set.add(abs(arr[i]))
        else:
            arr[idx] = -arr[idx]

    # Return the list to it's original state.
    for i in range(len(arr)):
        arr[i] = abs(arr[i])

    return list(result_set)


class TestFindDuplicates(unittest.TestCase):

    def test_len_1_no_dups(self):
        self.assertEqual(find_duplicates([1]), [])
        print("Length 1, no duplicates")

    def test_len_2_no_dups(self):
        self.assertEqual(find_duplicates([1, 2]), [])
        print("Length 2, no duplicates")

    def test_len_2_dups(self):
        self.assertEqual(find_duplicates([1, 1]), [1])
        print("Length 2, duplicates")

    def test_len_4_no_dups(self):
        self.assertEqual(find_duplicates([1, 2, 3, 4]), [])
        print("Length 4, no duplicates")

    def test_len_4_one_dup(self):
        self.assertEqual(find_duplicates([1, 1, 2, 3]), [1])
        print("Length 4, one duplicate")

    def test_len_4_two_dups(self):
        self.assertEqual(find_duplicates([1, 1, 2, 2]), [1, 2])
        print("Length 4, two duplicates")
    
    def test_len_4_repeat_dups(self):
        self.assertEqual(find_duplicates([1, 1, 1, 1]), [1])
        print("Length 4, repeated 4 times.")


if __name__ == '__main__':
    unittest.main()
