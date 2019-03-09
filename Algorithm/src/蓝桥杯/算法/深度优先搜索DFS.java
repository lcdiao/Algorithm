package 算法;

import java.util.Scanner;
/**全排列*/
public class 深度优先搜索DFS {
	static int n;
	static int[] a = new int[10];
	static int[] book = new int[10];
	static int count=0;
	static void f(int step)
	{
		int i;
		if(step==n+1)
		{
			for(i=1;i<=n;i++)
				System.out.print(a[i]+" ");
			System.out.println();
			count++;
			return ;
		}
		for(i=1;i<=n;i++)
		{
			if(book[i]==0)
			{
				a[step]=i;
				book[i]=1;
				f(step+1);
				book[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		f(1);
		System.out.println();
		System.out.println(count);
	}

}
