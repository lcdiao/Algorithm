package LintCode.白银2;

import java.util.Arrays;

/**
 * n个人，他们每个人需要独立做m份作业。
 * 第i份作业需要花费cost[i]的时间。由于每个人的空闲时间不同，第i个人有val[i]的时间，这代表他做作业的总时间不会超过val[i]。每个人都按照顺序，从1号作业开始，然后做2号，3号...... 现在，你需要计算出他们最多花了多少的时间。
 *
 * 样例
 * 给定cost=[1,2,3,5]，val=[6,10,4]，返回15。
 *
 * 第一个人可以完成1号作业，2号作业，3号作业，1+2+3<=6。
 * 第二个人可以完成1号作业，2号作业，3号作业，无法完成4号作业，1+2+3<=10，1+2+3+5>10。
 * 第三个人可以完成1号作业，2号作业，无法完成3号作业，1+2<=4，1+2+3>4。
 * 1+2+3+1+2+3+1+2=15，返回15。
 * 注意事项
 * 1<=n<=100000
 * 1<=m<=100000
 * 1<=val[i]<=100000
 * 1<=cost[i]<=100000
 */
public class 写作业 {
    public static void main(String[] args) {
        //第i份作业需要花费cost[i]的时间
        int[] cost = new int[]{5,7,1,5,10,3,7,1};
        //第i个人有val[i]的时间
        int[] val = new int[]{11,5,40,41,2,17,32,1,1,6};


        int[] sum = cost;
        for (int i = 1; i < cost.length; i++) {
            sum[i] += sum[i-1];
        }
        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.binarySearch(sum,5));

        System.out.println(doingHomework2(cost,val));
    }

    public static long doingHomework2(int[] cost, int[] val) {
        int vlen = val.length;
        if (null == val || vlen == 0) {
            return 0L;
        }
        int clen = cost.length;
        if (null == cost || clen == 0) {
            return 0L;
        }
        long result = 0L;
        int[] sum = cost;
        for (int i = 1; i < clen; i++) {
            sum[i] += sum[i-1];
        }
        int n = 0;
        for (int i = 0; i < vlen; i++) {
            n = Arrays.binarySearch(sum,val[i]);
            if (n == -1) {
                continue;
            }
            if (n < 0) {
                n = -n - 2;
                if (n >= clen) {
                    n = clen - 1;
                }
            }
            result += sum[n];

        }
        return result;
    }
    /**
     * @param cost: the cost
     * @param val: the val
     * @return: the all cost
     */
    public static long doingHomework(int[] cost, int[] val) {
        int vlen = val.length;
        if (null == val || vlen == 0) {
            return 0L;
        }
        int clen = cost.length;
        if (null == cost || clen == 0) {
            return 0L;
        }
        long sum = 0L;
        long result = 0L;
        for (int i = 0; i < vlen; i++) {
            sum = 0L;
            for (int j = 0; j < clen; j++) {
                sum += cost[j];
                if (sum > val[i]) {
                    result += sum - cost[j];
                    break;
                }
                if (j == clen-1) {
                    result += sum;
                }
            }
        }
        return result;
    }
}
