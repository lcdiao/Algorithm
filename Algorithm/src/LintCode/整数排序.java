package LintCode;

/**
 * Created by diao on 2019/3/14
 */
public class 整数排序 {
    public static void main(String[] args) {

    }

    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        quick_sort2(A,0,A.length-1);
    }

    public static void quick_sort2(int[] a,int left,int right){

        if(left<right){
            int i=left;
            int j=right;
            int temp = a[left];//基准
            while(i!=j){        //先从右往左（注意顺序!）找比基准大的数，在从左往右找比基准数小的数，然后交换，最后将基准数与"中间值"交换,继续递归
                while(a[j]>=temp&&i<j){j--;}
                while(a[i]<=temp&&i<j){i++;}
                if(i<j){
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
            a[left]=a[i];
            a[i]=temp;
            quick_sort2(a,left,i-1);
            quick_sort2(a,i+1,right);
        }
    }
}
