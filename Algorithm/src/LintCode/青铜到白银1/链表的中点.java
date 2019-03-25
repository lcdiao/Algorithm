package LintCode.青铜到白银1;

/**
 * 找链表的中点。
 *
 * 样例
 * 样例 1:
 *
 * 输入:  1->2->3
 * 输出: 2
 * 样例解释: 返回中间节点的值
 * 样例 2:
 *
 * 输入:  1->2
 * 输出: 1
 * 样例解释: 如果长度是偶数，则返回中间偏左的节点的值。
 * 挑战
 * 如果链表是一个数据流，你可以不重新遍历链表的情况下得到中点么？
 */
public class 链表的中点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        System.out.println(middleNode(listNode));
    }

    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public static ListNode middleNode(ListNode head) {
        if (null == head){
            return null;
        }
        ListNode f = head;
        int count = 0;
        while ( null != head.next){
            head = head.next;
            count++;
        }
        int n = 0;
        while ( n != count/2) {
            f = f.next;
            n++;
        }
        return f;
    }
    static public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
