package org.chenguoyu.list.sort;

import org.chenguoyu.list.ListUtil;

import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 */
public class QuickSort<T extends Comparable<T>> {
    public void sort(List<T> arr) {
        sort(arr, 0, arr.size()-1);
    }

    private void sort(List<T> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    /**
     * 对arr进行划分操作
     * 使得arr[l...p]<=arr[p] arr[p+1...r]>=arr[p]>
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partition(List<T> arr, int l, int r) {
        T v = arr.get(l);
        //使得arr[l+1...j]<=v arr[j+1...i]>=v
        int j = l;
        for (int i = l; i <= r; i++) {
            if (arr.get(i).compareTo(v) > 0) {
                Collections.swap(arr, i, ++j);
            }
        }
        //最后 交换l与j
        Collections.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        List<Integer> arr = ListUtil.randomInts(10000, 0, 10000);
        (new QuickSort<Integer>()).sort(arr);
        ListUtil.outList(arr);
    }
}
