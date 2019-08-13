/*
*   Title: Swap Variables
*
*   Given two integers, write a function that swaps them without using any 
*   temporary variables.
*
*   Execution: g++ SwapVariables.cpp -o SwapVariables
*
*   For more details, check out http://www.byte-by-byte.com/swapvariables
*/

#include <iostream>
#include <vector>

using namespace std;

vector<int> swap_1(int x, int y) {
    vector<int> vars;
    
    x = x + y;
    y = x - y;
    x = x - y;

    vars.push_back(x);
    vars.push_back(y);

    return vars;
}

vector<int> swap_2(int x, int y) {
    vector<int> vars;

    x = x ^ y;
    y = x ^ y;
    x = x ^ y;

    vars.push_back(x);
    vars.push_back(y);
    return vars;
}

int main() {
    vector<int> test_1 = swap_1(1, 2);
    assert(test_1[0] == 2);
    assert(test_1[1] == 1);
    cout << "Swapped (1,2) with (2,1)" << endl;

    vector<int> test_2 = swap_1(5, 5);
    assert(test_2[0] == 5);
    assert(test_2[1] == 5);
    cout << "Swapped (5,5) with (5,5)" << endl;

    vector<int> test_3 = swap_1(-1, 40);
    assert(test_3[0] == 40);
    assert(test_3[1] == -1);
    cout << "Swapped (40,-1) with (-1,40)" << endl;

    vector<int> test_4 = swap_2(1, 2);
    assert(test_4[0] == 2);
    assert(test_4[1] == 1);
    cout << "Swapped (1,2) with (2,1)" << endl;

    vector<int> test_5 = swap_2(5, 5);
    assert(test_5[0] == 5);
    assert(test_5[1] == 5);
    cout << "Swapped (5,5) with (5,5)" << endl;

    vector<int> test_6 = swap_2(-1, 40);
    assert(test_6[0] == 40);
    assert(test_6[1] == -1);
    cout << "Swapped (40,-1) with (-1,40)" << endl;

    return 0;
}
