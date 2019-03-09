package 第七届;
/**
 * 
      B      DEF
A + --- + ------- = 10
     C      GHI
     
（如果显示有问题，可以参见【图1.jpg】）
	 
	 
这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。

比如：
6+8/3+952/714 就是一种解法，
5+3/1+972/486 是另一种解法。

这个算式一共有多少种解法？

注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。

 *
 */
public class 凑算式 {
	public static void main(String[] args) {
		int count=0;
		int[] i = new int[5];
		for(i[0]=1;i[0]<10;i[0]++)
		{
			for(i[1]=1;i[1]<10;i[1]++)
			{
				for(i[2]=1;i[2]<10;i[2]++)
				{
					for(i[3]=111;i[3]<1000;i[3]++)
					{
						for(i[4]=111;i[4]<1000;i[4]++)
						{
							if(check(i))
							{
								count++;
								System.out.println(i[0]+"+"+i[1]+"/"+i[2]+"+"+i[3]+"/"+i[4]+"=10");
							}
						}
					}
				}
			}
		}
		System.out.println(count);
		
		
		
	}
	public static boolean check(int[] a){
		if(a[0]*a[2]*a[4]+a[1]*a[4]+a[3]*a[2]!=10*a[2]*a[4])
			return false;
		int[] b = new int[10];
		b[a[0]]++;
		b[a[1]]++;
		b[a[2]]++;
		b[a[3]/100]++;
		b[a[3]%100/10]++;
		b[a[3]%10]++;
		b[a[4]/100]++;
		b[a[4]%100/10]++;
		b[a[4]%10]++;
		for(int i=1;i<10;i++){
			if(b[i]!=1)
				return false;
		}
		return true;
	}
}
