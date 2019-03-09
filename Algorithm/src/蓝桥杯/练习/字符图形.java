package 练习;

import java.util.Scanner;

/**
 利用字母可以组成一些美丽的图形，下面给出了一个例子：
ABCDEFGH
BABCDEFG
CBABCDEF
DCBABCDE
这是一个4行8列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
输入格式
输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
输出格式
输出n行，每个m个字符，为你的图形。
样例输入
4 8
样例输出
ABCDEFGH
BABCDEFG
CBABCDEF
DCBABCDE
数据规模与约定
1 <= n, m <= 26。

 */
public class 字符图形 {
	public static void main(String[] args) {
		char[][] c=new char[26][26];
		String s="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int n=0;
		for(int i=0;i<26;i++)
		{
			n=0;
			for(int j=0;j<26;j++)
			{
				for(int k=0;k<i;k++)
				{
					c[i][k]=(char) (c[i-1][k]+1);
				}
				if(j>=i)
					c[i][j]=s.charAt(n++);
			}
		}
		Scanner sc=new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		for(int i=0;i<n1;i++)
		{
			for(int j=0;j<n2;j++)
			{
				System.out.print(c[i][j]);
			}
			System.out.println();
		}

	}
}
