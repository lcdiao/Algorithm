package 练习;
/**
 * 
 
寒假作业

现在小学的数学题目也不是那么好玩的。
看看这个寒假作业：

   □ + □ = □
   □ - □ = □
   □ × □ = □
   □ ÷ □ = □
   
   (如果显示不出来，可以参见【图1.jpg】)
   
每个方块代表1~13中的某一个数字，但不能重复。
比如：
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

以及： 
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5

就算两种解法。（加法，乘法交换律后算不同的方案）
 
你一共找到了多少种方案？


请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。


 *
 */
public class 寒假作业 {
	static int[] a = new int[12];
	static int[] b = new int[14];
	static int count=0;
	public static void f(int i){
		if(i==12)
		{
			if(check())
			{
				System.out.print(a[0]+"+"+a[1]+"="+a[2]+"\t");
				System.out.print(a[3]+"-"+a[4]+"="+a[5]+"\t");
				System.out.print(a[6]+"*"+a[7]+"="+a[8]+"\t");
				System.out.println(a[9]+"/"+a[10]+"="+a[11]+"\t");
				count++;
			}
			
			return ;
		}
		for(a[i]=0;a[i]<=13;a[i]++)
		{
			if(b[a[i]]==0)
			{
				b[a[i]]++;
				f(i+1);
				b[a[i]]--;
			}
		}
	}
	public static boolean check(){
		if(a[0]+a[1]!=a[2])	return false;
		if(a[3]-a[4]!=a[5])	return false;
		if(a[6]*a[7]!=a[8])	return false;
		if(a[11]*a[10]!=a[9])	return false;
		if(b[1]+b[2]+b[3]+b[4]+b[5]+b[6]+b[7]+b[8]+b[9]+b[10]+b[11]+b[12]+b[13]!=12)	return false;	
		return true;
	}
	public static void main(String[] args) {
		f(0);
		System.out.println(count);
	}

}

/*public class 寒假作业 {  
    static int count =0;  
    public static void main(String[] args) {  
        int a[] = new int[14];  
        boolean visit[] = new boolean[14];  
        visit[0] = true;  
        dfs(a,visit,1);  
        System.out.println(count);  
    }  
  
    private static void dfs(int[] a, boolean[] visit, int num) {  
        if (num==14) {  
            count++;  
            return;  
        }  
        for (a[num] = 1; a[num] < 14; a[num]++) {  
            if (jianzhi(a,num)) {//先判断再计算  
                if (visit[a[num]]==false) {  
                    visit[a[num]]=true;  
                    num = num +1 ;  
                    dfs(a, visit, num);  
                    num = num - 1;  
                    visit[a[num]]=false;  
                }else {  
                    continue;  
                }  
            }else {  
                continue;  
            }  
        }  
    }  
  
    private static boolean jianzhi(int[] a, int num) {  
        if (num==3&&a[1]+a[2]!=a[3]) {  
            return false;  
        }else if (num==6&&a[4]-a[5]!=a[6]) {  
            return false;  
        }else if (num==9&&a[7]*a[8]!=a[9]) {  
            return false;  
        }else if (num==12&&(a[10]/a[11]!=a[12]||a[10]%a[11]!=0)) {  
            return false;  
        }  
        return true;  
    }  
//  private static boolean judge(int[] a) {  
//      if (a[1]+a[2]==a[3]&&a[4]-a[5]==a[6]&&a[7]*a[8]==a[9]  
//              &&(a[10]/a[11]==a[12]&&a[10]%a[11]==0)) {//一定要判断余数为0  
//          return true;  
//      }else {  
//          return false;  
//      }  
//        
//  }  
}  */
