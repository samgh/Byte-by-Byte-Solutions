/*
 *   Title: Max Stack
 *
 *   Implement a LIFO stack that has a push(), pop(), and max() function, where
 *   max() returns the maximum value in the stack. All of these functions should
 *   run in O(1) time.
 * 
 *   Execution: javac MaxStack.java && java MaxStack
 * 
 *   For more details, check out http://www.byte-by-byte.com/maxstack/
 */

public class MaxStack {

    private class Node {
        private int value;
        private Node next;
        private Node oldMax;
    }

    private Node stack;
    private Node max;

    public MaxStack() {}

    public void push(int x) {
        Node n = new Node();
        n.value = x;

        if (stack == null) {
            stack = n;
        } else {
            n.next = stack;
            stack = n;
        }

        if (max == null || n.value > max.value) {
            n.oldMax = max;
            max = n;
        }
    }

    public int pop() {
        if (stack == null) {
            throw new NullPointerException("Stack is Null");
        }
        Node n = stack;
        stack = n.next;
        max = n.oldMax;
        return n.value;
    }

    public int max() {
        if (max == null) {
            throw new NullPointerException("Max is Null");
        }
        return max.value;
    }

    public static void test_1() {
        MaxStack s = new MaxStack();
        s.push(1);
        s.push(100);
        s.push(5);
        assert s.max() == 100;
    }

    public static void test_2() {
        MaxStack s = new MaxStack();
        s.push(1);
        s.push(2);
        s.push(3);
        assert s.max() == 3;
    }

    public static void test_3() {
        MaxStack s = new MaxStack();
        s.push(-1);
        s.push(2);
        s.push(-3);
        assert s.max() == 2;
    }
    
    // Sample test cases
    public static void main(String[] args) {

        test_1();
        test_2();
        test_3();
        System.out.println("Passed all test cases");
    }
}
