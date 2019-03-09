package 入门训练;



/**
 * 问题描述
求1+2+3+...+n的值。
输入格式
输入包括一个整数n。
输出格式
输出一行，包括一个整数，表示1+2+3+...+n的值。
样例输入
4
样例输出
10
 * @author YY
 *
 */
import java.util.Scanner;
public class 序列求和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sum=0;
		long n=sc.nextInt();
		/*for(int i=1;i<=n;i++)
			sum+=i;*/
		sum=(1+n)*n/2;
		System.out.println(sum);
	}
}
