package LintCode.白银3;

import java.util.Stack;

/**
 请设计一种方法将一个栈进行升序排列 （最大的数在最上面）。

 你可以使用另外一个栈来辅助操作，但不可将这些数复制到另外一个数据结构中 （如，数组）。

 样例
 给一个栈：

 | |
 |3|
 |1|
 |2|
 |4|
 -
 排序之后：

 | |
 |4|
 |3|
 |2|
 |1|
 -
 栈会被序列化为[4,2,1,3]，也就是说最右边是栈顶。

 注意事项
 时间复杂度为O(n^2)的算法也可以通过测试
 */
public class 栈排序 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stackSorting(stack);
    }
    /*
     * @param stk: an integer stack
     * @return: void
     */
    public static void stackSorting(Stack<Integer> stk) {
        // 一行代码就通过了。。。 但栈的排序底层有用到数组。。。
        //stk.sort((a,b) -> a.compareTo(b));
        /*
        解题思路：
要排序的栈为stk, 申请辅助的栈为help。在stk上执行pop()操作，弹出的元素记为cur。
1、如果cur小于或等于help的栈顶元素，则将cur直接压入help
2、如果cur大于help的栈顶元素，则将help的元素逐一弹出，压入stk，直到cur小于或等于help的栈顶元素，再将cur压入help
一直重复上面操作，直到stk的元素全部压入help中。最后将help中的元素全部压入stk中，即完成排序。
         */
        Stack<Integer> help = new Stack<>();
        help.push(stk.pop());
        while (!stk.empty()) {
            int cur = stk.pop();
            if (cur <= help.peek()) {
                help.push(cur);
            } else {
                while (!help.empty()) {
                    stk.push(help.pop());
                    if (cur <= help.peek()) {
                        help.push(cur);
                        break;
                    }
                }
            }
        }
        while (!help.empty()) {
            stk.push(help.pop());
        }
        System.out.println(stk);
    }
}
