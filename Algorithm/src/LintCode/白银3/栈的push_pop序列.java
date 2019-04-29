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
        int[] push = new int[]{1,2,3,2,4};
        int[] pop = new int[]{2,4,3,2,1};
//        int[] push = new int[]{1,2,3,4,5};
//        int[] pop = new int[]{4,5,3,2,1};
        System.out.println(isLegalSeq(push,pop));
    }

    /**
     * @param push: the array push
     * @param pop: the array pop
     * @return: return whether there are legal sequences
     */
    public static boolean isLegalSeq(int[] push, int[] pop) {
        if (null == push || push.length!=pop.length) {
            return false;
        }
        Stack<Integer> pushStack = new Stack<>();
        int len = push.length;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (push[i] != pop[idx]) {
                pushStack.push(push[i]);
            } else {
                boolean flag = false;
                if (idx+1 < len) {
                    if (i + 1 < len && pop[idx+1] == push[i+1]) {
                        flag = true;
                    } else if (i - 1 >= 0 && pop[idx + 1] == push[i - 1]) {
                        flag = true;
                    } else if (i + 1 == len) {
                        flag = true;
                    }
                }
                if (flag) {
                    idx++;
                    while (!pushStack.empty() && pushStack.peek() == pop[idx]) {
                        idx++;
                        pushStack.pop();
                    }
                } else {
                    pushStack.push(push[i]);
                }
            }
        }
        if (pushStack.empty()) {
            return true;
        }
        return false;
    }

}
