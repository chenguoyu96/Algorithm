package org.chenguoyu.sort;/**
 * Created by 陈国钰 on 2018/3/28 0028.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author chenguoyu
 * @describe 排序工具类
 * @date 2018/3/28 0028
 */
public class SortUtil {
    /**
     * 交换List中的a,b下标的两个元素
     *
     * @param arr
     * @param a
     * @param b
     * @param <T>
     */
    public static <T> void swap(List<T> arr, int a, int b) {
        T temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    /**
     * 打印集合
     *
     * @param arr
     * @param <T>
     */
    public static <T> void outList(Collection<T> arr) {
        for (T t : arr) {
            System.out.print(t + " ");
        }
    }

    /**
     * 创建一个生成n个从min到max之间的随机数的数组
     *
     * @param n
     * @param min
     * @param max
     * @return
     */
    public static List<Integer> randomInts(int n, int min, int max) {
        List<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(randomInt(min, max));
        }
        return arr;
    }

    /**
     * 生成一个从min到max的数字
     *
     * @param min
     * @param max
     * @return
     */
    public static int randomInt(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
}
