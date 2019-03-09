import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] a = new int[]{5,2,4,7,6,10,1,3,8,9};
        insertion_sort(a);
        for(int i:a){
            System.out.println(i);
        }
    }

    public static void insertion_sort(int[] a){
        int i=0;
        int j=0;
        int k=0;
        for(j=1;j<a.length;j++){
//            for(int o:a){
//                System.out.print(o+"\t");
//            }
//            System.out.println();
            k=a[j];
            i=j-1;
            while(i>=0&&a[i]>k){
                a[i+1]=a[i];    //如果后一个小于前一个就换位
                i=i-1;  //继续往前计算
            }
            a[i+1]=k;
        }
    }
}
