/*
 * Title: Inorder Traversal
 * Author: Sam Gavis-Hughson
 * Date: 6/16/2017
 * 
 * Given a binary tree, print out the nodes in order without using
 * recursion. 
 * 
 * Execution: javac InorderTraversal.java && java InorderTraversal
 * 
 * For more details, check out http://www.byte-by-byte.com/inordertraversal/
 */

import java.util.Stack;

public class InorderTraversal {
    // Tree node class
    public static class Node {
        Node left;
        Node right;
        int value;
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    // Traverse tree iteratively. We do this by replicating the same process
    // done recursively using an explicit stack
    public static void traverse(Node n) {
        Stack<Node> s = new Stack<Node>();
        // Add the leftmost branch to the stack
        addLeftToStack(s, n);
        
        // While there are elements in the stack, pop and move the minimum
        // possible distance to the right
        while (!s.isEmpty()) {
            Node curr = s.pop();
            System.out.println(curr.value);
            
            // Add the right child and any of its left children to the stack
            addLeftToStack(s, curr.right);
        }
    }
    
    // As long as the current node has a left pointer, add it to the stack and 
    // continue
    private static void addLeftToStack(Stack<Node> s, Node n) {
        while (n != null) {
            s.push(n);
            n = n.left;
        }
    }
    
 /*
  * Sample test case
  * 
  *        8
  *     /     \
  *    4       12
  *   / \     /  \
  *  1   6   9   15
  *     /     \
  *    5      10
  * 
  * Should print:
  * 1
  * 4
  * 5
  * 6
  * 8
  * 9
  * 10
  * 12
  * 15
  */
    
    public static void main(String[] args) {
        Node n = new Node(8);
        n.left = new Node(4);
        n.left.left = new Node(1);
        n.left.right = new Node(6);
        n.left.right.left = new Node(5);
        n.right = new Node(12);
        n.right.left = new Node(9);
        n.right.left.right = new Node(10);
        n.right.right = new Node(15);
        traverse(n);
    }
}