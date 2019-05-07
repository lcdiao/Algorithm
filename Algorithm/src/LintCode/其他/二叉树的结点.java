package LintCode.其他;

import java.util.Stack;

/**
 * 给出一棵二叉树，返回其节点数。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 * {1,#,2,3}
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出：
 * 3
 * 样例 2：
 *
 * 输入：
 * {1,2,3}
 *    1
 *   / \
 *  2   3
 * 输出：
 * 3
 */
public class 二叉树的结点 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        root.right = right;
        root.left = left;
        root.right.left = new TreeNode(4);

        System.out.println(getAns(root));
    }

    /**
     * @param root: the root of the binary tree
     * @return: the number of nodes
     */
    public static int getAns(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            count++;
            if (null != n.right) {
                stack.push(n.right);
            }
            if (null != n.left) {
                stack.push(n.left);
            }
        }
        return count;

//        int[] count = {1};
//        f(root,count);
//        return count[0];
    }

    public static void f(TreeNode root,int[] count){
        if (null == root.left && null == root.right) {
            return ;
        }
        if (root.left != null) {
            count[0] = count[0] + 1;
            f(root.left,count);
        }
        if (root.right != null) {
            count[0] = count[0] + 1;
            f(root.right,count);
        }
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
