package 练习;
/**
 美国数学家维纳(N.Wiener)智力早熟，11岁就上了大学。他曾在1935~1936年应邀来中国清华大学讲学。
    一次，他参加某个重要会议，年轻的脸孔引人注目。于是有人询问他的年龄，他回答说：
    “我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。”
请你推算一下，他当时到底有多年轻。

 */
public class 猜年龄 {
	public static void main(String[] args) {
		int[] age=new int[11];
		for(int i=10;i<100;i++)
		{
			int a1=i*i*i;
			int a2=i*i*i*i;
			if(a1>1000&&a2>100000&&a1<10000)
			{
				
				age[a1%10]++;
				age[a1%100/10]++;
				age[a1%1000/100]++;
				age[a1/1000]++;
				age[a2%10]++;
				age[a2%100/10]++;
				age[a2%1000/100]++;
				age[a2%10000/1000]++;
				age[a2%100000/10000]++;
				age[a2/100000]++;
				boolean flag=true;
				for(int j=0;j<10;j++)
				{
					if(age[j]!=1)
					{
						flag=false;
						break;
					}
				}
				if(flag)
				{
					System.out.println(i);
				}
			}
		}

	}
}
