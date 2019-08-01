/*
* Title: Print reverse list
*
* Execution: g++ PrintReverseList.cpp -o PrintReverseList
*
* For more details, check out http://www.byte-by-byte.com/printreverselist/
*/

#include <iostream>
#include <vector>

using namespace std;

struct Node {
    int value;
    Node *next;
};

void printReverseList(Node *n) {
    if (n == NULL) {
        return;
    }
    printReverseList(n->next);
    cout << n->value << endl;
}

void test_1() {
    
    cout << "Original list: 1->2->3" << endl;
    Node *n1 = new Node();
    Node *n2 = new Node();
    Node *n3 = new Node();

    n1->value = 1;
    n1->next = n2;

    n2->value = 2;
    n2->next = n3;

    n3->value = 3;
    n3->next = NULL;

    printReverseList(n1);
}

void test_2() {

    cout << "Original list: 3->2->1" << endl;
    Node *n1 = new Node();
    Node *n2 = new Node();
    Node *n3 = new Node();

    n1->value = 3;
    n1->next = n2;

    n2->value = 2;
    n2->next = n3;

    n3->value = 1;
    n3->next = NULL;

    printReverseList(n1);
}

void test_3() {

    cout << "Original list: 10->9" << endl;
    Node *n1 = new Node();
    Node *n2 = new Node();

    n1->value = 10;
    n1->next = n2;

    n2->value = 9;
    n2->next = NULL;

    printReverseList(n1);
}

int main() {

    test_1();
    test_2();
    test_3();

    return 0;
}
