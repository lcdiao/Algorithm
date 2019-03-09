package 练习;

import java.util.Scanner;

/**
问题描述
　　在一条直线上有n堆石子，每堆有一定的数量，每次可以将两堆相邻的石子合并，合并后放在两堆的中间位置，
	合并的费用为两堆石子的总数。求把所有石子合并成一堆的最小花费。
输入格式
　　输入第一行包含一个整数n，表示石子的堆数。
　　接下来一行，包含n个整数，按顺序给出每堆石子的大小 。
输出格式
　　输出一个整数，表示合并的最小花费。
样例输入
5
1 2 3 4 5
样例输出
33					(1 2 3 4 5-->1+2-->3 3 4 5 -->3+3-->6 4 5-->4+5-->6 9-->6+9)
						3+6+9+15=33
数据规模和约定
　　1<=n<=1000, 每堆石子至少1颗，最多10000颗。
*/
public class 合并石子 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();
		int sum=0;
		while(a.length!=1)
		{
			int[] b = new int[a.length-1];
			int min=999999;
			int j=0;
			for(int i=0;i<a.length-1;i++)
			{
				if(a[i]+a[i+1]<min)
				{
					min=a[i]+a[i+1];
					j=i;
				}
			}
			for(int k=0;k<b.length;k++)
			{
				if(k==j)
				{
					sum+=min;
					b[k]=a[k]+a[k+1];
				}
				else if(k>j)
				{
					b[k]=a[k+1];
				}
				else
				{
					b[k]=a[k];
				}
			}
			a=b;
		}
		System.out.println(sum);
	}

}
