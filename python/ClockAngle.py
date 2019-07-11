"""
   Title: Clock Angle

   Given two integers, an hour and a minute, write a function to 
   calculate the angle between the two hands on a clock representing
   that time.

   Execution: python ClockAngle.py

   For more details, check out http://www.byte-by-byte.com/clockangle
"""
import unittest


def clock_angle(hour: int, minutes: int):
    MINUTES_PER_HOUR = 60
    DEGREES_PER_MINUTE = 360 / MINUTES_PER_HOUR
    DEGREES_PER_HOUR = 360 / 12

    minute_angle = minutes * DEGREES_PER_MINUTE
    hour_angle = hour * DEGREES_PER_HOUR + (minutes / MINUTES_PER_HOUR) * DEGREES_PER_HOUR

    diff = abs(minute_angle - hour_angle)

    if diff > 180:
        return 360 - diff

    return diff


class TestClockAngle(unittest.TestCase):
    def test_340(self):
        self.assertEqual(clock_angle(3, 40), 130)
        print("3:40 is 130 degrees.")

    def test_120(self):
        self.assertEqual(clock_angle(1, 20), 80)
        print("1:20 is 80 degrees.")

    def test_515(self):
        self.assertEqual(clock_angle(5, 15), 67.5)
        print("5:15 is 67.5 degrees.")


if __name__ == '__main__':
    unittest.main()
