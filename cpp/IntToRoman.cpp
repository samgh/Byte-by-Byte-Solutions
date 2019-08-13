/*
*   Title: Int to Roman
*
*   Write a function to convert an integer into its roman numeral representation
*
*   Execution: g++ -std=c++11 IntToRoman.cpp -o IntToRoman
*
*   For more details, check out http://www.byte-by-byte.com/inttoroman
*/
#include<iostream>
#include <vector>

using namespace std;

// def int_to_roman(value):
//     if value > 3999 or value < 1:
//         raise ValueError(f"Value {value} is above 3999 or below 1.")
//     i = 0
//     numeral = []
//     while value > 0:
//         if value - values[i] >= 0:
//             numeral.append(numerals[i])
//             value -= values[i]
//         else:
//             i += 1
//     return ''.join(numeral)

string intToRoman(int value) {
    vector<string> numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; 
    vector<int> values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    if ( (value > 3999) || (value < 1) ) {
        cout << "Error: " << value << endl;
    }     
    int i = 0;
    vector<string> numeral;
    while (value > 0) {
        if (value - values[i] >= 0) {
            numeral.push_back(numerals[i]);
            value -= values[i];
        }
        else {
            i += 1;
        }
    }

    string ret = "";
    for (int i = 0; i < numeral.size(); i++) {
        ret += numeral[i];
    }

    return ret;
}

int main() {

    assert(intToRoman(1) == "I");
    cout << "1 converts to I" << endl;

    assert(intToRoman(5) == "V");
    cout << "5 converts to V" << endl;

    assert(intToRoman(4) == "IV");
    cout << "4 converts to IV" << endl;

    assert(intToRoman(6) == "VI");
    cout << "6 converts to VI" << endl;

    assert(intToRoman(11) == "XI");
    cout << "11 converts to XI" << endl;

    assert(intToRoman(49) == "XLIX");
    cout << "49 converts to XLIX" << endl;

    assert(intToRoman(2020) == "MMXX");
    cout << "2020 converts to MMXX" << endl;

    return 0;
}
