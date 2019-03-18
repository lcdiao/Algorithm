package 练习;

public class 字母全排列 {
	static String s = "ABCDE";
	static char[] c = s.toCharArray();
	static int count=0;
	static void f(int n)
	{
		if(n==c.length)
		{	
			for(int i=0;i<c.length;i++)
				System.out.print(c[i]+" ");
			System.out.println();
			count++;
			return ;
		}
		for(int i=n;i<c.length;i++)
		{
			char t=c[n];
			c[n]=c[i];
			c[i]=t;
			f(n+1);
			//t=c[n];c[n]=c[i];c[i]=t;
		}
	}
	public static void main(String[] args) {
		f(0);
		System.out.println(count);
	}

}
