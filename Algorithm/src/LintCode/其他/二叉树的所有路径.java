package LintCode.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 *
 * 样例
 * 例1：
 *
 * 输入：
 *
 *    1
 *   / \
 * 2   3
 *  \
 *   5
 *
 * 输出：
 *
 *
 * [
 *   "1->2->5",
 *   "1->3"
 * ]
 * 例2：
 *
 * 输入：
 *
 *    1
 *  /
 * 2
 *
 *
 * 输出：
 *
 * [
 *   "1->2"
 * ]
 */
public class 二叉树的所有路径 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        root.left = left;
        right.left = left;
        System.out.println(binaryTreePaths(root));
    }

    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root==null) return result;
        String str = Integer.toString(root.val);
        findPaths(root,str,result);
        return result;
    }

    public static void findPaths(TreeNode root, String str,List<String> result){
        if(root.right==null&&root.left==null){
            result.add(str);
            return;
        }
        String left= new String();
        String right = new String();
        if(root.left!=null)
        {
            left = str+"->"+Integer.toString(root.left.val);
            findPaths(root.left,left, result);
        }

        if(root.right!=null)
        {
            right = str+"->"+Integer.toString(root.right.val);
            findPaths(root.right,right,result);
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
