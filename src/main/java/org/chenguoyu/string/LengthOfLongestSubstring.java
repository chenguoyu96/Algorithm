package org.chenguoyu.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, length = 0;
        while (i <= j && j < s.length()) {
            boolean contains = set.contains(s.charAt(j));
            if (contains) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                length = Math.max(length, j - i);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(
                "abcabcbb"
        ));
    }
}
