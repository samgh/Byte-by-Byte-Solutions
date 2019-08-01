/*
* Title: Gray Code
*
* Execution: g++ GrayCode.cpp -o GrayCode
*
* For more details, check out http://www.byte-by-byte.com/graycode/
*/

#include <iostream>

using namespace std;

bool gray_1(int a, int b) {
    int x = a ^ b;
    while (x > 0) {
        if (x % 2 == 1 && x >> 1 > 0) {
            return false;
        }
        x = x >> 1;
    }
    return true;
}

bool gray_2(int a, int b) {
    int x = a ^ b;
    return (x & (x-1)) == 0;
}

int main() {
    assert(gray_1(0, 1) == true);
    cout << "Passed: gray_1(0, 1) == true" << endl;

    assert(gray_1(1, 2) == false);
    cout << "Passed: gray_1(1, 2) == false" << endl;

    assert(gray_2(0, 1) == true);
    cout << "Passed: gray_2(0, 1) == true" << endl;

    assert(gray_2(1, 2) == false);
    cout << "Passed: gray_2(1, 2) == false" << endl;

    return 0;
}
