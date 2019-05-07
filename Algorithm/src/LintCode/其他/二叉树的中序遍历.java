package LintCode.其他;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给出一棵二叉树,返回其中序遍历
 *
 * 样例
 * 给出二叉树 {1,#,2,3},
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * 返回 [1,3,2].
 *
 * 挑战
 * 你能使用非递归算法来实现么?
 */
public class 二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;
        System.out.println(inorderTraversal(root));
    }


    /**
     * 非递归算法
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null ) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while(!stack.isEmpty() || n!=null) {
            while (n != null) {
                stack.push(n);
                n = n.left;
            }
            if (!stack.isEmpty()) {
                n = stack.pop();
                list.add(n.val);
                n = n.right;
            }
        }
        return list;
    }

    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null ) {
            return list;
        }
        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
