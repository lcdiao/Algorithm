package LintCode.白银3;

import java.util.Stack;

/**
 正如标题所述，你需要使用两个栈来实现队列的一些操作。

 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。

 pop和top方法都应该返回第一个元素的值。

 样例
 Example 1:

 Input:
 push(1)
 pop()
 push(2)
 push(3)
 top()
 pop()
 Output:
 1
 2
 2

 Example 2:

 Input:
 push(1)
 push(2)
 push(2)
 push(3)
 push(4)
 push(5)
 push(6)
 push(7)
 push(1)
 Output:
 []

 挑战
 仅使用两个栈来实现它，不使用任何其他数据结构，push，pop 和 top的复杂度都应该是均摊O(1)的
 */
public class 用栈实现队列 {
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();
    public 用栈实现队列() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }

    /*
     * @return: An integer
     */
    public int top() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.peek();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }
}
