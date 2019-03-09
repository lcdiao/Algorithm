package 第七届;

/**
 * 
 小明最近喜欢搭数字积木，
一共有10块积木，每个积木上有一个数字，0~9。

搭积木规则：
每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
最后搭成4层的金字塔形，必须用完所有的积木。

下面是两种合格的搭法：

0
1 2
3 4 5
6 7 8 9

0
3 1
7 5 2
9 8 6 4    

请你计算这样的搭法一共有多少种？

请填表示总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

 *
 */
public class 搭积木 {
	static int[] a=new int[10];
	static int[] n=new int[10];
	static int count=0;
	public static void main(String[] args) {
		f(0);
		System.out.println(count);
	}
	
	public static void f(int num)
	{
		if(num==10)
		{
			if(check())
			{
				/*for(int i=0;i<10;i++)
				{
					System.out.print(a[i]+"\t");
					if(i==0||i==2||i==5||i==9)
						System.out.println();
				}
				System.out.println();*/
				count++;
			}
			return ;
		}
		
		for(a[num]=0;a[num]<10;a[num]++)
		{
			if(n[a[num]]==0)
			{
				n[a[num]]++;
				num++;
				f(num);
				num--;
				n[a[num]]--;
			}else {  
                continue;  
            }
		}
		
	}

	public static boolean check(){
		if (a[0]<a[1]&&a[0]<a[2]&&a[1]<a[3]&&a[1]<a[4]  
                &&a[2]<a[4]&&a[2]<a[5]&&a[3]<a[6]&&a[3]<a[7]  
                        &&a[4]<a[7]&&a[4]<a[8]&&a[5]<a[8]&&a[5]<a[9]) {  
            return true;  
        }else {  
            return false;  
        } 
	}
	
}

/*public class 搭积木 {  
    static int count = 0;  
    public static void main(String[] args) {  
        int a[] = new int[10];  
        boolean visit[] = new boolean[10];  
        dfs(a,visit,0);  
        System.out.println(count);  
    }  
    private static void dfs(int[] a, boolean[] visit, int num) {  
        if (num==10) {  
            if (judge(a)) {  
                count++;  
            }  
            return;  
        }  
        for (a[num] = 0; a[num]<10; a[num]++) {  
            if (visit[a[num]]==false) {  
                visit[a[num]]=true;  
                num = num + 1;  
                dfs(a, visit, num);  
                num = num - 1;//注意回溯  
                visit[a[num]]=false;//注意回溯  
            }else {  
                continue;  
            }  
        }  
    }  
    private static boolean judge(int[] a) {  
        if (a[0]<a[1]&&a[0]<a[2]&&a[1]<a[3]&&a[1]<a[4]  
                &&a[2]<a[4]&&a[2]<a[5]&&a[3]<a[6]&&a[3]<a[7]  
                        &&a[4]<a[7]&&a[4]<a[8]&&a[5]<a[8]&&a[5]<a[9]) {  
            return true;  
        }else {  
            return false;  
        }  
          
    }  
  
}  */
