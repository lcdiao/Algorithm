package LintCode.其他;

/**
 给定一个非负整数, 你可以选择交换它的两个数位. 返回你能获得的最大的合法的数.

 样例
 样例1:

 输入: 2736
 输出: 7236
 解释: 交换数字2和数字7.
 样例2:

 输入: 9973
 输出: 9973
 解释: 不用交换.
 注意事项
 给定的数字在 [0, 10^8] 范围内
 */
public class 最大的交换 {

    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }

    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public static int maximumSwap(int num) {
        String s = num + "";
        int len = s.length();
        int[] n = new int[len];
        for (int i = 0; i < len; i++ ) {
            n[i] = Integer.parseInt(s.charAt(i)+"");
        }
        int index = 0;
        int max = 0;
        boolean flag = false;
        while (index < len) {
            max = index;
            for (int i = index+1; i < len; i++) {
                if (n[i] >= n[max]) {
                    max = i;
                }
            }
            if (max != index && n[max] != n[index]) {
                flag = true;
                n[max] ^= n[index];
                n[index] ^= n[max];
                n[max] ^= n[index];
                break;
            }
            index++;
        }
        if (flag) {
            String str = "";
            for (int i = 0; i< len; i++) {
                str += n[i];
            }
            return Integer.parseInt(str);
        }

        return num;
    }
}
