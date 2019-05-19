package LintCode.白银4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 给一棵二叉树，设计一个算法为每一层的节点建立一个链表。也就是说，如果一棵二叉树有 D 层，那么你需要创建 D 条链表。

 样例
 样例 1:

 输入: {1,2,3,4}
 输出: [1->null,2->3->null,4->null]
 解释:
 1
 / \
 2   3
 /
 4
 样例 2:

 输入: {1,#,2,3}
 输出: [1->null,2->null,3->null]
 解释:
 1
 \
 2
 /
 3
 */
public class 将二叉树按照层级转化为链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        root.left = left;
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(binaryTreeToLists(root));
    }

    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public static List<ListNode> binaryTreeToLists(TreeNode root) {
        if (root == null ) {
            return new LinkedList<ListNode>();
        }
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        List<ListNode> listNodes = new LinkedList<>();
        f(list,listNodes);
        return listNodes;
    }

    public static void f(List<TreeNode> nodes,List<ListNode> listNodes) {
        if (nodes==null || nodes.size()==0){
            return;
        }
        ListNode listNode = new ListNode(nodes.get(0).val);
        ListNode root = listNode;
        for (int i = 1; i < nodes.size(); i++) {
            ListNode ln = new ListNode(nodes.get(i).val);
            listNode.next = ln;
            listNode = ln;
        }
        List<TreeNode> list = new LinkedList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
        listNodes.add(root);
        f(list,listNodes);
    }


    public static class TreeNode {
          public int val;
          public TreeNode left, right;
          public TreeNode(int val) {
              this.val = val;
              this.left = this.right = null;
          }

        public TreeNode() {
        }
    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }

          @Override
          public String toString() {
              return val +
                      "->" + next;
          }
      }
}
