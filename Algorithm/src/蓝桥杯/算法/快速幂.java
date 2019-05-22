package 蓝桥杯.算法;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class 快速幂 {
    public static void main(String[] args) {
        System.out.println(poww(3,4));

    }
    //快速幂
    static double poww(int a,int b) {
        double ans = 1,base = a;
        while (b!=0) {
            if ((b&1) != 0) {
                ans *= base;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }
}


