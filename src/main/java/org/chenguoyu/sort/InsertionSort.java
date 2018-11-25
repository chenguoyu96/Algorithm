package org.chenguoyu.sort;

import java.util.List;

/**
 * 插入排序
 *
 * @author 陈国钰
 * @date 2018-11-25
 * @project algorithm
 */
public class InsertionSort<T extends Comparable> {

    public void sort(List<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            T temp = arr.get(i);
            int j = i - 1;
            for (; j >= 0 && temp.compareTo(arr.get(j)) < 0; j--) {
                arr.set(j + 1, arr.get(j));
            }
            arr.set(j + 1, temp);
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = SortUtil.randomInts(10, 0, 10000);
        long before = System.currentTimeMillis();
        (new InsertionSort<Integer>()).sort(arr);
        long after = System.currentTimeMillis();
        System.out.println((double) (after - before) / 1000);
        SortUtil.outList(arr);
    }
}
