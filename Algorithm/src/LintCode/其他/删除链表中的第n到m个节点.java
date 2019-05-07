package LintCode.其他;

/**
 * 给定一个链表，删除链表中的第 n 到 m 个节点，返回链表的头节点。
 *
 * 样例
 * 样例 1：
 *
 * 输入：head = 1->2->3->4->5->null, n = 1, m = 2
 * 输出：1->4->5->null
 * 样例 2：
 *
 * 输入：head = 1->2->3->4->5->null, n = 1, m = 4
 * 输出：1->null
 * 注意事项
 * 编号从 00 开始
 *
 * 链表的长度不超过 100000100000
 */
public class 删除链表中的第n到m个节点 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(5);
        listNode = deleteNode(listNode,1,3);
        System.out.println("========================================");
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
        System.out.println("========================================");
    }

    /**
     * @param head: The first node of linked list
     * @param n: the start index
     * @param m: the end node
     * @return: A ListNode
     */
    public static ListNode deleteNode(ListNode head, int n, int m) {
        int count = 0;
        if (head == null){
            return null;
        }
        ListNode root = head;
        ListNode ln = null;
        ListNode lm = null;
        if (n == 0) {
            while (head.next != null) {
                if (count == m) {
                    lm = head.next;
                }
                count++;
                head = head.next;
            }
            return lm;
        }
        while (head.next != null) {
            if (count+1 == n){
                ln = head;
            }
            else if (count == m) {
                lm = head.next;
            }
            count++;
            head = head.next;
        }
        ln.next = lm;
        return root;
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
