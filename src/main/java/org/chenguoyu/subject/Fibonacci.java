package org.chenguoyu.subject;

public class Fibonacci {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）
     * n<=39
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     * 假设n级台阶一共有f(n)种跳法
     * 假设第一次跳了1级，那么剩下f(n-1)种跳法
     * 假设第一次跳了2级，那么剩下f(n-2)种跳法
     * 所以f(n)=f(n-1)+f(n-2)为斐波那契数列
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        return 2 * JumpFloorII(target - 1);
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
