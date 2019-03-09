package 练习;

import java.util.Scanner;

/**
 编写函数CompactIntegers，删除数组中所有值为0的元素，其后元素向数组首端移动。
 注意，CompactIntegers函数需要接收数组及其元素个数作为参数，函数返回值应为删除操作执行后数组的新元素个数。
　　输入时首先读入数组长度，再依次读入每个元素。
　　将调用此函数后得到的数组和函数返回值输出。
样例输入
7
2 0 4 3 0 0 5
样例输出
2 4 3 5
4
测试输入
12
0 4 6 8 0 0 2 7 0 6 0 1
测试输出
4 6 8 2 7 6 1
7

 */
public class 删数组中的0元素 {
	public static int CompactIntegers(int[] a,int len){
		int count=0;
		for(int i=0;i<len;i++)
		{
			if(a[i]!=0)
			{
				count++;
				System.out.print(a[i]+" ");
			}
		}
		System.out.println();
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len=sc.nextInt();
		int[] a=new int[len];
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		int n=CompactIntegers(a,len);
		System.out.println(n);
	}
}
