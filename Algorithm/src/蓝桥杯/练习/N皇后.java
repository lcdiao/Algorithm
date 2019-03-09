package 练习;

import java.util.Scanner;

/**
N皇后问题是一个以国际象棋为背景的问题：
如何能够在 N×N 的国际象棋棋盘上放置N个皇后，使得任何一个皇后都无法直接吃掉其他的皇后？
为了达到此目的，任两个皇后都不能处于同一条横行、纵行或斜线上。 
 */
public class N皇后 {
	static Scanner sc = new Scanner(System.in);
	static int count=0;
	static int N=8;
	static int[][] board = new int[N][N];
	static void print(){
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static boolean judge(int x,int y)
	{
		int s,t;
		for(s=x,t=0;t<N;t++)//判断列
			if(board[s][t]==1)	return false;
		for(s=0,t=y;s<N;s++)//判断行
			if(board[s][t]==1)	return false;
		for(s=x-1,t=y-1;t>=0&&s>=0;t--,s--)//判断左上
			if(board[s][t]==1)	return false;
		for(s=x+1,t=y+1;t<N&&s<N;t++,s++)//判断右下
			if(board[s][t]==1)	return false;
		for(s=x-1,t=y+1;t<N&&s>=0;t++,s--)//判断右上
			if(board[s][t]==1)	return false;
		for(s=x+1,t=y-1;t>=0&&s<N;t--,s++)//判断左下
			if(board[s][t]==1)	return false;
		return true;
	}
	static void queen(int i)
	{
		if(i==N)
		{
			print();
			count++;
			return ;
		}
		for(int j=0;j<N;j++)
		{
			if(judge(i,j))
			{
				board[i][j]=1;
				queen(i+1);
				board[i][j]=0;
			}
		}
	}
	public static void main(String[] args) {
		N=sc.nextInt();
		queen(0);
		System.out.println(count);
	}

}
