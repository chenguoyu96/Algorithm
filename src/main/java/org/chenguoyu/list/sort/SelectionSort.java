package org.chenguoyu.list.sort;

import org.chenguoyu.list.ListUtil;

import java.util.List;

/**
 * 选择排序
 *
 * @author 陈国钰
 * @date 2018-11-25
 * @project algorithm
 */
public class SelectionSort<T extends Comparable> {

    public void sort(List<T> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int k = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(k).compareTo(arr.get(j)) < 0) {
                    k = j;
                }
            }
            ListUtil.swap(arr, i, k);
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = ListUtil.randomInts(10000, 0, 10000);
        (new SelectionSort<Integer>()).sort(arr);
        ListUtil.outList(arr);
    }
}
