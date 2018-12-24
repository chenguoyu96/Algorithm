package org.chenguoyu.string;

import org.chenguoyu.list.ListUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Reverse {
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
        org.chenguoyu.list.Reverse.reverse(strings, 0, strings.size() - 1);
        ListUtil.outList(strings);
    }
}
