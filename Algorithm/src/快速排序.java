import java.util.Date;

public class 快速排序 {
    public static void main(String[] args) {
        int[] a = new int[]{5,2,4,7,6,10,1,3,8,9,-1,456,-77,4,54,-654,564,-658798,564,111,0,46,-4,4,54,57,3,4,9,987,-4};
        for(int i:a){
            System.out.print(i+"\t");
        }
        System.out.println();
        Long l1 = System.currentTimeMillis();
        quick_sort(a,0,a.length-1);
        //quick_sort2(a,0,a.length-1);
        Long l2 = System.currentTimeMillis();
        System.out.println("用时:"+(l2-l1)+"毫秒");
        for(int i:a){
            System.out.print(i+"\t");
        }
    }


    public static void quick_sort(int[] a,int l,int r){
        if(l<r){
            int q = partition(a,l,r);   //进行分区
            quick_sort(a,l,q-1);
            quick_sort(a,q+1,r);
        }

    }
    public static int partition(int[] a,int l,int r){
        int x = a[r];       //以a[r]为基准
        int i = l-1;
        for(int j=l;j<r;j++){   //从左到右遍历
            if(a[j]<=x){    //如果小于基准数，与第一(i)位交换
                i=i+1;
                int t =a[i];
                a[i]=a[j];
                a[j]=t;
//                a[i]^=a[j];       //下标相同时候不应该进行异或交换！！！！！！！！！！！！！！！
//                a[j]^=a[i];
//                a[i]^=a[j];
            }
        }
        int t =a[i+1];
        a[i+1]=a[r];
        a[r]=t;
        return i+1;
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
