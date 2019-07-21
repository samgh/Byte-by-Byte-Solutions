/*
 * Title: Remove duplicates of linked list
 * 
 * Given an unsorted linked list, write a function to remove all the duplicates.
 * 
 * Execution: javac DedupLinkedList.java && java DedupLinkedList
 * 
 * For more details, check out http://www.byte-by-byte.com/deduplinkedlist
 */
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class DedupLinkedList {
    // Private node class
    private static class Node {
        private int value;
        private Node next;
        
        private Node(int value) {
            this.value = value;
        }
    }

    public static List<Integer> printList(Node n) {
        List<Integer> list = new ArrayList<>();
        while (n != null) {
            list.add(n.value);
            n = n.next;
        }
        return list;
    }

    public static void removeDups(Node n) {
        HashSet<Integer> nodes = new HashSet<Integer>();
        Node prev = null;

        while (n != null) {
            if (nodes.contains(n.value)) {
                prev.next = n.next;
            } else {
                nodes.add(n.value);
                prev = n;
            }
            n = n.next;
        }
        prev.next = null;
    }
    
    // Sample test cases
    public static void main(String[] args) {

        // Test 1 duplicate:
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(4);

        removeDups(n);
        List<Integer> l1 = printList(n);
        int[] ints = {1,2,3,4};
        List<Integer> l2 = Arrays.stream(ints).boxed().collect(Collectors.toList());

        if (l1.equals(l2)) 
            System.out.println("Test with 1 duplicate passed."); 
        else
            System.out.println("Test with 1 duplicate failed"); 

        // Test 2 duplicates
        Node n2 = new Node(1);
        n2.next = new Node(1);
        n2.next.next = new Node(2);
        n2.next.next.next = new Node(2);
        n2.next.next.next.next = new Node(3);

        removeDups(n2);
        List<Integer> l1_2 = printList(n2);
        int[] ints2 = {1,2,3};
        List<Integer> l2_2 = Arrays.stream(ints2).boxed().collect(Collectors.toList());

        if (l1_2.equals(l2_2)) 
            System.out.println("Test with 2 duplicates passed."); 
        else
            System.out.println("Test with 2 duplicates failed."); 

        // Test no duplicates
        Node n3 = new Node(1);
        n3.next = new Node(2);
        n3.next.next = new Node(3);
        n3.next.next.next = new Node(4);
        n3.next.next.next.next = new Node(5);

        removeDups(n3);
        List<Integer> l1_3 = printList(n3);
        int[] ints3 = {1,2,3,4,5};
        List<Integer> l2_3 = Arrays.stream(ints3).boxed().collect(Collectors.toList());

        if (l1_3.equals(l2_3)) 
            System.out.println("Test with no duplicates passed."); 
        else
            System.out.println("Test with no duplicates failed."); 


    }
}
