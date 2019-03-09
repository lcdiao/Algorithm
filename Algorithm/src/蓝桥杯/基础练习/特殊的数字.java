package 基础练习;
/**
 问题描述
　　153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。
	编程求所有满足这种条件的三位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class 特殊的数字 {

	public static void main(String[] args) {
		int n1=0,n2=0,n3=0;
		for(int i=100;i<1000;i++)
		{
			n1=i%10;
			n2=i/10%10;
			n3=i/100;
			if(n1*n1*n1+n2*n2*n2+n3*n3*n3==i)
			{
				System.out.println(i);
			}
		}
	}
}
