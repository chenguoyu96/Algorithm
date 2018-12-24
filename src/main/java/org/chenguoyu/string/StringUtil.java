package org.chenguoyu.string;

import org.chenguoyu.list.ListUtil;
import org.chenguoyu.list.Reverse;
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
        List<String> strList = Arrays.asList("abc", "bdc", "bac", "bbc", "aab", "cdf");
        List<String> abc = isBotherStr(strList, "abc");
        ListUtil.outList(abc);
    }

    public int parseInt(String str) {
        char[] nums = str.toCharArray();
        int sign = 1;
        if (nums[0] == '+' || (nums[0] >= 48 && nums[0] <= 57)) {
            sign = 1;
        } else if (nums[0] == '-') {
            sign = 0;
        } else {
            throw new IllegalArgumentException("请输入数字");
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 57 || nums[i] < 48) {
                throw new IllegalArgumentException("请输入数字");
            }
        }
        int result = 0;
        if (nums[0] == '+' || nums[0] == '-') {
            for (int i = 1; i < nums.length; i++) {
                result += 10 * (nums.length - i) + (nums[i] - 48);
            }
            if (nums[0] == '-') {
                result = -result;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                result += sqrt(10, nums.length - i - 1) * (nums[i] - 48);
            }
        }

        return result;
    }

    public int sqrt(int base, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * base;
        }
        return result;
    }

    @Test
    public void sqrtTest() {
        System.out.println(sqrt(10, 5));
    }

    @Test
    public void parseIntTest() {
        System.out.println(parseInt("10522545459"));
    }
}
