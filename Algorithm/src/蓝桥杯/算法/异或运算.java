package 算法;
/*
 * 实现a与b交换值
 */
public class 异或运算 {
	public static void main(String[] args) {
		int a = 3;
		int b = 6;
		System.out.println("交换前:a="+a+",b="+b);
/*		a=a^b;	System.out.println(a);	//5
		b=a^b;	System.out.println(b);	//3
		a=a^b;	System.out.println(a);	//6
*/		
		System.out.println(Integer.toBinaryString(a));	//011
		System.out.println(Integer.toBinaryString(b));	//110
		a=a^b;	System.out.println(Integer.toBinaryString(a));	//101	(011^110=101)
		b=a^b;System.out.println(Integer.toBinaryString(b));	//11	(101^110=011)
		a=a^b;	System.out.println(Integer.toBinaryString(a));	//110	(101^011=110)
		
		System.out.println("交换后:a="+a+",b="+b);
	}
}
