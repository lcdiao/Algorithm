package 基础练习;
import java.util.Arrays;
/**
 * 问题描述
　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
输入格式
　　第一行为一个整数n。
　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
输出格式
　　输出一行，按从小到大的顺序输出排序后的数列。
样例输入
5
8 3 6 4 9
样例输出
3 4 6 8 9
 */
import java.util.Scanner;

//public class 数列排序 {
//	public static void main(String[] args) {
//		int[] f = new int[200];
//		Scanner sc = new Scanner(System.in);
//		int n= sc.nextInt();
//		for(int i=0;i<n;i++){
//			f[sc.nextInt()]++;
//		}
//		for(int i=0;i<200;i++){
//			if(f[i]!=0)
//				System.out.print(i+" ");
//		}
//	}
//}
public class 数列排序 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] f = new int[n];
		for(int i=0;i<n;i++){
			f[i]=sc.nextInt();
		}
		Arrays.sort(f);
		for(int i=0;i<n;i++){
			System.out.print(f[i]+" ");
		}
	}
}

//答案
/*import java.util.*;  
public class Main {  
    public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);  
        int n = in.nextInt();  
        int[] a = new int[n];  
        for(int i = 0 ; i < n ;i++){  
            a[i]=in.nextInt();  
        }  
        Arrays.sort(a);  
        for(int i = 0 ; i < n ;i++){  
            System.out.print(a[i]+" ");  
        }  
    }  
}  */