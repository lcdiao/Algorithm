package 基础练习;
/**
 问题描述
　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
输出格式
　　按从小到大的顺序输出满足条件的四位十进制数。
 */
public class 回文数 {
	public static void main(String[] args) {
		String s=null;
		for(int i=1000;i<10000;i++)
		{
			s=i+"";
			if(s.charAt(0)==s.charAt(3)&&s.charAt(1)==s.charAt(2))
			{
				System.out.println(i);
			}
		}
	}
}
