package LintCode.其他;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by diao on 2019/3/20
 * 给出一个链表，并将链表的值以倒序存储到数组中。
 *
 * 样例
 * 样例1
 *
 * 输入: 1 -> 2 -> 3 -> null
 * 输出: [3,2,1]
 * 样例2
 *
 * 输入: 4 -> 2 -> 1 -> null
 * 输出: [1,2,4]
 * 注意事项
 * 您不能改变原始链表的结构。
 * ListNode 有两个成员变量：ListNode.val 和 ListNode.next
 */
public class 相反的顺序存储 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(reverseStore(node1));
    }
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public static List<Integer> reverseStore(ListNode head) {
        if (null == head ){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while (head.next != null) {
            stack.add(head.val);
            head = head.next;
        }
        stack.add(head.val);
        List<Integer> list = new LinkedList<>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            list.add(stack.pop());
        }
        return list;
    }
  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
