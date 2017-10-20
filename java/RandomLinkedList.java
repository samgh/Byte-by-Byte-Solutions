/*
 * Title: Random Linked List
 * Author: Sam Gavis-Hughson
 * Date: 10/20/2017
 * 
 * Given a linked list where each node contains a pointer to the next node and
 * a pointer to a random node in the list, write a function to create a copy of
 * the linked list.
 * 
 * Execution: javac RandomLinkedList.java && java RandomLinkedList
 * 
 * For more details, check out http://www.byte-by-byte.com/randomlinkedlist/
 */

import java.util.HashMap;
import java.util.Random;

public class RandomLinkedList {
    
    // Private node class
    private static class Node {
        int value;
        Node next;
        Node random;
    }
    
    // Copy list using extra space. Store mapping of old nodes to new nodes
    public static Node cloneExtraSpace(Node n) {
        if (n == null) return n;
        
        // Map nodes in old list to equivalent nodes in new list
        HashMap<Node, Node> mapping = new HashMap<Node, Node>();
        
        // Create new linked list, minus the random node pointers. Save mapping
        // of equivalent old node to new node
        Node copy = new Node();
        Node nCurr = n, copyCurr = copy;
        mapping.put(nCurr, copyCurr);
        
        while (nCurr.next != null) {
            copyCurr.next = new Node();
            nCurr = nCurr.next;
            copyCurr = copyCurr.next;
            mapping.put(nCurr, copyCurr);
        }
        
        // Copy the random pointers. Find the random pointer in the original 
        // list and look up the equivalent using the map
        nCurr = n;
        copyCurr = copy;
        while (nCurr != null) {
            copyCurr.random = mapping.get(nCurr.random);
            nCurr = nCurr.next;
            copyCurr = copyCurr.next;
        }
        
        return copy;
    }
    
    // Copy list without using extra space. Interleave the nodes from the new 
    // with the nodes from the original list. Then separate the new list from 
    // the old
    public static Node cloneNoExtraSpace(Node n) {
        if (n == null) return n;
        
        // Create new nodes in between the original nodes
        Node nCurr = n;
        while (nCurr != null) {
            Node temp = new Node();
            temp.value = nCurr.value;
            temp.next = nCurr.next;
            nCurr.next = temp;
            nCurr = nCurr.next.next;
        }
        
        // Copy random pointers
        nCurr = n;
        while (nCurr != null) {
            nCurr.next.random = nCurr.random.next;
            nCurr = nCurr.next.next;
        }
        
        // Separate new nodes from old nodes
        Node copy = n.next; 
        nCurr = n;
        while (nCurr.next != null) {
            Node tmp = nCurr.next;
            nCurr.next = nCurr.next.next;
            nCurr = tmp;
        }
        
        return copy;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        assert cloneExtraSpace(null) == null:
            "Empty list - extra space";
        assert cloneNoExtraSpace(null) == null:
            "Empty list - no extra space";
            
        Node n = new Node();
        n.random = n;
        assert compareLinkedList(cloneExtraSpace(n), n):
            "Length one linked list, none-null random - extra space";
            
        assert compareLinkedList(cloneNoExtraSpace(n), n):
            "Length one linked list, none-null random - no extra space";
        
        // Randomly generate random linked lists
        Random rand = new Random(0);
        for (int i = 0; i < 10; i++) {
            // Create the nodes
            Node[] nodes = new Node[rand.nextInt(100)];
            for (int j = 0; j < nodes.length; j++) {
                nodes[j] = new Node();
            }
            
            // Create the links between the nodes
            for (int j = 0; j < nodes.length; j++) {
                if (j < nodes.length - 1) nodes[j].next = nodes[j+1];
                // Some null and some pointers to other nodes
                if (rand.nextInt(100) > 10) {
                    nodes[j].random = nodes[rand.nextInt(nodes.length)];
                }
            }
            
            assert compareLinkedList(cloneExtraSpace(n), n):
                "Length " + nodes.length + " linked list, randomly generated - extra space";
            assert compareLinkedList(cloneNoExtraSpace(n), n):
                "Length " + nodes.length + " linked list, randomly generated - no extra space";
        }
        
        System.out.println("Passed all test cases");
    }
    
    private static boolean compareLinkedList(Node a, Node b) {
        Node currA = a, currB = b;
        while (currA != null && currB != null) {
            if (currA.value != currB.value) return false;
            if (currA.random != null && currB.random != null) {
                if (currA.random.value != currB.random.value) return false;
            } else if (currA.random != null || currB.random != null) {
                return false;
            }
            currA = currA.next;
            currB = currB.next;
        }
        
        return currA == null && currB == null;
    }
}