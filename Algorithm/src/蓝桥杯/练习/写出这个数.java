package 练习;

import java.util.Scanner;

/**
 * 
 读入一个自然数n，计算其各位数字之和，用汉语拼音写出和的每一位数字。 
输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。这里保证n小于10的100次方。
输出格式：在一行内输出n的各位数字之和的每一位，拼音数字间有1 空格，但一行中最后一个拼音数字后没有空格。 
输入样例：
1234567890987654321123456789
输出样例：
yi san wu
 *
 */
public class 写出这个数 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n=sc.nextLine();
		int sum=0;
		for(int i=0;i<n.length();i++)
		{
			sum+=Integer.parseInt(n.charAt(i)+"");
		}
		String s=sum+"";
		for(int i=0;i<s.length();i++)
		{
			if((s.charAt(i)+"").equals(0+""))
				System.out.print("ling");
			else if((s.charAt(i)+"").equals(1+""))
				System.out.print("yi");
			else if((s.charAt(i)+"").equals(2+""))
				System.out.print("er");
			else if((s.charAt(i)+"").equals(3+""))
				System.out.print("san");
			else if((s.charAt(i)+"").equals(4+""))
				System.out.print("si");
			else if((s.charAt(i)+"").equals(5+""))
				System.out.print("wu");
			else if((s.charAt(i)+"").equals(6+""))
				System.out.print("liu");
			else if((s.charAt(i)+"").equals(7+""))
				System.out.print("qi");
			else if((s.charAt(i)+"").equals(8+""))
				System.out.print("ba");
			else if((s.charAt(i)+"").equals(9+""))
				System.out.print("jiu");
			if(i!=s.length()-1)
				System.out.print(" ");
		}
	}

}
