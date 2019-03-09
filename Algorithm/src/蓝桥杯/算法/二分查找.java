package 算法;

import java.util.Arrays;

public class 二分查找 {
	static int count = 0;
	public static int f(int[] a,int left,int right,int num )
	{
		count++;
		int i=(right-left)/2+left;
		if(a[i]==num)
		{
			System.out.println(num+"在第"+i+"位,运行了"+count+"次");
			return i;
		}
		if(left>=right)
			return -1;
		else if(num<a[i])
			return f(a,left,i-1,num);
		else if(num>a[i])
			return f(a,i+1,right,num);
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a ={6,5,4,3,2,9,8,7,1,0,23,45,66,-8,-2};
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"\t");
		System.out.println();
		
		f(a,0,a.length,66);
		
/*		int left=0;
		int right=a.length;
		int middle;
		int num=66;
		while(left<=right)
		{
			count++;
			middle=(left+right)/2;
			if(a[middle]==num)
			{
				System.out.println("第"+middle+"位,运行了"+count+"次");
				return;
			}
			else if(a[middle]<num)
			{
				System.out.println("运行第"+count+"次,找到"+a[middle]);
				left=middle+1;
			}
			else
			{
				System.out.println("运行第"+count+"次,找到"+a[middle]);
				right=middle-1;
			}
			
		}*/
	}
}
