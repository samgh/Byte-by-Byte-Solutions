/*
* Title: FizzBuzz
*
* Output numbers from 1 to x. If the number is divisible by 3, replace it with 
* “Fizz”. If it is divisible by 5, replace it with “Buzz”. If it is divisible 
* by 3 and 5 replace it with “FizzBuzz”.
*
* Execution: g++ FizzBuzz.cpp -o FizzBuzz
*
* For more details, check out http://www.byte-by-byte.com/fizzbuzz
*/

#include <iostream>

using namespace std;

std::string fizzBuzz(int i) {
    if (i % 3 == 0 && i % 5 == 0) {
        return "FizzBuzz";
    } else if (i % 3 == 0) {
        return "Fizz";
    } else if (i % 5 == 0) {
        return "Buzz";
    } else {
        return std::to_string(i);
    }
}

int main() {
    assert(fizzBuzz(1) == "1");
    cout << "1 produces 1." << endl;

    assert(fizzBuzz(2) == "2");
    cout << "2 produces 2." << endl;

    assert(fizzBuzz(3) == "Fizz");
    cout << "3 produces Fizz" << endl;

    assert(fizzBuzz(5) == "Buzz");
    cout << "5 produces Buzz" << endl;

    assert(fizzBuzz(9) == "Fizz");
    cout << "9 produces Fizz" << endl;

    assert(fizzBuzz(15) == "FizzBuzz");
    cout << "15 produces FizzBuzz" << endl;

    return 0;
}
