package 入门训练;



/**
 * 问题描述
给定圆的半径r，求圆的面积。
输入格式
输入包含一个整数r，表示圆的半径。
输出格式
输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。
 * @author YY
 *
 */
import java.util.Scanner;
public class 圆的面积 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r=sc.nextInt();
		double PI=3.14159265358979323;
		double area = r*PI*r;
		/*String s=area+"";
		int i=s.indexOf('.');
		int last=Integer.parseInt(s.charAt(8+i)+"");
		if(last>=5){
			area=Double.parseDouble(s.substring(0, i)+s.substring(i, 8+i))+0.0000001;
			s=area+"";
		}
		area=Double.parseDouble(s.substring(0, i)+s.substring(i, 8+i));
		System.out.println(area);*/
		System.out.printf("%.7f",area);
	}
}


//正确
/*
 * import java.util.*;  
    public class Main  
        {  
            private static final double PI=3.14159265358979323;  
            public static void main(String[] args)   
            {  
                double result;  
                Scanner scanner=new Scanner(System.in);  
                int n=scanner.nextInt();  
                result=PI*n*n;  
                System.out.printf("%.7f",result);  
            }  
        }  
 */


