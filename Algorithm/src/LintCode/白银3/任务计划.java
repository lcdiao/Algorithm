package LintCode.白银3;

import java.util.*;

/**
 给定一个字符串，表示CPU需要执行的任务。 这个字符串由大写字母A到Z构成，不同的字母代表不同的任务。完成任务不需要按照给定的顺序。 每项任务都可以在一个单位时间内被完成。 在每个单位时间，CPU可以选择完成一个任务或是不工作。

 但是，题目会给定一个非负的冷却时间“n”，表示在执行两个“相同的任务”之间，必须至少有n个单位时间，此时CPU不能执行该任务，只能执行其他任务或者不工作。

 您需要返回CPU完成所有给定任务所需的最少单位时间数。

 样例
 样例1

 输入: tasks = ['A','A','A','B','B','B'], n = 2
 输出: 8
 解释:
 A -> B -> idle -> A -> B -> idle -> A -> B.
 样例2

 输入: tasks = ['A','A','A','B','B','B'], n = 1
 输出: 6
 解释:
 A -> B -> A -> B -> A -> B.
 注意事项
 任务数量的范围为 [1, 10000].
 整数 n 的范围为 [0, 100].
 */
public class 任务计划 {

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','B','B','C','C','C'};
        System.out.println(leastInterval2(tasks,2));
    }

        /*
    规律:
从举例子中我们可以得出任务调度的规律。
如给定：AAABBCD，n=2。那么我们满足个数最多的任务所需的数量，即可以满足任务间隔要求，即：AXXAXXA；（其中，X表示需要填充任务或者idle的间隔）
如果有两种或两种以上的任务具有相同的最多的任务数，如：AAAABBBBCCDE，n=3。那么我们将具有相同个数的任务A和B视为一个任务对，最终满足要求的分配为：ABXXABXXABXXAB，剩余的任务在不违背要求间隔的情况下穿插进间隔位置即可，空缺位置补idle。
由上面的分析我们可以得到最终需要最少的任务时间：（最多任务数-1）*（n + 1） + （相同最多任务的任务个数）。
有上面的例子来说就是：(num(A)-1) * (3+1) + (2)。
     */

    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n: the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public static int leastInterval(char[] tasks, int n) {
        //TODO 有很大的bug。。。。。
        if (tasks == null || tasks.length == 0 || n == 0) {
            return 0;
        }
        int len = tasks.length;
        List<Character> list = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        list.add(tasks[0]);
        for (int i = 1;i < len ; i++) {
            list2.add(tasks[i]);
        }
        while (list2.size() != 0) {
            boolean flag = true;
            for (int i = 0;i < list2.size(); i++ ) {
                flag = true;
                for (int j = 0; j < n && j < list.size(); j++) {
                    if (list2.get(i).equals(list.get(list.size() - 1 - j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list.add(list2.get(i));
                    list2.remove(i);
                    i--;
                    break;
                }
            }
            if (!flag) {
                list.add('0');
            }
        }
        System.out.println(list.toString());
        return list.size();
    }

    /**
     * 大佬的答案
     * dalao思路：找到第一个次多次数的字母，（n+1）代表interval和边界上的数，25-i代表如果在几个interval中没有安排外多出现在尾巴的数（感觉不太算是贪心策略，而更多像观察数学规律）
     */
    public static int leastInterval2(char[] tasks, int n) {
        // write your code here
        int[] c = new int[26];
        for (char t : tasks) {
            //System.out.print(t + " ");
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) {
            i--;
        }
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

}
