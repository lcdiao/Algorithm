package 练习;

import java.util.Scanner;

/**
 观察数字：12321，123321 都有一个共同的特征，无论从左到右读还是从右向左读，都是相同的。这样的数字叫做：回文数字。
本题要求你找到一些5位或6位的十进制数字。满足如下要求：
该数字的各个数位之和等于输入的整数。
输入格式
一个正整数 n (10<n<100), 表示要求满足的数位和。
输出格式
若干行，每行包含一个满足要求的5位或6位整数。
　　数字按从小到大的顺序排列。
　　如果没有满足条件的，输出：-1
样例输入
44
样例输出
99899
499994
589985
598895
679976
688886
697796
769967
778877
787787
796697
859958
868868
877778
886688
895598
949949
958859
967769
976679
985589
994499
样例输入
60
样例输出
-1

 */
public class 特殊回文数字 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		if(n<=10||n>=100)
		{
			System.out.println(-1);
			return;
		}
		boolean boo=true;
		for(int i=10000;i<1000000;i++)
		{
			if(i<=99999)
			{
				int n1=i/10000;
				int n2=i%10000/1000;
				int n3=i%1000/100;
				int n4=i%100/10;
				int n5=i%10;
				if(n1+n2+n3+n4+n5==n&&n1==n5&&n2==n4)
				{
					System.out.println(i);
					boo=false;
				}
			}
			else
			{
				int n1=i/100000;
				int n2=i%100000/10000;
				int n3=i%10000/1000;
				int n4=i%1000/100;
				int n5=i%100/10;
				int n6=i%10;
				if(n1+n2+n3+n4+n5+n6==n&&n1==n6&&n2==n5&&n3==n4)
				{
					System.out.println(i);
					boo=false;
				}
			}
			
		}
		if(boo)System.out.println(-1);
	}
}
