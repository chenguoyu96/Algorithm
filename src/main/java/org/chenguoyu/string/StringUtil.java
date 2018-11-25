package org.chenguoyu.string;

import org.chenguoyu.list.ListUtil;
import org.chenguoyu.list.reverse.Reverse;
import org.junit.Test;

import java.util.*;

/**
 * 对字符串的一些操作
 *
 * @author 陈国钰
 * @date 2018-11-25
 * @project algorithm
 */
public class StringUtil {
    /**
     * 字符串翻转
     *
     * @param str
     * @param from
     * @param to
     * @return
     */
    public static String reverse(String str, int from, int to) {
        char[] chars = str.toCharArray();
        while (from < to) {
            char temp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = temp;
        }
        return new String(chars);
    }

    @Test
    public void reverseTest() {
        String str = reverse("abcdef", 0, 5);
        System.out.println(str);
    }

    /**
     * 将字符串末尾的m个元素移动到头部
     *
     * @param str
     * @param m
     */
    public static String removeToBegin(String str, int m) {
        char[] chars = str.toCharArray();
        int i = 0;
        char[] result = new char[str.length()];
        for (int end = chars.length - m; end < chars.length; end++) {
            result[i++] = chars[end];
        }
        for (int j = 0; i < str.length(); j++, i++) {
            result[i] = chars[j];
        }
        return new String(result);
    }

    @Test
    public void removeToBeginTest() {
        String temp = "Ilovebaofeng";
        String str = removeToBegin(temp, 7);
        System.out.println(str);
    }

    @Test
    public void strReverse() {
        String str = "I am a student.";
        List<String> strings = Arrays.asList(str.split(" "));
        Reverse.reverse(strings, 0, strings.size() - 1);
        ListUtil.outList(strings);
    }

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
        List<String> strList = Arrays.asList("abc","bdc","bac","bbc","aab","cdf");
        List<String> abc = isBotherStr(strList, "abc");
        ListUtil.outList(abc);
    }
}
