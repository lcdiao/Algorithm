package 第六届;
/*

无穷的分数，有时会趋向于固定的数字。
请计算【图1.jpg】所示的无穷分数，要求四舍五入，精确到小数点后5位，小数位不足的补0。

请填写该浮点数，不能填写任何多余的内容。
 */
public class 无穷分数 {
	public static void main(String[] args) {
		double n = 1000022.0;
		double sum = n+2;
		for(double i=n;i>=1;i--)
		{
			sum=i+(i+1)/sum;
		}
		System.out.println(1/sum);
		System.out.println(String.format("%.5f", 1/sum));
	}

}
