package LintCode.白银4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定数组A（下标从0到n-1，n为数组长度），和一个查询列表。每一项查询包括两个整数i和k。对于每次查询，计算Ai, A(i + 1), ..., A(i+k-1)的异或值。结果保存在列表中。

样例
Example1

Input: A = [1,2,3,4] and query = [(0,2),(1,2)]
Output: [3,1]
Explanation:
1 ^ 2 = 3
2 ^ 3 = 1
Example2

Input: A = [1,2,4,8] and query = [(0,3),(1,3)]
Output: [7,14]
Explanation:
1 ^ 2 ^ 4 = 7
2 ^ 4 ^ 8 = 14
注意事项
You can use‘^' to do it.In most languages '^' means XOR.
n<=1000,number of queries<=1000.
Ai<1000, k>0,i+k-1<n.
 */
public class 区间异或Ⅱ {
    public static void main(String[] args) {
        List<Interval> query = new LinkedList<>();
        query.add(new Interval(1,1));
        query.add(new Interval(1,1));
        query.add(new Interval(1,2));
        int[] A = new int[]{4,4,4};
        System.out.println(Arrays.toString(intervalXOR(A,query).toArray()));

    }

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
            int end ;
            if (i==k) {
                end = i;
            } else {
                end = (i+1)>=(i+k-1)?i+1:i+k-1;
            }
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
