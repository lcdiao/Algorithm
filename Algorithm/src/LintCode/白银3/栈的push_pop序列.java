package LintCode.白银3;

import java.util.Stack;

/**
 给定一个栈的 push 和 pop 序列。判定其中是否有合法序列。

 样例
 样例 1：

 输入：push = [1, 2, 3], pop = [3, 2, 1]
 输出：True
 解释：
 1，2，3 依次入栈，3，2，1 再依次出栈。
 样例 2：

 输入：push = [1, 2, 3], pop = [3, 1, 2]
 输出：False
 解释：
 如果想优先 pop 3，那么 1 和 2 必须已经存在于栈中，且 2 在 1 的上面。且这种情况下，1 不能先于 2 被 pop。
 注意事项
 元素数量不超过1000
 */
public class 栈的push_pop序列{

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3};
        int[] pop = new int[]{3,2,1};
        System.out.println(isLegalSeq(push,pop));
    }

    /**
     * @param push: the array push
     * @param pop: the array pop
     * @return: return whether there are legal sequences
     */
    public static boolean isLegalSeq(int[] push, int[] pop) {
        if (null == push) {
            return false;
        }
        if (pop == null) {
            return true;
        }
        Stack<Integer> pushStack = new Stack<>();
        int len = push.length;
        for (int i = 0; i < len; i++) {
            pushStack.push(push[i]);
        }
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (pushStack.pop() != pop[i]) {
                return false;
            }
        }

        return true;
    }
}
