/*
* Title: Fibonacci
*
* Execution: g++ Fibonacci.cpp -o Fibonacci
*
* For more details, check out http://www.byte-by-byte.com/fibonacci
*/

#include <iostream>
#include <vector>

using namespace std;

long fibonacci_recur(int x, vector<long> cache) {
    if (cache[x] > -1) {
        return cache[x];
    }
    cache[x] = fibonacci_recur(x-1, cache) + fibonacci_recur(x-2, cache);
    return cache[x];
}

long fibonacci(int x) {
    if (x < 0) {
        return -1;
    }
    if (x == 0) {
        return 0;
    }
    std::vector<long> cache(x+1);
    for (int i = 1; i < cache.size(); i++) {
        cache[i] = -1;
    }
    cache[1] = 1;
    return fibonacci_recur(x, cache);
}

int main() {
    assert(fibonacci(1) == 1);
    cout << "fib(1) = 1" << endl;

    assert(fibonacci(5) == 5);
    cout << "fib(5) = 5" << endl;

    assert(fibonacci(10) == 55);
    cout << "fib(10) = 55" << endl;
    return 0;
}
