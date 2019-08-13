/*
*   Title: Smallest Change
*
*   Given an input amount of change x, write a function to determine the 
*   minimum number of coins required to make that amount of change.

*   Execution: javac SmallestChange.java && java SmallestChange

*   For more details, check out http://www.byte-by-byte.com/smallestchange
*/

public class SmallestChange {
    public static int change(int x, int[] coins) {
        if (x == 0) {
            return 0;
        }
        int min = x;
        for (int coin : coins) {
            if (x - coin >= 0) {
                int c = change(x - coin, coins);
                if (min > c + 1) {
                    min = c + 1;
                }
            }
        }
        return min;
    }

    public static int changeDynamic(int x, int[] coins) {
        int[] cache = new int[x];
        for (int i = 1; i < x; i++) {
            cache[i] = -1;
        }
        return changeDynamic(x, coins, cache);
    }

    public static int changeDynamic(int x, int[] coins, int[] cache) {
        if (x == 0) {
            return 0;
        }
        int min = x;
        for (int coin : coins) {
            if (x - coin >= 0) {
                int c;
                if (cache[x - coin] >= 0) {
                    c = cache[x - coin];
                } else {
                    c = changeDynamic(x - coin, coins, cache);
                    cache[x - coin] = c;
                }
                if (min > c + 1) {
                    min = c + 1;
                }
            }
        }
        return min;
    }

    // Sample test cases
    public static void main(String[] args) {
        int[] coins = new int[]{1, 5, 10, 25};

        // Tests for change:
        assert change(1, coins) == 1:
            "Smallest from 1 is 1";

        assert change(3, coins) == 3:
            "Smallest from 3 is 3";

        assert change(7, coins) == 3:
            "Smallest from 7 is 3";

        assert change(32, coins) == 4:
            "Smallest from 32 is 4";
    
        // Tests for changeDynamic:
        assert changeDynamic(1, coins) == 1:
            "Smallest from 1 is 1";

        assert changeDynamic(3, coins) == 3:
            "Smallest from 3 is 3";

        assert changeDynamic(7, coins) == 3:
            "Smallest from 7 is 3";

        assert changeDynamic(32, coins) == 4:
            "Smallest from 32 is 4";

        System.out.println("Passed all test cases");
    }
}
