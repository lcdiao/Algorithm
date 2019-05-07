package LintCode.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 *
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 *
 * 样例
 * 样例1:
 *
 * 输入:
 * {1,2,4,2,3}
 * 5
 * 输出: [[1, 2, 2],[1, 4]]
 * 说明:
 * 这棵树如下图所示：
 * 	     1
 * 	    / \
 * 	   2   4
 * 	  / \
 * 	 2   3
 * 对于目标总和为5，很显然1 + 2 + 2 = 1 + 4 = 5
 * Example 2:
 *
 * 输入:
 * {1,2,4,2,3}
 * 3
 * 输出: []
 * 说明:
 * 这棵树如下图所示：
 * 	     1
 * 	    / \
 * 	   2   4
 * 	  / \
 * 	 2   3
 * 注意到题目要求我们寻找从根节点到叶子节点的路径。
 * 1 + 2 + 2 = 5, 1 + 2 + 3 = 6, 1 + 4 = 5
 * 这里没有合法的路径满足和等于3.
 */
public class 二叉树的路径和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        root.right = right;
        root.left = left;
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        int target = 5;


//        List<List<Integer>> lists = new ArrayList<>();
//
//        f(root,target,root.val+"",lists);
//        System.out.println(lists);
        System.out.println(root);
        System.out.println(binaryTreePathSum(root,target));
    }

    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        //f(root,target,root.val+"",lists);

        List<Integer> list = new ArrayList<>();
        f2(root,target,list,lists);
        return lists;
    }

    public static int getSum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static int getSum(String s) {
        int sum = 0;
        String[] as = s.split(",");
        int len = as.length;
        for (int i = 0; i < len; i++) {
            sum += Integer.parseInt( as[i]);
        }
        return sum;
    }
    public static List<Integer> getList(String s) {
        List<Integer> list = new ArrayList<>();
        String[] as = s.split(",");
        int len = as.length;
        for (int i = 0; i < len; i++) {
            list.add(Integer.parseInt(as[i]));
        }
        return list;
    }

    public static void f2(TreeNode root,int target,List<Integer> list,List<List<Integer>> lists){
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (getSum(list) == target) {
                lists.add(list);
            }
            return;
        }
        List<Integer> llist = new ArrayList<>();
        List<Integer> rlist = new ArrayList<>();
        if (root.left != null){
            llist.addAll(list);
            f2(root.left,target,llist,lists);
        }
        if (root.right != null) {
            rlist.addAll(list);
            f2(root.right,target,rlist,lists);
        }
    }

    public static void f(TreeNode root,int target,String str,List<List<Integer>> lists){
        if (root.left == null && root.right == null) {
            List<Integer> list = getList(str);
            if (getSum(list) == target) {
                lists.add(list);
            }
            return;
        }
        List<Integer> llist = new ArrayList<>();
        List<Integer> rlist = new ArrayList<>();
        String left = new String();
        String right = new String();
        if (root.left != null){
            left = str + "," + Integer.toString(root.left.val);
            f(root.left,target,left,lists);
        }
        if (root.right != null) {
            right = str + "," + Integer.toString(root.right.val);
            f(root.right,target,right,lists);
        }
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
        public TreeNode(){}
    }
}
