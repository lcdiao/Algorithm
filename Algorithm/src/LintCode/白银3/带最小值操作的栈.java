package LintCode.白银3;

import java.util.Iterator;
import java.util.Stack;

/**
 实现一个栈, 支持以下操作:

 push(val) 将 val 压入栈
 pop() 将栈顶元素弹出, 并返回这个弹出的元素
 min() 返回栈中元素的最小值
 要求 O(1) 开销.

 样例
 样例 2:

 输入:
 push(1)
 min()
 push(2)
 min()
 push(3)
 min()
 输出:
 1
 1
 1
 注意事项
 保证栈中没有数字时不会调用 min()
 */
public class 带最小值操作的栈 {

    public static void main(String[] args) {
        带最小值操作的栈 dd = new 带最小值操作的栈();
        dd.push(3);
        dd.push(2);
        dd.push(1);
        System.out.println(dd.min());
        System.out.println(dd.pop());
        System.out.println(dd.min());
        System.out.println(dd.pop());
        System.out.println(dd.min());


    }

    static Stack<Integer> stack = new Stack();
    int min = 999999999;
    public 带最小值操作的栈() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (number < min) {
            min = number;
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        int result = stack.pop();
        if (stack.empty()) {
            min = 999999999;
        }else if (result == min ) {
            min = stack.peek();
            Iterator<Integer> i = stack.iterator();
            while (i.hasNext()) {
                int n = i.next();
                if (n < min) {
                    min = n;
                }
            }
        }
        return result;
    }

    /*
     * @return: An integer
     */
    public int min() {
        return min;
    }

}
