/*
* Title: Reverse Stack
*
* Execution: g++ ReverseStack.cpp -o ReverseStack
*
* For more details, check out http://www.byte-by-byte.com/reversestack
*/

#include <iostream>
#include <stack>

using namespace std;

void insertAtBottom(stack<int> s, int x) {
    if (s.empty()) {
        s.push(x);
        return;
    }
    int temp = s.top();
    s.pop();
    insertAtBottom(s, x);
    s.push(temp);
}

stack<int> reverse(stack<int> s) {
    if (s.empty()) {
        return s;
    }
    int temp = s.top();
    s.pop();
    reverse(s);
    insertAtBottom(s, temp);
    return s;
}

bool check_stack_equal(stack<int> s1, stack<int> s2) {
    if (s1.size() != s2.size()) {
        return false;
    }
    int len = s1.size();
    while(!s1.empty()) {
        if (s1.top() != s2.top()) {
            return false;
        }
        s1.pop();
        s2.pop();
    }
    return true;
}

void test_1() {
    stack<int> s;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(0);

    stack<int> s1 = reverse(s);

    stack<int> s2;
    s2.push(1);
    s2.push(2);
    s2.push(3);

    if (check_stack_equal(s1, s2)) {
        cout << "Test 1 passed" << endl;
        cout << "reverse(1->2->3) = 3->2->1" << endl;
    } else {
        cout << "Test 1 failed" << endl;
    }
}
void test_2() {
    stack<int> s;
    s.push(5);
    s.push(6);
    s.push(10);
    s.push(11);
    s.push(60);
    s.push(50);
    s.push(0);

    stack<int> s1 = reverse(s);

    stack<int> s2;
    s2.push(5);
    s2.push(6);
    s2.push(10);
    s2.push(11);
    s2.push(60);
    s2.push(50);
    
    if (check_stack_equal(s1, s2)) {
        cout << "Test 2 passed" << endl;
        cout << "reverse(5->6->10->11->60->50) = 50->60->11->10->6->5" << endl;
    } else {
        cout << "Test 2 failed" << endl;
    }
}

void test_3() {
    stack<int> s;
    s.push(3);
    s.push(2);
    s.push(1);
    s.push(0);

    stack<int> s1 = reverse(s);

    stack<int> s2;
    s2.push(3);
    s2.push(2);
    s2.push(1);

    if (check_stack_equal(s1, s2)) {
        cout << "Test 3 passed" << endl;
        cout << "reverse(3->2->1) = 1->2->3" << endl;
    } else {
        cout << "Test 3 failed" << endl;
    }

}

int main() {
    test_1();
    test_2();
    test_3();

    return 0;
}
