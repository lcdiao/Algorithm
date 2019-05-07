package LintCode.白银4;

/**
 你站在一个无穷数轴上的 0 位置。在位置目标上有一个目标。
 在每一个动作中，你可以向左或向右。在第n次移动中(从1开始)，你行走n步。
 返回到达目的地所需的最小步骤数。

 样例
 样例1

 输入: target = 3
 输出: 2
 解释:
 在第一步，我们从0到1。
 在第二步，我们从1到3。
 样例2

 输入: target = 2
 输出: 3
 解释:
 在第一步，我们从0到1。
 在第二个步骤中，我们从1到-1。
 在第三步，从-1到2。
 注意事项
 目标将是一个非零的整数范围[-10^9, 10^9]。
 */
public class 到达一个数字 {
    public static void main(String[] args) {
        System.out.println(reachNumber(5));
    }

    /**
     * @param target: the destination
     * @return: the minimum number of steps
     */
    public static int reachNumber(int target) {
        /*
        分析如下：首先一次相加直到和大于目标，比较差值，如果是偶数，说明只需要将几个数由加号变为减号（里外里2倍，所以一定是偶数），
        若是奇数，就要想办法制造1，减去一个奇数加上下一个偶数即可，所以如果当前n是个奇数，就需要加上下一个偶数，如果当前是个偶数就需要减去下一个奇数，加上下一个偶数。
        target为3 -----> 1+2= 3
        target为4 -----> 1+2+3=6  -(6-4为偶数)-> -1-2+3+4 = 4
        target为5 -----> 1+2+3=6  -6-5为奇数)->  1-2-3+4+5 = 5
         */
        if (target < 0) {
            target = -target;
        }
        int step = 1, pos = 0;
        while (pos < target) {
            System.out.println(pos +"+"+step+"="+(pos+step));
            pos += step;
            step++;
        }
        step--;
        if (pos == target) {
            return step;
        }
        pos -= target;
        if (pos % 2 == 0) {
            return step;
        } else if ((step + 1) % 2 == 1) {
            return step + 1;
        } else {
            return step + 2;
        }


    }

}
