package 练习;

public class 阶乘递归 {
	public static int f(int n)
	{
		if(n==1)
		{
			return 1;
		}
		return n*f(n-1);
	}
	public static void main(String[] args) {
		System.out.println(f(5));
	}
}
