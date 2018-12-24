package org.chenguoyu.string;

import java.util.Arrays;

public class SubstringSearch {
    /**
     * 暴力算法 比较慢
     *
     * @param str
     * @param subStr
     * @return
     */
    public boolean hasSubString(String str, String subStr) {
        if (subStr.length() > str.length())
            return false;
        char[] text = str.toCharArray();
        char[] pattern = subStr.toCharArray();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < str.length() && j < subStr.length()) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = 0;
                k++;
                i = k;
            }
        }
        if (j == subStr.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        SubstringSearch ss = new SubstringSearch();
//        boolean result = ss.hasSubString(str, subString);
        boolean result = ss.KMP(str, subString);
        System.out.println(result);
    }

    /**
     * kmp算法查看字符串是否包含
     *
     * @param str
     * @param subStr
     * @return
     */
    public boolean KMP(String str, String subStr) {
        char[] pattern = subStr.toCharArray();
        int[] lps = computeTemporaryArray(pattern);
        char[] text = str.toCharArray();
        int j = 0;
        for (int i = 0; i < text.length; ) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == subStr.length()) {
            return true;
        }
        return false;
    }

    private int[] computeTemporaryArray(char[] pattern) {
        // int 初始化默认为0
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[index] == pattern[i]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
