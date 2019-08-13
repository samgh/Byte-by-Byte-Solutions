/*
*   Title: Swap Variables
*
*   Given two integers, write a function that swaps them without using any temporary variables.
*
*   Execution: javac SwapVariables.java && java SwapVariables

*   For more details, check out http://www.byte-by-byte.com/swapvariables
*/

public class SwapVariables {
    public static int[] swap_1(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;

        int ar[] = new int[2];
        ar[0] = x;
        ar[1] = y;
        return ar; 
    }

    public static int[] swap_2(int x, int y) {
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        int ar[] = new int[2];
        ar[0] = x;
        ar[1] = y;
        return ar;
    }

    // Sample test cases
    public static void main(String[] args) {
        int ar_1[] = swap_1(1, 2);
        assert ar_1[0] == 2 && ar_1[1] == 1:
            "Swapped (1,2) with (2,1)";

        int ar_2[] = swap_1(5, 5);
        assert ar_2[0] == 5 && ar_2[1] == 5:
            "Swapped (5,5) with (5,5)";

        int ar_3[] = swap_1(-1, 40);
        assert ar_3[0] == 40 && ar_3[1] == -1:
            "Swaped(-1,40) with (40,-1)";
        
        int ar_4[] = swap_2(1, 2);
        assert ar_4[0] == 2 && ar_4[1] == 1:
            "Swapped (1,2) with (2,1)";

        int ar_5[] = swap_2(5, 5);
        assert ar_5[0] == 5 && ar_5[1] == 5:
            "Swapped (5,5) with (5,5)";

        int ar_6[] = swap_2(-1, 40);
        assert ar_6[0] == 40 && ar_6[1] == -1:
            "Swapped(-1,40) with (40,-1)";

        System.out.println("Passed all test cases");
    }
}
