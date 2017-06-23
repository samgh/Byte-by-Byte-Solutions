/*
 * Title: Autocomplete
 * Author: Sam Gavis-Hughson
 * Date: 11/13/2016
 * 
 * Write an autocomplete class that returns all dictionary words with 
 * a given prefix.
 * 
 * Execution: javac Autocomplete.java && java Autocomplete
 * 
 * For more details, check out http://www.byte-by-byte.com/autocomplete/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Autocomplete {
    
    // Trie node class
    private class Node {
        String prefix;
        HashMap<Character, Node> children;
        
        // Does this node represent the last character in a word?
        boolean isWord;
        
        private Node(String prefix) {
            this.prefix = prefix;
            this.children = new HashMap<Character, Node>();
        }
    }
    
    // The trie
    private Node trie;
    
    // Construct the trie from the dictionary
    public Autocomplete(String[] dict) {
        trie = new Node("");
        for (String s : dict) insertWord(s);
    }
    
    // Insert a word into the trie
    private void insertWord(String s) {
        // Iterate through each character in the string. If the character is not
        // already in the trie then add it
        Node curr = trie;
        for (int i = 0; i < s.length(); i++) {
            if (!curr.children.containsKey(s.charAt(i))) {
                curr.children.put(s.charAt(i), new Node(s.substring(0, i + 1)));
            }
            curr = curr.children.get(s.charAt(i));
            if (i == s.length() - 1) curr.isWord = true;
        }
    }
    
    // Find all words in trie that start with prefix
    public List<String> getWordsForPrefix(String pre) {
        List<String> results = new LinkedList<String>();
        
        // Iterate to the end of the prefix
        Node curr = trie;
        for (char c : pre.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }
        
        // At the end of the prefix, find all child words
        findAllChildWords(curr, results);
        return results;
    }
    
    // Recursively find every child word
    private void findAllChildWords(Node n, List<String> results) {
        if (n.isWord) results.add(n.prefix);
        for (Character c : n.children.keySet()) {
            findAllChildWords(n.children.get(c), results);
        }
    }
    
    // Sample test cases
    public static void main(String[] args) {
        Autocomplete a = new Autocomplete(new String[]{"abc", "acd", "bcd", "def", "a", "aba"});
        
        assert compareArrays((String[])a.getWordsForPrefix("").toArray(new String[6]), 
                             new String[]{"abc", "acd", "bcd", "def", "a", "aba"}):
            "Empty string";
        assert compareArrays((String[])a.getWordsForPrefix("a").toArray(new String[4]), 
                             new String[]{"abc", "acd", "a", "aba"}):
            "Single character prefix";
        assert compareArrays((String[])a.getWordsForPrefix("def").toArray(new String[1]), 
                             new String[]{"def"}):
            "Prefix the length of the string";
        assert compareArrays((String[])a.getWordsForPrefix("abcd").toArray(new String[0]), 
                             new String[]{}):
            "No results";
        System.out.println("Passed all test cases");
    }
    
    private static boolean compareArrays(String[] s1, String[] s2) {
        if (s1.length != s2.length) return false;
        
        Arrays.sort(s1);
        Arrays.sort(s2);
        
        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals(s2[i])) return false;
        }
        
        return true;
    }
}