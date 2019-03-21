package LintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 *
 * 样例
 * Given:
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return [1,2,4,5,3].
 *
 * 挑战
 * 你能使用非递归实现么？
 *
 * 注意事项
 * 首个数据为根节点，后面接着是其左儿子和右儿子节点值，"#"表示不存在该子节点。
 */
public class 二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        root.right = right;
        root.left = left;
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(preorderTraversal(root));
    }

    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //f(root,list);
        f2(root,list);
        return list;
    }

    public static void f2(TreeNode root,List<Integer> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            list.add(n.val);
            if (null != n.right) {
                stack.push(n.right);
            }
            if (null != n.left) {
                stack.push(n.left);
            }
        }
    }

    public static void f(TreeNode root,List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            f(root.left,list);
        }
        if (root.right != null) {
            f(root.right,list);
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
