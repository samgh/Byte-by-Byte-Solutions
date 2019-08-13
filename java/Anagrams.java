/*
*   Title: Anagrams
*
*   Given two strings, write a function to determine whether they are anagrams.
* 
*
*   Execution: javac Anagrams.java && java Anagrams

*   For more details, check out http://www.byte-by-byte.com/anagrams
*/

public class Anagrams {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] letters = new int[1<<8];

        for (char c : s1.toCharArray()) {
            letters[c]++;
        }

        for (char c : s2.toCharArray()) {
            letters[c]--;
        }

        for (int i : letters) {
            if (i != 0) return false;
        }
        return true;
    }

    // Sample test cases
    public static void main(String[] args) {
        assert isAnagram("", "") == true:
            "Empty string s1='' and string s2='' are anagrams";
        assert isAnagram("A", "A") == true:
            "Empty string s1='A' and string s2='A' are anagrams";
        assert isAnagram("A", "B") == false:
            "Empty string s1='A' and string s2='B' are not anagrams";
        assert isAnagram("ab", "ba") == true:
            "Empty string s1='ab' and string s2='ba' are anagrams";
        assert isAnagram("AB", "ab") == true:
            "Empty string s1='AB' and string s2='ab' are anagrams";

        System.out.println("Passed all test cases");
    }
}
