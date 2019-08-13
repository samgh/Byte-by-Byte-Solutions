/*
*   Title: Clock Angle
*
*   Given two integers, an hour and a minute, write a function to 
*   calculate the angle between the two hands on a clock representing
*   that time.
*
*   Execution: javac ClockAngle.java && java ClockAngle

*   For more details, check out http://www.byte-by-byte.com/clockangle
*/

public class ClockAngle {
    public static double clockAngle(int hour, int minutes) {
        final double MINUTES_PER_HOUR = 60;
        final double DEGREES_PER_MINUTE = 360 / MINUTES_PER_HOUR;
        final double DEGREES_PER_HOUR = 360 / 12;

        double minuteAngle = minutes * DEGREES_PER_MINUTE;
        double hourAngle = hour * DEGREES_PER_HOUR + (minutes / MINUTES_PER_HOUR) * DEGREES_PER_HOUR;

        double diff = Math.abs(minuteAngle - hourAngle);
        if (diff > 180) {
            return 360 - diff;
        }
        return diff;
    }

    // Sample test cases
    public static void main(String[] args) {

        assert clockAngle(3, 40) == 130:
            "3:40 is 130 degrees";

        assert clockAngle(1, 20) == 80:
            "1:20 is 80 degrees";
        
        assert clockAngle(5, 15) == 67.5:
            "5:15 is 67.5 degrees";

        System.out.println("Passed all test cases");
    }
}
