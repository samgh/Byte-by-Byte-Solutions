class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


class BinaryTree(object):
    def __init__(self, root):
        self.root = Node(root)
        self.stack = []

    def traverse(self, node):
        curr = node

        while True:

            if curr:
                self.stack.append(curr)
                curr = curr.left
            elif self.stack:
                curr = self.stack.pop()
                print(curr.value)
                
                curr = curr.right
            else:
                break


"""
Sample test case

       8
    /     \
   4       12
  / \     /  \
 1   6   9   15
    /     \
   5      10

Should print:
1
4
5
6
8
9
10
12
15
"""

# Set up tree:
tree = BinaryTree(8)
tree.left = Node(4)
tree.left.left = Node(1)
tree.left.right = Node(6)
tree.left.right.left = Node(5)
tree.right = Node(12)
tree.right.left = Node(9)
tree.right.left.right = Node(10)
tree.right.right = Node(15)
tree.traverse(tree)

#print(tree.print_tree("preorder"))
#print(tree.print_tree("inorder"))
#print(tree.print_tree("postorder"))

    
