package LintCode;

/**
 * Created by diao on 2019/3/14
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。
 *
 * 你可以假设在数组中无重复元素。
 *
 * 样例
 * [1,3,5,6]，5 → 2
 *
 * [1,3,5,6]，2 → 1
 *
 * [1,3,5,6]， 7 → 4
 *
 * [1,3,5,6]，0 → 0
 *
 * 挑战
 * 时间复杂度为O(log(n))
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] A = new int[]{1};

        System.out.println(searchInsert(A,7));
    }

    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public static int searchInsert(int[] A, int target) {
        int len = A.length;
        if (A == null || len == 0){
            return 0;
        }
        int n = f(A,0,len-1,target);
        if (n == -1){
            for (int i = 0; i < len; i++) {
                if (target < A[i]){
                    return i;
                }
            }
            return len;
        }else {
            return n;
        }
    }

    public static int f(int[] a,int left,int right,int num )
    {
        int i=(right-left)/2+left;
        if(a[i]==num)
        {
            return i;
        }
        if(left>=right)
            return -1;
        else if(num<a[i])
            return f(a,left,i-1,num);
        else if(num>a[i])
            return f(a,i+1,right,num);
        return -1;
    }
}
