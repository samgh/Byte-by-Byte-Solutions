/*
*   Title: Two missing
*
    Given an array containing all the numbers from 1 to n except two, 
    find the two missing numbers.
*
*   Execution: g++ TwoMissing.cpp -o TwoMissing
* 
*   For more details, check out http://www.byte-by-byte.com/twomissing
* 
*/
#include <cstdlib>
#include <iostream>
#include <vector>

using namespace std;

int oneMissing(vector<int> v) {
    int total_xor = 0;
    int arr_xor = 0;

    for (int i = 1; i < v.size()+2; i++) {
       total_xor = total_xor ^ i; 
    }

    for (int i = 0; i < v.size(); i++) {
        arr_xor = arr_xor ^ v[i];
    }
    
    return total_xor ^ arr_xor;
}

// def twoMissing(arr):
//     size = len(arr) + 2
//     totalSum = size * (size + 1)//2  # we want only the integer portion
//     arrSum = 0
// 
//     for i in range(len(arr)):
//         arrSum += arr[i]
// 
//     pivot = (totalSum - arrSum) // 2  # we want only the integer portion
// 
//     totalLeftXor = 0
//     arrLeftXor = 0
//     totalRightXor = 0
//     arrRightXor = 0
// 
//     for i in range(1, pivot+1):
//         totalLeftXor ^= i
// 
//     for i in range(pivot+1, size+1):
//         totalRightXor ^= i
// 
//     for i in range(len(arr)):
//         if (arr[i] <= pivot):
//             arrLeftXor ^= arr[i]
//         else:
//             arrRightXor ^= arr[i]
// 
//     return (totalLeftXor ^ arrLeftXor, totalRightXor ^ arrRightXor)

vector<int> twoMissing(vector<int> v) {
    int size = v.size() + 2;
    int total_sum = int(size * (size + 1) / 2);
    int arr_sum = 0;

    for(int i = 0; i < v.size(); i++) {
        arr_sum += v[i];
    }
    int pivot = int((total_sum - arr_sum) / 2);

    int total_left_xor = 0;
    int arr_left_xor = 0;
    int total_right_xor = 0;
    int arr_right_xor = 0;

    for (int i = 1; i < pivot+1; i++) {
        total_left_xor ^= i;
    }
    for (int i = pivot+1; i < size+1; i++) {
        total_right_xor ^= i;
    }
    for (int i = 0; i < v.size(); i++) {
        if (v[i] <= pivot) {
            arr_left_xor ^= v[i];
        } else {
            arr_right_xor ^= v[i];
        }
    }

    vector<int> return_vec;
    return_vec.push_back(total_left_xor ^ arr_left_xor);
    return_vec.push_back(total_right_xor ^ arr_right_xor);
    return return_vec;
}

void testOneMissing_1() {
    vector<int> v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(4);
    v.push_back(5);

    if (oneMissing(v) == 3) {
        cout << "Test One Missing 1 passed" << endl;
    } else {
        cout << "Test One Missing 1 failed" << endl;
    }
}

void testOneMissing_2() {
    vector<int> v;
    v.push_back(3);
    v.push_back(2);
    v.push_back(5);
    v.push_back(4);

    if (oneMissing(v) == 1) {
        cout << "Test One Missing 2 passed" << endl;
    } else {
        cout << "Test One Missing 2 failed" << endl;
    }
}

void testOneMissing_3() {
    vector<int> v;
    v.push_back(4);
    v.push_back(3);
    v.push_back(2);
    v.push_back(1);

    if (oneMissing(v) == 5) {
        cout << "Test One Missing 3 passed" << endl;
    } else {
        cout << "Test One Missing 3 failed" << endl;
    }
}

void testTwoMissing_1() {
    vector<int> v;
    v.push_back(1);
    v.push_back(3);
    v.push_back(5);

    vector<int> result = twoMissing(v);

    if (result[0] == 2 && result[1] == 4)  {
        cout << "Test Two Missing 1 passed" << endl;
    } else {
        cout << "Test Two Missing 1 failed" << endl;
    }
}

void testTwoMissing_2() {
    vector<int> v;
    v.push_back(2);
    v.push_back(4);
    v.push_back(5);

    vector<int> result = twoMissing(v);

    if (result[0] == 1 && result[1] == 3)  {
        cout << "Test Two Missing 2 passed" << endl;
    } else {
        cout << "Test Two Missing 2 failed" << endl;
    }
}

void testTwoMissing_3() {
    vector<int> v;
    v.push_back(3);
    v.push_back(1);
    v.push_back(2);

    vector<int> result = twoMissing(v);

    if (result[0] == 4 && result[1] == 5)  {
        cout << "Test Two Missing 3 passed" << endl;
    } else {
        cout << "Test Two Missing 3 failed" << endl;
    }
}

void testOneMissing() {
    testOneMissing_1();
    testOneMissing_2();
    testOneMissing_3();
}

void testTwoMissing() {
    testTwoMissing_1();
    testTwoMissing_2();
    testTwoMissing_3();
}

int main() {

    testOneMissing();
    testTwoMissing();

    return 0;
}

