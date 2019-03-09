package 入门训练;



/**
 * 问题描述
Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。

当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。

输入格式
输入包含一个整数n。
输出格式
输出一行，包含一个整数，表示Fn除以10007的余数。
样例输入
10
样例输出
55
样例输入
22
样例输出
7704
 * @author YY
 *
 */
import java.util.Scanner;
public class Fibonacci数列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] f=new int[1000000];
		f[0]=1;
		f[1]=1;
		if(n==1||n==2)
			System.out.println(f[0]);
		else{
			for(int i=2;i<n;i++){
				f[i]=(f[i-1]+f[i-2])%10007;
			}
			System.out.println(f[n-1]);
		}
	}
}



//正确答案
//import java.util.*;      
//public class Main{  
//        public static void main(String[] args) {      
//            int[] a=new int[10000000];  
//            int number_p=10007;  
//            a[0]=a[1]=1;  
//            Scanner scanner=new Scanner(System.in);  
//            int number=scanner.nextInt();  
//            if(number==1 || number==2){  
//                System.out.println(a[0]);  
//            }else{  
//                for (int i = 2; i <number; i++){  
//                   a[i]=(a[i-1]+a[i-2])%number_p;  
//                }  
//                System.out.println(a[number-1]);  
//            }  
//    }  
//} 



