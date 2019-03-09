package 练习;

/**
 寻找矩阵中各元素的排列规律，输出矩阵。
1	2	6	7	15
3	5	8	14	16
4	9	13	17	22
10	12	18	21	23
11	19	20	24	25
注：不能直接用printf语句输出
比如：printf(“1  2  6   7   15\n”);
printf(“3  5  8   14  16\n”);
printf(“4  9  13  17  20\n”);
这样的不计分。

 */
public class 输出蛇形矩阵 {
	public static void main(String[] args) {
		int[][] a=new int[5][5];
		int num=1;
		boolean b=true;
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<5;j++)
			{
				for(int k=0;k<5;k++)
				{
					if(j+k==i)
					{
						if(!b)
							a[j][k]=num++;
						if(b)
							a[k][j]=num++;
					}
					if(j+k>i)break;
				}
				
			}
			b=!b;
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}

	}
}
