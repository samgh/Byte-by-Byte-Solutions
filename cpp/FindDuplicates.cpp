/*
*   Title: Find Duplicates
*   Given an array of integers where each value 1 <= x <= len(array), write a
*   function that finds all the duplicates in the array.
*
*   Execution: python FindDuplicates.py
*   Execution: g++ Findduplicates.cpp -o Findduplicates
* 
*   For more details, check out http://www.byte-by-byte.com/findduplicates/
* 
*/
#include <cstdlib>
#include <iostream>
#include <vector>

using namespace std;

vector<int> findDuplicates(vector<int> arr) {
    vector<int> result_set;

    for(int i = 0; i < arr.size(); i++) {
        int idx = abs(arr[i]) - 1;

        if (arr[idx] < 0) {
            result_set.push_back(abs(arr[i]));
        } else {
            arr[idx] = -arr[idx];
        }
    }
    for (int i = 0; i < arr.size(); i++) {
        arr[i] = abs(arr[i]);
    }
    sort( result_set.begin(), result_set.end() );
    result_set.erase( unique( result_set.begin(), result_set.end() ), result_set.end() );
    return result_set;
}

bool areVectorsEqual(vector<int> vec_1, vector<int> vec_2) {
    if (vec_1.size() != vec_2.size()) {
        return false;
    }
    std::sort(vec_1.begin(), vec_1.end());
    std::sort(vec_2.begin(), vec_2.end());

    for (int i = 0; i < vec_1.size(); i++) {
        if (vec_1[i] != vec_2[i]) {
            return false;
        }      
    }
    return true;
}

void test_1() { 
    cout << "Running Test 1 on [1,2,3,1]" << endl;
    vector<int> test_1;
    test_1.push_back(1);
    test_1.push_back(2);
    test_1.push_back(3);
    test_1.push_back(1);

    vector<int> dups_test_1 = findDuplicates(test_1);

    vector<int> expected_test_1;
    expected_test_1.push_back(1);

    if (areVectorsEqual(dups_test_1, expected_test_1)) {
        cout << "Test 1 passed." << endl;
    } else {
        cout << "Test 1 failed." << endl;
    }
 }

void test_2() { 
    cout << "Running Test 2 on [1,1,1,1]" << endl;
    vector<int> test_2;
    test_2.push_back(1);
    test_2.push_back(1);
    test_2.push_back(1);
    test_2.push_back(1);

    vector<int> dups_test_2 = findDuplicates(test_2);

    vector<int> expected_test_2;
    expected_test_2.push_back(1);

    if (areVectorsEqual(dups_test_2, expected_test_2)) {
        cout << "Test 2 passed." << endl;
    } else {
        cout << "Test 2 failed." << endl;
    }
 }

void test_3() { 
    cout << "Running Test 3 on [5,4,3,2]" << endl;
    vector<int> test_3;
    test_3.push_back(5);
    test_3.push_back(4);
    test_3.push_back(3);
    test_3.push_back(2);

    vector<int> dups_test_3 = findDuplicates(test_3);

    vector<int> expected_test_3;

    if (areVectorsEqual(dups_test_3, expected_test_3)) {
        cout << "Test 3 passed." << endl;
    } else {
        cout << "Test 3 failed." << endl;
    }
 }
int main() {

    test_1();
    test_2();
    test_3();

    return 0;
}
