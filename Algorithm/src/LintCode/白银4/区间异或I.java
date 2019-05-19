package LintCode.白银4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定数组A（下标从0到n-1，n为数组长度），和一个查询列表。每一项查询包括两个整数i和k。对于每次查询，计算Ai, A(i + 1), ..., A(i+k-1)的异或和。结果保存在列表中。

样例
样例1

输入: A = [1,2,3,4] and query = [(0,2),(1,2)]
输出: [3,1]
解释:
1 ^ 2 = 3
2 ^ 3 = 1
样例2

输入: A = [1,2,4,8] and query = [(0,2),(2,2)]
输出: [3,12]
解释:
1 ^ 2 = 3
4 ^ 8 = 12
注意事项
在大部分编程语言中你可以使用 '^'来进行异或运算。
在这个问题中，k永远等于2。
数组长度小于10000，查询次数小于1000。
保证Ai<1000,i+k<n。
 */
public class 区间异或I {

    /**
     * @param A:
     * @param query:
     * @return: nothing
     */
    public static List<Integer> intervalXOR(int[] A, List<Interval> query) {
        List<Integer> list = new LinkedList<>();
        if (A == null ) {
            return list;
        }
        if (query == null) {
            return list;
        }
        for (Interval interval : query) {
            int i = interval.start;
            int k = interval.end;
            int end = (i+1)>=(i+k-1)?i+1:i+k-1;
            Integer num = A[i];
            for (int j=i+1;j<=end&&j<A.length;j++) {
                num ^= A[j];
            }
            list.add(num);
        }
        return list;
    }

    static   class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
