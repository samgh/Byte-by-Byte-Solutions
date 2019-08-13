/*
*   Title: String deletion
*
*   Given a string and a dictionary HashSet, write a function to determine the 
*   minimum number of characters to delete to make a word.
*
*   Execution: javac StringDeletion.java && java StringDeletion
*
*   For more details, check out http://www.byte-by-byte.com/stringdeletion
*/
import java.util.*;

public class StringDeletion {
    public static int delete(String query, HashSet<String> dictionary) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> queueElements = new HashSet<String>();

        queue.add(query);
        queueElements.add(query);

        while (!queue.isEmpty()) {
            String s = queue.remove();
            queueElements.remove(s);
            if (dictionary.contains(s)) {
               return query.length() - s.length();
            }
            for (int i = 0; i < s.length(); i++) { 
                String sub = s.substring(0, i) + s.substring(i+1, s.length()); 
                if (sub.length() > 0 && !queueElements.contains(sub)) {
                    queue.add(sub);
                    queueElements.add(sub);
                }
            }
        }
        return -1;
    }

    // Sample test cases
    public static void main(String[] args) {
        String query = "abc";
        HashSet<String> hset = new HashSet<String>();

        hset.add("a"); 
        hset.add("aa"); 
        hset.add("aaa");

        assert delete(query, hset) == 2:
            "Successfully determines 2 strings.";

        System.out.println("Passed all test cases");
    }
}
