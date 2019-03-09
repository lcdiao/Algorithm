package 练习;

public class 地图走法 {
	static int[][] m = new int[5][5];
	static int count=0;
	static void print()
	{
		int i,j;
		for(i=0;i<5;i++)
		{
			for(j=0;j<5;j++)
			{
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}
	static void f(int x,int y,int ex,int ey)
	{
		m[x][y]=1;
		if(x==ex&&y==ey)
		{
			print();
			System.out.println();
			count++;
		}
		if(x<ex)	f(x+1,y,ex,ey);
		if(y<ey)	f(x,y+1,ex,ey);
		m[x][y]=0;
	}
	public static void main(String[] args) {
		f(0,0,3,3);
		System.out.println(count);
		
	}

}
