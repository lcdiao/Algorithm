package 基础练习;



/**
 * 问题描述
　　给定n个十六进制正整数，输出它们对应的八进制数。

输入格式
　　输入的第一行为一个正整数n （1<=n<=10）。
　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。

输出格式
　　输出n行，每行为输入对应的八进制正整数。

　　【注意】
　　输入的十六进制数不会有前导0，比如012A。
　　输出的八进制数也不能有前导0。

样例输入
　　2
　　39
　　123ABC

样例输出
　　71
　　4435274

 * @author YY
 *
 */
//import java.util.*;
//public class 十六进制转八进制 {
//	public static int f(char a,int num){
//		int o=0;
//		char choice = a;
//		switch(choice){
//			case 'F': o=15;break;
//			case 'E': o=14;break;
//			case 'D': o=13;break;
//			case 'C': o=12;break;
//			case 'B': o=11;break;
//			case 'A': o=10;break;
//			default:
//				o = Integer.parseInt(a+"");
//		}
//		return (int) (o*Math.pow(16, num));
//	}
//	public static String b(int n){
//		if(n<8)
//			return n+"";
//		else{
//			b(n/8);
//			return b(n/8)+""+n%8;
//		}
//	}
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();sc.nextLine();
//		String[] s = new String[n];
//		for(int i=0;i<n;i++){
//			s[i]=sc.nextLine();
//		}
//		for(int i=0;i<n;i++){	
//			int shi=0;
//			for(int j = 0;j<s[i].length();j++){
//				shi+=f(s[i].charAt(j),s[i].length()-j-1);
//			}
//			//System.out.println(shi);	
//			System.out.println(b(shi));
//		}
//	}
//}
import java.util.*;
 public class 十六进制转八进制{
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         String[] sts = new String[n];
         for(int i=0;i<n;i++){
             sts[i] = sc.next();
         }
         sc.close();
         for(int i=0;i<n;i++){
             String strBinary = toBinary(sts[i]);
             int len_strBin = strBinary.length();
             if(len_strBin%3==1) strBinary = "00"+strBinary;
             if(len_strBin%3==2) strBinary = "0"+strBinary;
             String strOctal = toOctal(strBinary);
             System.out.println(strOctal);
         }
     }
     private static String toOctal(String strBinary) {
         int len = strBinary.length();
         int k;
         StringBuffer stb = new StringBuffer();
         if(strBinary.substring(0, 3).equals("000"))
             k=3;
         else
             k=0;
         for(int i=k;i<len-2;i+=3){
             switch (strBinary.substring(i, i+3)) {
                 case "000":stb.append("0");break;
                 case "001":stb.append("1");break;
                 case "010":stb.append("2");break;
                 case "011":stb.append("3");break;
                 case "100":stb.append("4");break;
                 case "101":stb.append("5");break;
                 case "110":stb.append("6");break;
                 case "111":stb.append("7");break;
                 default:break;
            }
         }
         return stb.toString();
     }
     private static String toBinary(String strHex) {
         int len_str = strHex.length();
         StringBuffer stb = new StringBuffer();
         for(int i=0;i<len_str;i++){
             switch (strHex.charAt(i)) {
                 case '0':stb.append("0000");break;
                 case '1':stb.append("0001");break;
                 case '2':stb.append("0010");break;
                 case '3':stb.append("0011");break;
                 case '4':stb.append("0100");break;
                 case '5':stb.append("0101");break;
                 case '6':stb.append("0110");break;
                 case '7':stb.append("0111");break;
                 case '8':stb.append("1000");break;
                 case '9':stb.append("1001");break;
                 case 'A':stb.append("1010");break;
                 case 'B':stb.append("1011");break;
                 case 'C':stb.append("1100");break;
                 case 'D':stb.append("1101");break;
                 case 'E':stb.append("1110");break;
                 case 'F':stb.append("1111");break;
                 default:break;
             }
         }
         return stb.toString();
     }
 }
