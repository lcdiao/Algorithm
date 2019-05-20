package LintCode.白银4;

import java.util.HashSet;
import java.util.LinkedList;

/*
给定一个容积为 s 的装满可乐的瓶子和两个容积分别为 n 和 m 的空杯子, 其中 n + m = s. 问能否通过在三个容器之间来回倒可乐来平分这 s 体积的可乐? 如果可以, 返回最少倾倒可乐的次数; 反之返回 -1.

由于瓶子和杯子上没有刻度, 所以当你从一个容器倒可乐到另一个容器中时, 只能一直倒可乐直到一个容器空了或者另一个满了为止.

样例
样例 1:

输入: s = 4, n = 1, m = 3
输出: 3
解释:
  首先, 从瓶子倒3体积的可乐到第二个杯子, 瓶子和两个杯子中分别有 1, 0, 3 体积的可乐.
  然后, 倒1体积的可乐从第二个杯子到第一个杯子, 此时三个容器分贝有 1, 1, 2 体积的可乐.
  最后, 倒1体积的可乐从第一个杯子到瓶子, 此时瓶子和第二个杯子中都有 2 体积的可乐, 平分.
样例 2:

输入: s = 7, n = 4, m = 3
输出: -1
解释: 7 体积的可乐不能被平分.
注意事项
s <= 100
 */
public class 倒可乐 {
    public static void main(String[] args) {
        System.out.println(getMinTimes(4,1,3));
        System.out.println(getMinTimes(20,7,13));


    }
    /**
     * @param s: the volume of cola
     * @param n: the volume of the first cup
     * @param m: the volume of the second cup
     * @return: the minimum number of times to be inverted
     */
    public static int getMinTimes(int s, int n, int m) {
        if (s==0 || s%2 == 1) {
            return -1;
        }
        int num = s/2;
        if (n < num && m < num) {
            return -1;
        }
        if (n == num || m == num) {
            return 1;
        }
        if (n > m) {
            n^=m;
            m^=n;
            n^=m;
        }
        int c0=s,c1=0,c2=0,count=0;
        while (c0 != num) {
            count++;


//            System.out.println(c0 + "\t" + c1 + "\t" + c2);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


            if (c0+c1==c2||c0+c2==c1){
                return count;
            }

            //小瓶子为空则无论中是否满，都倒入
            if (c1==0 && c2 != 0) {
                c1 = c2>n?n:c2;
                c2 = c2>n?c2-n:0;
                continue;
            }

            //小倒大且只在满的时候倒
            if (c1==n && c0 != s) {
                int a = c0;
                c0 = c0+c1>s?s:c0+c1;
                c1 = a+c1>s?a+c1-s:0;
                continue;
            }
            //大倒中
            if (c0!=0 && c2 != m){
                int a = c2;
                c2 = c2+c0>m?m:c2+c0;
                c0 = a+c0>m?a+c0-m:0;
                continue;
            }
            //中倒小
            if (c2!=0 && c1 != n) {
                int a = c1;
                c1 = c1+c2>n?n:c1+c2;
                c2 = a+c2>n?a+c2-n:0;
                continue;
            }
        }
        if (c1 == num || c2 == num) {
            return count;
        } else {
            return count+1;
        }
    }

    public static int getMinTimes2(int s, int n, int m) {
        // Write your code here
        if(s%2==1) return -1;
        LinkedList<Integer> queue=new LinkedList<>();
        int num=s*10000;
        HashSet<Integer> set=new HashSet<>();
        set.add(num);
        queue.add(num);
        int cnt=0;
        while(queue.size()>0){
            int len=queue.size();
            cnt++;
            while(len-->0){
                int a=queue.poll();
                int s1=a/10000;
                int n1=(a/100)%100;
                int m1=a%100;
                //System.out.println("cnt:"+cnt+">>>"+a);

                if(n1==s/2||m1==s/2) return cnt;
                if(s1<s){
                    int b=10000*Math.min(s,s1+n1)+100*Math.max(0,n1-(s-s1))+m1;
                    if(!set.contains(b)){
                        queue.add(b);
                        set.add(b);
                    }
                    int b1=10000*Math.min(s,s1+m1)+100*n1+Math.max(0,m1-(s-s1));
                    if(!set.contains(b1)){
                        queue.add(b1);
                        set.add(b1);
                    }
                }
                if(n1<n){
                    int b=10000*Math.max(0,s1-(n-n1))+100*Math.min(n,s1+n1)+m1;
                    if(!set.contains(b)){
                        queue.add(b);
                        set.add(b);
                    }
                    int b1=10000*s1+100*Math.min(n,n1+m1)+Math.max(0,m1-(n-n1));
                    if(!set.contains(b1)){
                        queue.add(b1);
                        set.add(b1);
                    }
                }
                if(m1<m){
                    int b=10000*Math.max(0,s1-(m-m1))+100*n1+Math.min(m,m1+s1);
                    if(!set.contains(b)){
                        queue.add(b);
                        set.add(b);
                    }
                    int b1=10000*s1+100*Math.max(0,n1-(m-m1))+Math.min(m,m1+n1);
                    if(!set.contains(b1)){
                        queue.add(b1);
                        set.add(b1);
                    }
                }
            }
        }
        return -1;
    }

}
