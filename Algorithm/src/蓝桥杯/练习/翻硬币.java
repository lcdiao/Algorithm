package 练习;

import java.util.Scanner;

/**
 小明正在玩一个“翻硬币”的游戏。桌上放着排成一排的若干硬币。我们用 * 表示正面，用 o 表示反面（是小写字母，不是零）。
	 比如，可能情形是：**oo***oooo，如果同时翻转左边的两个硬币，则变为：oooo***oooo，
	 现在小明的问题是：如果已知了初始状态和要达到的目标状态，每次只能同时翻转相邻的两个硬币,
	 那么对特定的局面，最少要翻动多少次呢？我们约定：把翻动相邻的两个硬币叫做一步操作，那么要求：
输入格式
两行等长的字符串，分别表示初始状态和要达到的目标状态。每行的长度<1000
输出格式
一个整数，表示最小操作步数。
样例输入1
**********	-->	oo******** -->   o*o*******	-->  o**o******	--> o***o*****
o****o****
样例输出1
5
样例输入2
*o**o***o***
*o***o**o***
样例输出2
1

 */
public class 翻硬币 {
	
	public static void main(String[] args) {
		 Scanner in=new Scanner(System.in);  
	        String str1=in.next();  
	        String str2=in.next();  
	        int sum=0;  
	        char[] ch1=str1.toCharArray();  
	        char[] ch2=str2.toCharArray();  
	        for(int i=0;i<ch1.length;i++){  
	            if(ch1[i]!=ch2[i]&&(ch1[i+1]==ch2[i+1])){  
	                if(ch1[i+1]=='*')  
	                    ch1[i+1]='o';  
	                else if(ch1[i+1]=='o')  
	                    ch1[i+1]='*';  
	                sum++;  
	            }  
	            else if(ch1[i]!=ch2[i]&&(ch1[i+1]!=ch2[i+1])){  
	                sum++;  
	                i++;  
	            }  
	        }  
	        System.out.println(sum); 
	}

}
