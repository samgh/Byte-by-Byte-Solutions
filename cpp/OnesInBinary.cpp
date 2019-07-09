/*
*   Title: Number of ones in binary representation.
*
*   Given an integer, write a function to compute the number of ones in 
*   the binary representation of the number.
*
*   Execution: g++ OnesInBinary.cpp -o OnesInBinary
*
*   For more details, check out http://www.byte-by-byte.com/onesinbinary
*/
#include <iostream>

using namespace std;
 
int onesInBinary(int x) {
    int sum = 0;
    while (x > 0) {
        sum += x & 1;
        x >>= 1;
    }
    return sum;
}

int main() {
    assert(onesInBinary(5) == 2);
    cout << "Binary representation of 5 has 2 ones" << endl;

    assert(onesInBinary(12) == 2);
    cout << "Binary representation of 12 has 2 ones" << endl;

    assert(onesInBinary(255) == 8);
    cout << "Binary representation of 255 has 8 ones" << endl;

    assert(onesInBinary(256) == 1);
    cout << "Binary representation of 256 has 1 ones" << endl;

    return 0;
}
