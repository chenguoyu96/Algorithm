package org.chenguoyu.string;

import org.junit.Test;

/**
 * 对字符串的一些操作
 *
 * @author 陈国钰
 * @date 2018-11-25
 * @project algorithm
 */
public class Strings {
    /**
     * 字符串翻转
     *
     * @param str
     * @param from
     * @param to
     * @return
     */
    public String reverse(String str, int from, int to) {
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


}
