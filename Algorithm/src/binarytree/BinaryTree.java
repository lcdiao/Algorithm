package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	private TreeNode root = null;	//根节点
	
	public BinaryTree() {
		root = new TreeNode(1,"A");
	}
	
	/**
	 * 构建二叉树
	 *			A
	 *		B		C
	 *	D	  E			F
	 *前序：根左右	-->	ABDECF
	 *中序：左根右	-->	DBEACF
	 *后序：左右根	-->	DEBFCA
	 */
	public void createBinaryTree() {
		TreeNode nodeB = new TreeNode(2,"B");
		TreeNode nodeC = new TreeNode(3,"C");
		TreeNode nodeD = new TreeNode(4,"D");
		TreeNode nodeE = new TreeNode(5,"E");
		TreeNode nodeF = new TreeNode(6,"F");
		root.leftChild=nodeB;
		root.rightChild=nodeC;
		nodeB.leftChild=nodeD;
		nodeB.rightChild=nodeE;
		nodeC.rightChild=nodeF;
		
	}
	
	
	/**求二叉树的高度*/
	public int getHeight() {
		return getHeight(root);
	}
	public int getHeight(TreeNode node) {
		if(node == null) {
			return 0;
		}else {
			int i = getHeight(node.leftChild);
			int j = getHeight(node.rightChild);
			return i<j?j+1:i+1;
		}
	}
	
	/**获取二叉树的节点数*/
	public int getSize() {
		return getSize(root);
	}
	public int getSize(TreeNode node) {
		if(node==null) {
			return 0;
		}else {
			return 1+getSize(node.leftChild)+getSize(node.rightChild);
		}
	}
	
	
	/**
	 * 通过前序遍历的数据序列反向生成二叉树
	 *			A
	 *		B		  C
	 *	 D	  E	    #	F
	 * # #   #  #      #  #  
	 *
	 *
	 *
	 *A B D # # E # # C # F # #
	 * */
	public void createBinaryTreePre(ArrayList<String> data) {
		createBinaryTree(data.size(),data);
	}
	private TreeNode createBinaryTree(int size, ArrayList<String> data) {
		if(data.size()==0) return null;
		String d = data.get(0);
		TreeNode node;
		int index = size - data.size();
		if(d.equals("#")) {
			node = null;
			data.remove(0);
			return node;
		}
		node = new TreeNode(index,d);
		if(index == 0) {
			//创建根节点
			root = node;
		}
		data.remove(0);
		node.leftChild = createBinaryTree(size, data);
		node.rightChild = createBinaryTree(size, data);
		return node;
	}
	

	/**前序遍历--非迭代*/
	public void nonRecPreOrder() {
		nonRecPreOrder(root);
	}
	public void nonRecPreOrder(TreeNode node) {
		if(null==node)	return ;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while(!stack.isEmpty()) {
			//出栈和进栈
			TreeNode n = stack.pop();//弹出根节点
			System.out.print(n.getData());
			//压入子节点
			if(null!=n.rightChild)
				stack.push(n.rightChild);
			if(null!=n.leftChild)
				stack.push(n.leftChild);
		}
	}
	
	/**中序遍历--非迭代*/
	public void nonRecMidOrder() {
		nonRecMidOrder(root);
	}
	public void nonRecMidOrder(TreeNode node) {
		if(null==node)return ;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode n = node;
		while(!stack.isEmpty()||n!=null) {
			while(n!=null) {
				stack.push(n);
				n=n.leftChild;//存在左子数
			}
			if(!stack.isEmpty()) {
				n=stack.pop();
				System.out.print(n.getData());
				n=n.rightChild;
			}
		}
	}
	
	/**后序遍历--非迭代*/
	public void nonRecPostOrder() {
		nonRecPostOrder(root);
	}
	public void nonRecPostOrder(TreeNode node) {
		if(null==node) return ;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode n = node;
		while(node!=null) {
			while(node.leftChild!=null) {//左子树入栈
				stack.push(node);
				node = node.leftChild;
			}
			//当前结点无右子树或右子树已经输出  
			while(node!=null&&(node.rightChild==null||node.rightChild==n)) {
				System.out.print(node.getData());
				n=node;//纪录上一个已输出结点
				if(stack.empty())return ;
				node=stack.pop();
			}
			//处理右子树
			stack.push(node);
			node = node.rightChild;
		}
		while(!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.getData());
		}
		
	}
	public void nonRecPostOrder2(TreeNode node) {
		if(null==node) return ;
		Stack<TreeNode> stack = new Stack<TreeNode>();
	    Stack<TreeNode> output = new Stack<TreeNode>();//待操作栈
	    while(node!=null||!stack.isEmpty()) {
	    	if(node!=null) {
	    		stack.push(node);
	    		output.push(node); 
	    		node=node.rightChild;//先进入右子树
	    	}else {
	    		node = stack.pop();
	    		node = node.leftChild;
	    	}
	    }
	    
	    while(!output.isEmpty()) {
	    	System.out.print(output.pop().getData());
	    }
	}
	
	
	/**前序遍历*/
	public void preOrder() {
		preOrder(root);
	}
	public void preOrder(TreeNode node) {
		if(node==null) {
			return ;
		}else {
			System.out.print(node.getData());
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	
	/**中序遍历*/
	public void midOrder() {
		midOrder(root);
	}
	public void midOrder(TreeNode node) {
		if(node==null) {
			return ;
		}else {
			midOrder(node.leftChild);
			System.out.print(node.getData());
			midOrder(node.rightChild);
		}
	}
	
	/**后序遍历*/
	public void postOrder() {
		postOrder(root);
	}
	public void postOrder(TreeNode node) {
		if(node==null) {
			return ;
		}else {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			System.out.print(node.getData());
		}
	}
	
	public class TreeNode{	//树节点
		private int index;
		private String data;//TODO 可使用泛型
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;
		
		public TreeNode getParent() {
			return parent;
		}
		public void setParent(TreeNode parent) {
			this.parent = parent;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public TreeNode(int index,String data) {
			this.index=index;
			this.data=data;
			this.leftChild=null;
			this.rightChild=null;
		}
	}
	
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
//		binaryTree.createBinaryTree();
//		System.out.println("二叉树高度："+binaryTree.getHeight());
//		System.out.println("二叉树节点数："+binaryTree.getSize());
//		System.out.print("前序遍历:");
//		binaryTree.preOrder();
//		System.out.println();
//		System.out.print("中序遍历:");
//		binaryTree.midOrder();
//		System.out.println();
//		System.out.print("后序遍历:");
//		binaryTree.postOrder();
//		System.out.println();
//		System.out.print("前序遍历--非迭代:");
//		binaryTree.nonRecPreOrder();
//		System.out.println();
//		System.out.print("中序遍历--非迭代:");
//		binaryTree.nonRecMidOrder();
//		System.out.println();
//		System.out.print("后序遍历--非迭代:");
//		binaryTree.nonRecPostOrder();
//		System.out.println();
//		System.out.print("后序遍历--非迭代2:");
//		binaryTree.nonRecPostOrder2(binaryTree.root);
		
		String[] dataArray = new String[] {"A","B","D","#","#","E","#","#","C","#","F","#","#"};
		ArrayList<String> data = new ArrayList<String>();
		for(String d:dataArray) {
			data.add(d);
		}
		binaryTree.createBinaryTreePre(data);
		System.out.print("前序遍历:");
		binaryTree.preOrder(binaryTree.root);
	}
	
}
