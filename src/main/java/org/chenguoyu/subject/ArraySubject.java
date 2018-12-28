package org.chenguoyu.subject;

import org.junit.Test;

/**
 * 数组相关的算法题
 */
public class ArraySubject {
    /**
     * 二维数组中的查找
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        int rowLength = array.length;
        int colLength = array[0].length - 1;
        int i = 0, j = colLength;
        while (i < rowLength && j >= 0) {
            int value = array[i][j];
            if (value > target) {
                j--;
            } else if (value < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void FindTest() {
        int[][] value = {{1, 2, 8, 9}, {4, 7, 10, 13}};
        System.out.println(Find(7, value));
    }

}
