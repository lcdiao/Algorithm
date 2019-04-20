package LintCode.白银2;

import java.util.ArrayList;
import java.util.List;

/**
 在起点和终点之间有 n 个石头, 下标(从0开始)为 i 的石头与起点的距离为 d[i], 终点与起点的距离为 target. 我们要从起点开始, 每次跳到相邻的石头上, 直至终点.

 问, 在可以移走不超过 m 个石头的前提下, 从起点跳到终点的过程中最短的一次跳跃距离的最大值是多少?

 样例
 样例 1:

 输入: n = 5, m = 2, target = 25, d = [2,11,14,17,21]
 输出: 4
 解释: 移走第一个和第三个石头, 然后跳跃的路径就是:
 1. 0 -> 11  11
 2. 11 -> 17 6
 3. 17 -> 21 4
 4. 21 -> 25 4
 样例 2:

 输入: n = 0, m = 0, target = 10, d = []
 输出: 10
 解释: 起点和终点直接没有石头, 也不需要移走任何石头. 直接从起点跳到终点, 距离为 10.
 注意事项
 1 0≤m≤n≤50,000
 2 1≤target≤1,000,000,000
 3 这些石头按与起点距离从小到大的顺序给出, 且不会有两个岩石出现在同一个位置.
 */
public class 跳石头 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);list.add(11);list.add(14);list.add(17);list.add(21);
        System.out.println(getDistance(5,2,25,list));
        //System.out.println(getDistance2(5,2,25,list));
        //System.out.println(getDistance(0,0,25,list));
    }

    /**
     * @param n: The total number of stones.
     * @param m: The total number of stones you can remove.
     * @param target: The distance from the end to the starting point.
     * @param d: The array that the distance from the i rock to the starting point is d[i].
     * @return: Return the maximum value of the shortest jump distance.
     */
    public static int getDistance(int n, int m, int target, List<Integer> d) {
        if (d == null || d.size() == 0) {
            return target;
        }
        if(n == 0) {
            return target;
        }
        while(m != 0) {
            int min = d.get(0);
            int num = 0;
            int mark = 0;
            for (int i = 1; i < d.size(); i++) {
                num = d.get(i) - d.get(i - 1);
                if (num < min) {
                    min = num;
                    mark = i;
                }
            }
            if (target - d.get(d.size() - 1) < min) {
                mark = d.size() - 1;
            }
            d.remove(mark);
            m--;
        }
        int min = d.get(0);
        int num = 0;
        for (int i = 1; i < d.size(); i++) {
            num = d.get(i) - d.get(i - 1);
            if (num < min) {
                min = num;
            }
        }
        return min;

    }


    //TODO 失败。。。
    public static int getDistance2(int n, int m, int target, List<Integer> d) {
        if (d == null || d.size() == 0) {
            return target;
        }
        if(n == 0) {
            return target;
        }
        d.add(target);
        int l = 0,r = target;
        while ( l <= r) {
            //int mid = (r - l)/2 + l;
            int mid = (r + l) >> 1;
            if (check(n,m,mid,d)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
    public static boolean check(int n,int m,int mid,List<Integer> d) {
        int cnt = 0,x = 0;
        for (int i = 0;i < n;) {
            i++;
            if (d.get(i) - d.get(x) < mid) {
                cnt++;
            } else {
                x = i;
            }
        }
        if (cnt > m) {
            return false;
        } else {
            return true;
        }
    }
}
