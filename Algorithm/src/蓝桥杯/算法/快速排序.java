package 算法;

public class 快速排序 {
	static int[] a = {6,1,2,7,9,3,4,444,5634,23,-5,5,10,8,-9,-77,5,546,777};
	/*public static void quicksort(int left,int right)
	{
		int i,j,t,temp;
		if(left>right)
			return;
		temp=a[left];//temp存基准数
		i=left;
		j=right;
		while(i!=j)
		{
			//顺序很重要，要先从右往左找
			while(a[j]>=temp&&i<j)
			{
				j--;
			}
			//再从左往右找
			while(a[i]<=temp&&i<j)
			{
				i++;
			}
			//交换两个数在数组中的位置
			if(i<j)//当i和j还没有相遇时
			{
				t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
			
		}
		//最终将基准数归位
		a[left]=a[i];
		a[i]=temp;
		quicksort(left,i-1);	//继续处理左边的
		quicksort(i+1,right);	//继续处理右边的
		
	}*/
	public static void quicksort(int left,int right)
	{
		int i,j,t,temp;
		if(left>right)return;//递归出口
		i=left;
		j=right;
		temp=a[left];
		
		while(i!=j)
		{
			while(a[j]>=temp&&i<j)
				j--;
			while(a[i]<=temp&&i<j)
				i++;
			if(i<j)
			{
				t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
		a[left]=a[i];
		a[i]=temp;
		quicksort(left,i-1);
		quicksort(i+1,right);
		
	}
	
	public static void main(String[] args) {
		p();
		quicksort(0,a.length-1);
		p();
		
	}
	
	
	
	public static void p(){
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
}
