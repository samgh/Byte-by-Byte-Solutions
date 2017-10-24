/*
 * Title: Linked List Cycle
 * Author: Arko Gupta
 * Date: 25/10/17
 * 
 * Given a linked list, determine whether it contains any cycles.
 * 
 * Execution: g++ LinkedListCycle.cpp && ./a.out 
 * 
 * For more details, check out http://www.byte-by-byte.com/listcycles/
 */


#include <bits/stdc++.h>
using namespace std;

struct node
{
    int val;
    node *next;

    node()
    {
        val = 0;
        next = NULL;
    }

};

class LinkedListCycle
{

public:

    // Algorithm using extra space. Mark visited nodes and check that you
    // only visit each node once.
    bool hasCycle(node* head)
    {
        set<node*>visited;
        node* curr = head;
        while(curr != NULL)
        {   
            if(visited.find(curr) != visited.end())
                return true;
            visited.insert(curr);
            curr = curr -> next;
        }
        return false;
    }

    // Floyd's algorithm. Increment one pointer by one and the other by two.
    // If they are ever pointing to the same node, there is a cycle.
    // Explanation: https://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
    bool hasCycleFloyd(node *head)
    {
        if(head == NULL) return false;

        node* slow = head;
        node* fast = head -> next;

        while(fast != NULL && fast -> next !=NULL)
        {   
            if( slow == fast) return true;                
            slow = slow -> next;
            fast = fast -> next -> next;
        }

        return false;
    }

};


// Sample test cases
int main()
{   
    LinkedListCycle checker;


    // Test marking visited implementation
    assert(checker.hasCycle(NULL) == false);
    cout << "Marking visited: Null input " << endl ;

    node* n = new node();
    assert(checker.hasCycle(n) == false);
    cout << "Marking visited: Single node" << endl ;


    n -> next = n;
    assert(checker.hasCycle(n) == true);
    cout << "Marking visited: Single node cycle" << endl ;

    n -> next = new node();
    assert(checker.hasCycle(n) == false);
    cout << "Marking visited: Multinode list" << endl ;

    n -> next -> next = n;
    assert(checker.hasCycle(n) == true);
    cout << "Marking visited: Even node cycle" << endl ;

    n -> next -> next = new node();
    n -> next -> next -> next = new node();
    n -> next -> next -> next -> next = n -> next;
    assert(checker.hasCycle(n) == true);
    cout << "Marking visited: Odd length cylce" << endl ;


    // Test Floyd's algorithm implementation
    assert(checker.hasCycleFloyd(NULL) == false);
    cout << "Floyd: Null input " << endl ;

    n = new node();
    assert(checker.hasCycleFloyd(n) == false);
    cout << "Floyd: Single node" << endl ;


    n -> next = n;
    assert(checker.hasCycleFloyd(n) == true);
    cout << "Floyd: Single node cycle" << endl ;

    n -> next = new node();
    assert(checker.hasCycleFloyd(n) == false);
    cout << "Floyd: Multinode list" << endl ;

    n -> next -> next = n;
    assert(checker.hasCycleFloyd(n) == true);
    cout << "Floyd: Even node cycle" << endl ;

    n -> next -> next = new node();
    n -> next -> next -> next = new node();
    n -> next -> next -> next -> next = n -> next;
    assert(checker.hasCycleFloyd(n) == true);
    cout << "Floyd: Odd length cylce" << endl ;

    cout << "All test cases passed !" ;

    return 0;
}
