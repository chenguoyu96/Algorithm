package org.chenguoyu.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 链表的翻转
 *
 * @author 陈国钰
 * @date 2018-11-25
 * @project algorithm
 */
public class Reverse {
    /**
     * 将list中索引从from到to的元素翻转
     *
     * @param list
     * @param from
     * @param to
     * @param <T>
     */
    public static <T> void reverse(List<T> list, int from, int to) {
        while (from < to) {
            T temp = list.get(from);
            list.set(from++, list.get(to));
            list.set(to--, temp);
        }
    }

    /**
     * 将list中索引从from到结束的元素翻转
     *
     * @param list
     * @param beginIndex
     * @param <T>
     */
    public static <T> void reverse(List<T> list, int beginIndex) {
        reverse(list, 0, beginIndex - 1);
        reverse(list, beginIndex, list.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Reverse.reverse(list, 4);
        ListUtil.outList(list);
    }
}
