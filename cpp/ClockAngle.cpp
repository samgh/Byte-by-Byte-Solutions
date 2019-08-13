/*
*   Title: Clock Angle
*
*   Given two integers, write a function that swaps them without using any 
*   temporary variables.
*
*   Execution: g++ ClockAngle.cpp -o ClockAngle
*
*   For more details, check out http://www.byte-by-byte.com/clockangle
*/

#include <iostream>
#include <cmath>

using namespace std;


double clockAngle(int hour, int minutes) {
    double MINUTES_PER_HOUR = 60;
    double DEGREES_PER_MINUTE = 360 / MINUTES_PER_HOUR;
    double DEGREES_PER_HOUR = 360 / 12;

    double minuteAngle = minutes * DEGREES_PER_MINUTE;
    double hourAngle = hour * DEGREES_PER_HOUR + (minutes / MINUTES_PER_HOUR) * DEGREES_PER_HOUR;

    double diff = std::abs(minuteAngle - hourAngle);
    if (diff > 180) {
        return 360 - diff;
    }

    return diff;
}

int main() {
    assert(clockAngle(3, 40) == 130);
    cout << "3:40 is 130 degrees." << endl;

    assert(clockAngle(1, 20) == 80);
    cout << "1:20 is 80 degrees." << endl;

    assert(clockAngle(5, 15) == 67.5);
    cout << "5:15 is 67.5 degrees." << endl;

    return 0;
}

