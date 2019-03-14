package LintCode;

import java.util.Arrays;

/**
 * Created by diao on 2019/3/14
 *
 * 给定 n 个学生的学号(从 1 到 n 编号)以及他们的考试成绩，表示为(学号，考试成绩)，请将这些学生按考试成绩降序排序，若考试成绩相同，则按学号升序排序。
 *
 * 样例
 * 样例1
 *
 * 输入: array = [[2,50],[1,50],[3,100]]
 * 输出: [[3,100],[1,50],[2,50]]
 * 样例2
 *
 * 输入: array = [[2,50],[1,50],[3,50]]
 * 输出: [[1,50],[2,50],[3,50]]
 */
public class 多关键字排序 {
    public static void main(String[] args) {
        int[][] a = new int[3][2];
        a[0][0] = 19;a[0][1] = 91;
        a[1][0] = 1;a[1][1] = 91;
        a[2][0] = 18;a[2][1] = 84;
        a=multiSort(a);
        for (int i = 0;i < a.length; i++) {
            System.out.println(a[i][0]+":"+a[i][1]);
        }
    }

    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public static int[][] multiSort(int[][] array) {
        int n=0,m=0;
        int x,y = 0;
        int len = array.length;
        for (int i = 0;i < len; i++) {
            m = 0;
            for (int j = i; j<len; j++ ) {
                if (array[j][1] > m) {
                    n = j;
                    m = array[j][1];
                }
            }
            x = array[i][0];
            y = array[i][1];
            array[i][0] = array[n][0];
            array[i][1] = m;
            array[n][0] = x;
            array[n][1] = y;
        }
        int a = 0;
        for (int i = 0; i < len-1; i++) {
            a=0;
            while (i+1<len && array[i][1] == array[i+1][1]) {
                a++;
                i++;
            }
            if (a > 0) {
                for (int j = i-a; j <= i; j++){
                    m = array[j][0];
                    n = j;
                    for (int k = j+1 ; k <= i; k++) {
                        if ( array[k][0] < m) {
                            m = array[k][0];
                            n = k;
                        }
                    }
                    x = array[n][0];
                    array[n][0] = array[j][0];
                    array[j][0] = x;
                }
            }
        }


        return array;
    }
}
