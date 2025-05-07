// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:

// Input: s = "egg", t = "add"

// Output: true

// Explanation:

// The strings s and t can be made identical by:

// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.
// problem link:https://leetcode.com/problems/isomorphic-strings/description/
import java.util.*;

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Character> hmST = new HashMap<>();
        Map<Character,Character> hmTS = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);

            if(hmST.containsKey(c1)){
                if(hmST.get(c1)!=c2) return false;
            }else{
                hmST.put(c1,c2);
            }

            if(hmTS.containsKey(c2)){
                if(hmTS.get(c2)!=c1) return false;
            }else{
                hmTS.put(c2,c1);
            }
        }
        return true;
    }
}
