package LintCode.白银2;

import java.util.Arrays;

/**
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 *
 * 如果目标值不在数组中，则返回[-1, -1]
 *
 * 样例
 * 例1:
 *
 * 输入:
 * []
 * 9
 * 输出:
 * [-1,-1]
 *
 * 例2:
 *
 * 输入:
 * [5, 7, 7, 8, 8, 10]
 * 8
 * 输出:
 * [3, 4]
 * 挑战
 * 时间复杂度 O(log n)
 */
public class 搜索区间 {
    public static void main(String[] args) {
        int[] A = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(A,9)));
    }

    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public static int[] searchRange(int[] A, int target) {
        int len = A.length;
        int[] result = new int[]{-1,-1};
        if (null == A || len ==0) {
            return result;
        }
        int a = -1;
        int b = -1;
        int i = 0;
        int j = len-1;
        for (;i<len;i++) {
            if (A[i] == target) {
                a = i;
                break;
            }
        }
        for (; j >= i; j --) {
            if (A[j] == target) {
                b = j;
                break;
            }
        }
        result[0] = a;
        result[1] = b;
        return result;
    }
}
