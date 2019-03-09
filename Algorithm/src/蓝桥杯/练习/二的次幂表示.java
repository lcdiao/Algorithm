package 练习;

import java.util.Scanner;

/*
问题描述
　　任何一个正整数都可以用2进制表示，例如：137的2进制表示为10001001。
　　将这种2进制表示写成2的次幂的和的形式，令次幂高的排在前面，可得到如下表达式：137=2^7+2^3+2^0
　　现在约定幂次用括号来表示，即a^b表示为a（b）
　　此时，137可表示为：2（7）+2（3）+2（0）
　　进一步：7=2^2+2+2^0 （2^1用2表示）
　　3=2+2^0 
　　所以最后137可表示为：2（2（2）+2+2（0））+2（2+2（0））+2（0）
　　又如：1315=2^10+2^8+2^5+2+1
　　所以1315最后可表示为：
　　2（2（2+2（0））+2）+2（2（2+2（0）））+2（2（2）+2（0））+2+2（0）
输入格式
　　正整数（1<=n<=20000）
输出格式
　　符合约定的n的0，2表示（在表示中不能有空格）
样例输入
137
样例输出
2(2(2)+2+2(0))+2(2+2(0))+2(0)
样例输入
1315
样例输出
2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
提示
　　用递归实现会比较简单，可以一边递归一边输出
 */
public class 二的次幂表示 {
	public static String f(int n){
		String result = "";
		if(n==2){
			return "2";
		}
		if(n==0){
			return "0";
		}
		String s = Integer.toBinaryString(n)+"";
		int len = s.length();
		for(int i=0;i<len;i++){
			if(s.charAt(i)=='1'){
				int n2=len-i-1;
				if(n2==1)result+="2";
				else result+="2("+f(n2)+")";
				if(n2!=0){
					result+="+";
				}
			}
		}
		for(int i=0;i<result.length();i++){
			if(result.charAt(i)==')'){
				if(result.charAt(i-1)=='+'){
					result=result.substring(0, i-2)+result.substring(i,result.length());
				}
			}
			if(result.charAt(result.length()-1)=='+'){
				result=result.substring(0,result.length()-1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(f(sc.nextInt()));
	}
}
