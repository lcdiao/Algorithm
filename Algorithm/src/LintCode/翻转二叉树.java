package LintCode;

/**
 * 翻转一棵二叉树
 *
 * 样例
 * Example 1:
 * 	Input: {1,3,#}
 * 	Output: {1,#,3}
 *
 * 	Explanation:
 * 	 1
 * 	 /
 * 	3
 * Example 2:
 * 	Input:  {1,2,3,#,#,4}
 * 	Output: {1,3,2,#,4}
 *
 * 	Explanation:
 *
 *       1         1
 *      / \       / \
 *     2   3  => 3   2
 *        /       \
 *       4         4
 * 挑战
 * 递归固然可行，能否写个非递归的？
 */
public class 翻转二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        root.right = right;
        root.left = left;
        root.right.left = new TreeNode(4);

        invertBinaryTree(root);

    }

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public static void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        if (left != null) {
            invertBinaryTree(left);
        }
        if (null != right) {
            invertBinaryTree(right);
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
