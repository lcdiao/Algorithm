package LintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定n个区间，输出最少需要取多少个点，使任意一个区间均包含至少一个点。
 *
 * 样例
 * 给出a=[(1,5),(4,8),(10,12)]，返回2
 *
 * 解释：
 * 选择两个点：5,10，
 * 第一个区间[1,5]包含了5，
 * 第二个区间[4,8]包含了5，
 * 第三个区间[10,12]包含了10.
 * 给出a=[(1,5),(4,8),(5,12)]，返回1
 *
 * 解释：
 * 选择一个点：5，
 * 第一个区间[1,5]包含了5，
 * 第二个区间[4,8]包含了5，
 * 第三个区间[5,12]包含了5.
 * 注意事项
 * 1 \leq n \leq 1e41≤n≤1e4
 * 区间最大值不超过 1e51e5
 */
public class 区间最小覆盖 {
    public static void main(String[] args) {
        List<Interval> a = new ArrayList<>();
        a.add(new Interval(38,98));
        a.add(new Interval(12,73));
        a.add(new Interval(61,87));
        a.add(new Interval(77,87));
        a.add(new Interval(94,100));
        a.add(new Interval(13,83));
        a.add(new Interval(5,89));
        a.add(new Interval(53,71));
//        a.sort( (i,j) -> i.start - j.start);
//        a.forEach( System.out::println);
        System.out.println(getAns(a));
    }
    /**
     * @param a: the array a
     * @return: return the minimal points number
     */
    public static int getAns(List<Interval> a) {
        if (a == null || a.size() == 0) {
            return 0;
        }
        //根据start排序
        a.sort( (i,j) -> i.start - j.start);
//        a.forEach( System.out::println);
//        System.out.println("======================");
        List<Interval> b = new ArrayList<>();
        b.add(a.get(0));
        int size = a.size();
        boolean flag = true;
        for (int i =1; i < size; i++) {
            flag = true;
            Interval ai = a.get(i);
            for (Interval bi : b) {
                if (bi.end >= ai.start) {
                    int start = ai.start;
                    int end = bi.end;
                    if (ai.end <= bi.end) {
                        end = ai.end;
                    }
                    bi.start = start;
                    bi.end = end;
                    //System.out.println(bi);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                b.add(ai);
            }
        }

        return b.size();
    }

    public static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }

        @Override
        public String toString() {
            return "[" +  start +
                    "," + end +
                    ']';
        }
    }

}
