package LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的距离。
 *
 * 样例
 * 样例 1:
 *
 * 输入: tree = {}
 * 输出: 0
 * 样例解释: 空树的深度是0。
 * 样例 2:
 *
 * 输入: tree = {1,2,3,#,#,4,5}
 * 输出: 3
 * 样例解释: 树表示如下，深度是3
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 */
public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        root.right = right;
        root.left = left;
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(maxDepth(root));
    }

    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = {0};
        f(root,1,max);
        return max[0];
    }
    public static void f(TreeNode root,int count,int[] max) {
        if (null == root.left && null == root.right) {
            if (count > max[0]) {
                max[0] = count;
            }
            return ;
        }
        if (null != root.left) {
            int left = count + 1;
            f(root.left,left,max);
        }
        if (null != root.right) {
            int right = count + 1;
            f(root.right,right,max);
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
