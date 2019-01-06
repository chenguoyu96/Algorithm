package org.chenguoyu.list;

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                left++;
            }
        }
        return array[left];
    }
}
