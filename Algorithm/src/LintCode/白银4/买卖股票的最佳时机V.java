package LintCode.白银4;

/**
 给出一个股票n天的价格，每天最多只能进行一次交易，可以选择买入一支股票或卖出一支股票或放弃交易，输出能够达到的最大利润值

 样例
 样例 1:

 给出 `a = [1,2,10,9]`, 返回 `16`
 输入:
 [1,2,10,9]
 输出:
 16

 解释:
 你可以在第一天和第二天买入股票，第三天和第四天卖出
 利润：-1-2+10+9 = 16
 样例 2:

 给出 `a = [9,5,9,10,5]`, 返回 `5`
 输入:
 [9,5,9,10,5]
 输出:
 5

 解释:
 你可以在第2天买入，第4天卖出
 利润:-5 + 10 = 5
 注意事项
 1≤n≤10000
 */
public class 买卖股票的最佳时机V {
    public static void main(String[] args) {
        System.out.println(getAns(new int[]{9,5,9,10,5}));
    }

    /**
     * @param a: the array a
     * @return: return the maximum profit
     */
    public static int getAns(int[] a) {
        if(a==null||a.length<=1) {
            return 0;
        }
        int len = a.length;
        int[] b = new int[len];
        for (int i = 0;i < len; i++) {
            boolean flag = true;
            for (int j = len-1; j > i; j--) {
                if (a[j] - a[i] > 0) {
                    if (b[j] == 0) {
                        b[j] = a[j] - a[i];
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                for (int j = len-1; j > i; j--) {
                    if (b[j] != 0) {
                        if (a[i]-a[j] > b[j]) {
                            b[j] = a[i]-a[j];
                            break;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += b[i];
        }
        return result;
    }
}
