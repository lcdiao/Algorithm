package 蓝桥杯.入门训练;



/**
 * 问题描述
输入A、B，输出A+B。
输入格式
输入的第一行包括两个整数，由空格分隔，分别表示A、B。
输出格式
输出一行，包括一个整数，表示A+B的值
 * @author YY
 *
 */
import java.util.Scanner;
public class A加B问题 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println(a+b);
	}
}


//答案
//import java.util.*;
//
//public class Main
//{
//    public static void main(String args[])
//    {
//        Scanner sc = new Scanner(System.in);
//        Integer a = sc.nextInt();
//        Integer b = sc.nextInt();
//        System.out.println(a + b);
//    }
//}
