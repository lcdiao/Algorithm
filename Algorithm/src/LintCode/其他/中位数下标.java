package LintCode.其他;

import java.util.Arrays;

/**
 * 给出一个含有 n 个互不相等整数的无序数组，找到其中中位数的下标。下标从 0 开始。
 *
 * 中位数是指这些数排序后最中间的数。
 *
 * 若 n 为偶数，则中位数是数组排序后的第 n/2 个数。
 *
 * 样例
 * 样例 1：
 *
 * 输入：[4,5,1,2,3]
 * 输出：4
 * 样例 2：
 *
 * 输入：[7,9,4,5]
 * 输出：3
 * 注意事项
 * 1 \leq n \leq 1000001≤n≤100000
 * 所有数都各不相同
 */
public class 中位数下标 {
    public static void main(String[] args) {
        int[] a = {4,5,1,2,3};
        System.out.println(getAns(a));
    }

    /**
     * @param a: the array a
     * @return: return the index of median
     */
    public static int getAns(int[] a) {
        int len = a.length;
        if (null == a || len == 0) {
            return 0;
        }
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            b[i] = a[i];
        }
        Arrays.sort(a);
        int n = a[(len-1)/2];
        for (int i = 0; i < len; i++) {
            if (b[i] == n) {
                return i;
            }
        }
        return 0;
    }
}
