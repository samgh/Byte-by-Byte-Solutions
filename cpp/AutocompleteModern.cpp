/*
 * Title: AutocompleteModern
 * Author: Mohamed Amine Mzoughi
 * Date: 04/01/2018
 * 
 * Write an autocomplete class that returns all dictionary words with 
 * a given prefix.
 * 
 * Execution: g++ AutocompleteModern.cpp -o AutocompleteModern && ./AutocompleteModern
 * 
 * For more details, check out http://www.byte-by-byte.com/autocomplete/
 */

#include <algorithm>
#include <cassert>
#include <iostream>
#include <memory>
#include <string>
#include <unordered_map>
#include <vector>

class Autocomplete
{
    // Trie node class
    struct Node
    {
        std::string m_prefix;
        std::unordered_map<char, std::unique_ptr<Node>> m_children;

        // Does this node represent the last character in a word?
        bool m_isWord;
        
        Node(const std::string& prefix) :
            m_prefix(prefix),
            m_isWord(false)
        {
        }
    };

    // The trie
    Node m_trie;

    // Insert a word into the trie
    void insertWord(const std::string& s)
    {
        // Iterate through each character in the string. If the character is not
        // already in the trie then add it
        Node* curr = &m_trie;
        for (size_t charIndex = 0; charIndex < s.size(); ++charIndex)
        {
            if (curr->m_children.find(s[charIndex]) == curr->m_children.end())
            {
                curr->m_children.emplace(s[charIndex], new Node(s.substr(0, charIndex + 1)));
            }
            curr = curr->m_children[s[charIndex]].get();

            if (charIndex == s.size() - 1)
            {
                curr->m_isWord = true;
            }
        }
    }

    // Recursively find every child word
    void findAllChildWords(Node& n, std::vector<std::string>& results) const
    {
        if (n.m_isWord)
        {
            results.push_back(n.m_prefix);
        }
        
        for (const auto& child : n.m_children) {
            findAllChildWords(*child.second, results);
        }
    }

public:
    // Construct the trie from the dictionary
    Autocomplete(const std::vector<std::string>& dict) :
        m_trie("")
    {
        for (const auto& s : dict)
        {
            insertWord(s);
        }
    }
    
    // Find all words in trie that start with prefix
    std::vector<std::string> getWordsForPrefix(const std::string& pre)
    {
        std::vector<std::string> results;
        
        // Iterate to the end of the prefix
        Node* curr = &m_trie;
        for (const auto c : pre)
        {
            if (curr->m_children.find(c) != curr->m_children.end())
            {
                curr = curr->m_children[c].get();
            }
            else
            {
                return results;
            }
        }

        // At the end of the prefix, find all child words
        findAllChildWords(*curr, results);
        return results;
    }
};

static bool compareArrays(std::vector<std::string>&& s1,
                          std::vector<std::string>&& s2)
{
    if (s1.size() != s2.size())
    {
        return false;
    }

    std::sort(s1.begin(), s1.end());
    std::sort(s2.begin(), s2.end());
    
    return std::equal(s1.begin(), s1.end(), s2.begin());
}

int main(int argc, char* argv[])
{
    (void) argc;
    (void) argv;

    Autocomplete a({"abc", "acd", "bcd", "def", "a", "aba"});

    assert("Empty string" && compareArrays(a.getWordsForPrefix(""), 
                                           {"abc", "acd", "bcd", "def", "a", "aba"}));
    
    assert("Single character prefix" && compareArrays(a.getWordsForPrefix("a"), 
                                                      {"abc", "acd", "a", "aba"}));
    
    assert("Prefix the length of the string" && compareArrays(a.getWordsForPrefix("def"), {"def"}));
    
    assert("No results" && compareArrays(a.getWordsForPrefix("abcd"), {}));

    std::cout << "Passed all test cases\n";
}
