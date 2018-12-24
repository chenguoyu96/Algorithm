package org.chenguoyu.string;

import org.chenguoyu.list.ListUtil;
import org.junit.Test;

import java.util.*;

public class CharContain {
    /**
     * b字符串中的字符是否都包含在a字符串中
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isContain(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Set<Character> set = new HashSet<>(aChars.length);
        for (char aChar : aChars) {
            set.add(aChar);
        }
        for (char bChar : bChars) {
            set.add(bChar);
        }
        return aChars.length == set.size();
    }

    @Test
    public void isContainTest() {
        String str1 = "ABCD", str2 = "BCD";
        System.out.println(isContain(str1, str2));
    }

    public int charSum(char[] chars) {
        int result = 0;
        for (char aChar : chars) {
            result += aChar;
        }
        return result;
    }

    public static boolean isBother(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Set<Character> set = new HashSet<>(b.length());
        for (char bChar : bChars) {
            set.add(bChar);
        }
        return isContain(a, b) && (set.size() == aChars.length);
    }

    public List<String> isBotherStr(List<String> dict, String str) {
        Map<Integer, Set<String>> dictMap = new HashMap<>(dict.size());
        for (String s : dict) {
            int key = charSum(s.toCharArray());
            if (dictMap.get(key) == null) {
                HashSet<String> strings = new HashSet<>();
                strings.add(s);
                dictMap.put(key, strings);
            } else {
                Set<String> strings = dictMap.get(key);
                strings.add(s);
                dictMap.put(key, strings);
            }
        }
        Set<String> strings = dictMap.get(charSum(str.toCharArray()));
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            if (isBother(string, str)) {
                result.add(string);
            }
        }
        return result;
    }

    @Test
    public void isBotherTest() {
        List<String> strList = Arrays.asList("abc", "bdc", "bac", "bbc", "aab", "cdf");
        List<String> abc = isBotherStr(strList, "abc");
        ListUtil.outList(abc);
    }
}
