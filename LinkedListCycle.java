/*
 * Title: Linked List Cycle
 * Author: Sam Gavis-Hughson
 * Date: 10/16/2016
 * 
 * Given a list of packages and their dependencies, determine a valid build
 * order.
 * 
 * Execution: javac LinkedListCycle.java && java LinkedListCycle
 * 
 * For more details, check out http://www.byte-by-byte.com/listcycles/
 */

import java.util.HashSet;

public class LinkedListCycle {
    private static class Node{
        int val;
        Node next;
    }
    
    // Algorithm using extra space. Mark visited nodes and check that you
    // only visit each node once.
    public static boolean hasCycle(Node n) {
        HashSet<Node> visited = new HashSet<Node>();
        for (Node curr = n; curr != null; curr = curr.next) {
            if (visited.contains(curr)) return true;
            visited.add(curr);
        }
        
        return false;
    }
    
    // Floyd's algorithm. Increment one pointer by one and the other by two.
    // If they are ever pointing to the same node, there is a cycle.
    // Explanation: https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
    public static boolean hasCycleFloyd(Node n) {
        if (n == null) return false;
        Node slow = n;
        Node fast = n.next;
        
        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return false;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        // Test marking visited implementation
        assert hasCycle(null) == false:
            "Marking visited: Null input";
        Node n = new Node();
        assert hasCycle(n) == false:
            "Marking visited: Single node";
        n.next = n;
        assert hasCycle(n) == true:
            "Marking visited: Single node cycle";
        n.next = new Node();
        assert hasCycle(n) == false:
            "Marking visited: Multinode list";
        n.next.next = n;
        assert hasCycle(n) == true:
            "Marking visited: Even length cycle";
        n.next.next = new Node();
        n.next.next.next = new Node();
        n.next.next.next.next = n.next;
        assert hasCycle(n) == true:
            "Marking visited: Odd length cycle";
            
        // Test marking visited implementation
        assert hasCycleFloyd(null) == false:
            "Floyd: Null input";
        n = new Node();
        assert hasCycleFloyd(n) == false:
            "Floyd: Single node";
        n.next = n;
        assert hasCycleFloyd(n) == true:
            "Floyd: Single node cycle";
        n.next = new Node();
        assert hasCycleFloyd(n) == false:
            "Floyd: Multinode list";
        n.next.next = n;
        assert hasCycleFloyd(n) == true:
            "Floyd: Even length cycle";
        n.next.next = new Node();
        n.next.next.next = new Node();
        n.next.next.next.next = n.next;
        assert hasCycleFloyd(n) == true:
            "Floyd: Odd length cycle";
            
        System.out.println("Passed all test cases");
    }
}