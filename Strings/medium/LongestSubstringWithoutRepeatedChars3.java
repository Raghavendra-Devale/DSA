package Strings.medium;


import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatedChars3 {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i = 0; i <s.length(); i++){
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (seen.contains(s.charAt(j))){
                    break;
                }
                seen.add(s.charAt(j));
                maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println("Brute force "+ lengthOfLongestSubstring("abcabcbb"));
    }
}
