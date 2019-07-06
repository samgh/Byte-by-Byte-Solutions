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
