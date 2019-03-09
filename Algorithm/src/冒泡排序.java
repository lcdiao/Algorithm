public class 冒泡排序 {
    public static void main(String[] args) {
        int[] a = new int[]{5,2,4,7,6,10,1,3,8,9};

        bubble_sort(a);
        for(int i:a){
            System.out.println(i);
        }
    }

    //原理：比较两个相邻的元素，将值大的元素交换至右端。
    public static void bubble_sort(int[] a){
        int len = a.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(a[j]>a[j+1]){
                    a[j]^=a[j+1];
                    a[j+1]^=a[j];       //交换
                    a[j]^=a[j+1];
                }
            }
        }
    }
}
