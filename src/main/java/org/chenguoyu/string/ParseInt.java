package org.chenguoyu.string;

import org.junit.Test;

/**
 * 将字符串转化为数字
 *
 * @author 陈国钰
 * @date 2018-11-25
 * @project algorithm
 */
public class ParseInt {

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
