package org.chenguoyu.list.sort;

import org.chenguoyu.list.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable> {
    public void sort(List<T> list) {
        mergeSort(list, 0, list.size() - 1);
    }


    private void mergeSort(List<T> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(list, left, middle);
        mergeSort(list, middle + 1, right);
        mergeSort(list, left, middle, right);
    }

    private void mergeSort(List<T> list, int left, int middle, int right) {
        List<T> aux = new ArrayList<>(right - left + 1);
        for (int i = left; i <= right; i++) {
            aux.add(list.get(i));
        }
        int i = left, j = middle + 1;
        for (int k = left; k <= right; k++) {
            if (i > middle) {
                list.set(k, aux.get(j - left));
                j++;
            } else if (j > right) {
                list.set(k, aux.get(i - left));
                i++;
            } else if (aux.get(j - left).compareTo(aux.get(i - left)) > 0) {
                list.set(k, aux.get(j - left));
                j++;
            } else {
                list.set(k, aux.get(i - left));
                i++;
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> arr = ListUtil.randomInts(10, 0, 10000);
        long before = System.currentTimeMillis();
        (new MergeSort<Integer>()).sort(arr);
        long after = System.currentTimeMillis();
        System.out.println((double) (after - before) / 1000);
        ListUtil.outList(arr);
    }
}
