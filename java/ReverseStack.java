/*
 *   Title: Reverse stack
 *
 *   Given a stack, reverse the items without creating any additional data structures.
 * 
 *   Execution: javac ReverseStack.java && java ReverseStack
 * 
 *   For more details, check out http://www.byte-by-byte.com/reversestack/
 */

import java.util.Stack;

public class ReverseStack {
    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;
        int temp = stack.pop();
        reverse(stack);
        insertAtBottom(stack, temp);
        return stack;
    }

    private static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }

    public static void test_1() {
        Stack<Integer> s = new Stack<Integer>();
        s.push(3);
        s.push(2);
        s.push(1);
        assert reverse(s) == s;
        System.out.println("reverse(1->2->3) = 3->2->1");
    }

    public static void test_2() {
        Stack<Integer> s = new Stack<Integer>();
        s.push(5);
        s.push(6);
        s.push(10);
        s.push(11);
        s.push(60);
        s.push(50);
        assert reverse(s) == s;
        System.out.println("reverse(5->6->10->11->60->50) = 50->60->11->10->6->5");
    }
    
    public static void test_3() {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        assert reverse(s) == s;
        System.out.println("reverse(3->2->1) = 1->2->3");
    }
    // Sample test cases
    public static void main(String[] args) {
        test_1();
        test_2();
        test_3();

        System.out.println("Passed all test cases");
    }
}
