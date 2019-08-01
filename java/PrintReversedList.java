/*
 *   Title: Print reversed list
 *
 *   Given a linked list, write a function that prints the nodes of the 
 *   list in reverse order.
 * 
 *   Execution: javac PrintReversedList.java && java PrintReversedList
 * 
 *   For more details, check out http://www.byte-by-byte.com/printreversedlist/
 */

public class PrintReversedList {

    private static class Node {
        private int value;
        private Node next;
        
        private Node(int value) {
            this.value = value;
        }
    }

    public static void printReversedList(Node n) {
        if (n == null) {
            return;
        }
        printReversedList(n.next);
        System.out.println(n.value);
    }

    public static void test_1() {
        System.out.println("Original: 1->2->3->4");
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);

        printReversedList(n);
    }

    public static void test_2() {
        System.out.println("Original: 4->3->2->1");
        Node n = new Node(4);
        n.next = new Node(3);
        n.next.next = new Node(2);
        n.next.next.next = new Node(1);

        printReversedList(n);
    }
    
    public static void test_3() {
        System.out.println("Original: 10->9->8");
        Node n = new Node(10);
        n.next = new Node(9);
        n.next.next = new Node(8);

        printReversedList(n);
    }
    // Sample test cases
    public static void main(String[] args) {

        System.out.println("Test 1:");
        test_1();
        System.out.println("\n");

        System.out.println("Test 2:");
        test_2();
        System.out.println("\n");

        System.out.println("Test 3:");
        test_3();
        System.out.println("\n");

        System.out.println("Passed all test cases");
    }
}
