/*
*   Title: Consecutive Array
*
*
*   Execution: g++ -std=c++11 ConsecutiveArray.cpp -o ConsecutiveArray
*
*   For more details, check out http://www.byte-by-byte.com/consecutivearray
*/

#include <algorithm>
#include <iostream>
#include <set>
#include <vector>

// def consecutive_array(arr: list):
//     s = set()
//     result = 0
// 
//     for element in arr:
//         s.add(element)
// 
//     for i in range(len(arr)):
//         if arr[i] - 1 not in s:
//             j = arr[i]
//             while j in s:
//                 j += 1
//             result = max(result, j - arr[i])
//     return result
//
using namespace std;

int consecutiveArray(vector<int> arr) {
    set<int> st;
    int result = 0;

    for (int i = 0; i < arr.size(); i++) {
        st.insert(arr[i]);
    }
    for (int i = 0; i < arr.size(); i++) {
        if (!(std::find(arr.begin(), arr.end(), arr[i] - 1) != arr.end())) {
            int j = arr[i];
            while (std::find(st.begin(), st.end(), j) != st.end()) {
                j += 1;
            }
            int result = std::max(result, j - arr[i]);
        } 
        cout << result << endl;
    }

    return 0;
}

int main() {

    vector<int> v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);
    v.push_back(4);
    v.push_back(5);

    consecutiveArray(v);


    return 0;
}
