package 第八届;

import java.util.Scanner;

/*
 * 
标题： Excel地址

Excel单元格的地址表示很有趣，它使用字母来表示列号。
比如，
A表示第1列，
B表示第2列，
Z表示第26列，
AA表示第27列，
AB表示第28列，
BA表示第53列，
....

当然Excel的最大列号是有限度的，所以转换起来不难。
如果我们想把这种表示法一般化，可以把很大的数字转换为很长的字母序列呢？

本题目既是要求对输入的数字, 输出其对应的Excel地址表示方式。

例如，
输入：
26
则程序应该输出：
Z

再例如，
输入：
2054
则程序应该输出：
BZZ

我们约定，输入的整数范围[1,2147483647]

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。

------------------------------

笨笨有话说：
    这有点像进制关系，又不完全是。好像末2位是以1当26，末3位是以1当26*26

歪歪有话说：
    要是从字母序列转数字还好点，倒过来有点麻烦，不过计算机跑得快啊。




 */
public class Excel地址 {
	static void f(int n)
	{
		char c=(char) ((n-1)+'a');
		System.out.print(c);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);  
        int[] iA = new int[5000];  
        int n = in.nextInt();  
        int i = 1;  
        while (n != 0) {  
            if (n % 26 == 0) {  
                // +64转大写字母，+96转小写字母  
                iA[i] = 26 + 64;  
                n -= 1;  
            } else {  
                iA[i] = n % 26 + 64;  
            }  
            n /= 26;  
            i++;  
        }  
        for (int j = i - 1; j > 0; j--) {  
            System.out.print((char)iA[j]);  
        }  
	}

}
