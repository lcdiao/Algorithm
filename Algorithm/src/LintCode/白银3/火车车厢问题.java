package LintCode.白银3;

import java.util.Stack;

/**
 有一条铁轨, 铁轨中间有一个中转站, 你可以想象成一个 "T" 型的结构. 中转站相当于一个栈, 车厢是先进后出的. 有 n 节火车车厢在中转站右边的铁轨上从 1 到 n 排列.

 现在需要借助中转站将这 n 节火车转移到左边的铁轨上, 并且在每个车厢最多进入中转站一次的前提下, 按照数组 arr 中的顺序排列.

 你的任务是判断是否可以达到 arr 要求的顺序, 如果可以, 返回中转站中车厢数量最多时的数量, 如果不可以, 返回 -1 .

 样例
 样例 1:

 输入: arr = [4,5,3,2,1]
 输出: 3
 解释:
 1 进入中转站，
 2 进入中转站，
 3 进入中转站，
 4 直接到左边的铁轨，
 5 直接到左边的铁轨，
 3 从中转站到左边的铁轨，
 2 中转站到左边的铁轨，
 1 中转站到左边的铁轨。
 所以[4,5,3,2,1]合法，且中转站数量最多时为3，返回3。
 样例 2:

 输入: arr = [3,1,2]
 输出: -1
 解释: 想要 3 排在第一个, 我们需要使 1, 2 连续进入中转站. 中转站是先进后出的, 1 没有办法在 2 之前到达左边的车轨.
 注意事项
 n ≤ 10^5
 */
public class 火车车厢问题 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,3,2,1};
        arr = new int[]{3,1,2};
        System.out.println(trainCompartmentProblem(arr));
    }

    //TODO 未提交lintcode
    /**
     * @param arr: the arr
     * @return:  the number of train carriages in this transfer station with the largest number of train carriages
     */
    public static int trainCompartmentProblem(int[] arr) {
        if (null == arr || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = i+1;
        }
        int result = 0;
        //中转站
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < len; i++) {
            //不相等就入栈
            if (a[i] != arr[index]) {
                stack.push(a[i]);
                if (stack.size() > result) {
                    result = stack.size();
                }
            } else {
                //相等就跳过
                index ++ ;
                //栈顶元素是否跟数组的下一个相等
                while (index < len && !stack.empty() && stack.peek() == arr[index] ) {
                    index++;
                    //相等就出栈
                    stack.pop();
                }
            }
        }

        if (stack.empty()) {
            return result;
        }
        return -1;
    }
}
