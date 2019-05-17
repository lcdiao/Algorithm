package LintCode.白银4;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）

 样例
 样例 1:

 输入：{1,2,3}
 输出：[[1],[2,3]]
 解释：
 1
 / \
 2   3
 它将被序列化为{1,2,3}
 层次遍历
 样例 2:

 输入：{1,#,2,3}
 输出：[[1],[2],[3]]
 解释：
 1
 \
 2
 /
 3
 它将被序列化为{1,#,2,3}
 层次遍历
 挑战
 挑战1：只使用一个队列去实现它

 挑战2：用BFS算法来做

 注意事项
 首个数据为根节点，后面接着是其左儿子和右儿子节点值，"#"表示不存在该子节点。
 节点数量不超过20。
 */
public class 二叉树的层次遍历 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        root.right = right;
        root.left = left;
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        levelOrder(root);
    }


    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        f(nodes,result);
        System.out.println(Arrays.toString(result.toArray()));



        return result;
    }

    public static void f(List<TreeNode> nodes,List<List<Integer>> lli) {
        if (nodes==null || nodes.size()==0){
            return;
        }
        List<TreeNode> list = new LinkedList<>();
        List<Integer> li = new LinkedList<>();
        for (TreeNode treeNode : nodes) {
            if (treeNode.left!=null) {
                list.add(treeNode.left);
            }
            if (treeNode.right!=null) {
                list.add(treeNode.right);
            }
            li.add(treeNode.val);
        }
        lli.add(li);
        f(list,lli);
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






















