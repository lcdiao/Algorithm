package 练习;

/**
 素数就是不能再进行等分的数。比如：2 3 5 7 11 等。
    9 = 3 * 3 说明它可以3等分，因而不是素数。
我们国家在1949年建国。如果只给你 1 9 4 9 这4个数字卡片，可以随意摆放它们的先后顺序
（但卡片不能倒着摆放啊，我们不是在脑筋急转弯！），那么，你能组成多少个4位的素数呢？
比如：1949，4919 都符合要求。
编程：能组成的4位素数的个数，并罗列这些素数!

 */
public class 组素数 {
	public static void main(String[] args) {
		int n=0;
		int[] a=new int[10000];
		int[] b=new int[10];
		for(int i=1900;i<9920;i++)
		{
			boolean flag=false;
			for(int j=2;j<i/2;j++)
			{
				if(i%j==0)
				{
					flag=true;
					a[n++]=i;
					break;
				}
			}
			if(!flag)
			{
				for(int k=0;k<10;k++)
					b[k]=0;
				int n1=i/1000;
				int n2=i/100%10;
				int n3=i/10%10;
				int n4=i%10;
				b[n1]++;b[n2]++;b[n3]++;b[n4]++;
				if(b[1]==1&&b[4]==1&&b[9]==2)
				{
					System.out.println(i);
				}
			}
		}

	}
}
