package org.chenguoyu.string;

public class ZString {
    /**
     * leetcode 第6题
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        char[][] rowArrays = new char[numRows][s.length()];
        int col = 0, row = 0, index = 0;
        while (row >= 0 && row < numRows && index < s.length()) {
            rowArrays[row][col] = s.charAt(index++);
            if (row == numRows - 1) {
                while (row > 0 && index < s.length()) {
                    rowArrays[--row][++col] = s.charAt(index++);
                }
            }
            row++;
        }
        char[] result = new char[s.length()];
        index = 0;
        for (int i = 0; i < rowArrays.length; i++) {
            for (int j = 0; j < rowArrays[i].length; j++) {
                if ('\u0000' != rowArrays[i][j]) {
                    result[index++] = rowArrays[i][j];
                }
            }
        }
        return new String(result);
    }


    public static void main(String[] args) {
        System.out.println(new ZString().convert("LEETCODEISHIRING", 3));
    }
}
